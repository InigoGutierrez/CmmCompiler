import ast.Program;
import codegeneration.CodeGenerator;
import codegeneration.ExecuteCGVisitor;
import semantic.OffsetVisitor;
import errorhandler.ErrorHandler;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;

import org.antlr.v4.runtime.*;
import parser.gen.CmmLexer;
import parser.gen.CmmParser;
import semantic.IdentificationVisitor;
import semantic.TypeCheckingVisitor;

import java.io.FileWriter;

public class Main {

	public static void main(String... args) throws Exception {
		   if (args.length<2) {
		        System.err.println("Please, pass me both the input file and the destination of output.");
		        return;
		    }

		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CmmParser parser = new CmmParser(tokens);

		Program root = parser.program().ast;

		new IdentificationVisitor().visit(root, null);
		new TypeCheckingVisitor().visit(root, null);
		new OffsetVisitor().visit(root, null);

		if (ErrorHandler.getInstance().anyError()) {
			ErrorHandler.getInstance().showErrors(System.err);
		}
		else {
			CodeGenerator cg = new CodeGenerator(args[1]);
			cg.writeCode("#source \"" + args[0] + "\"");
			new ExecuteCGVisitor().visit(root, cg);
			cg.close();
		}


	IntrospectorModel model = new IntrospectorModel("Root", root);
		new IntrospectorTree("Tree", model);
	}

}

