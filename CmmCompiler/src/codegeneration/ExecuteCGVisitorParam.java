package codegeneration;

public class ExecuteCGVisitorParam {

    private CodeGenerator cg;
    private int bytesReturn;
    private int bytesLocals;
    private int bytesParams;

    public ExecuteCGVisitorParam(CodeGenerator cg) {
        this(cg, 0, 0, 0);
    }

    public ExecuteCGVisitorParam(CodeGenerator cg, int bytesReturn, int bytesLocals, int bytesParams) {
        this.cg = cg;
        this.bytesReturn = bytesReturn;
        this.bytesLocals = bytesLocals;
        this.bytesParams = bytesParams;
    }

    public CodeGenerator getCodeGenerator() {
        return cg;
    }

    public int getBytesReturn() {
        return bytesReturn;
    }

    public int getBytesLocals() {
        return bytesLocals;
    }

    public int getBytesParams() {
        return bytesParams;
    }

}

