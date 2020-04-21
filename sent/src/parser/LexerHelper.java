package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
	    if (str.length() == 3)
			return str.charAt(1);
	    else if ( str.equals("'\\n'") )
			return '\n';
		else if ( str.equals("'\\t'") )
			return '\t';
		else if ( str.matches("^'\\\\[0-9]+'$") ) {
			return (char) Integer.parseInt(str.substring(2, str.length() - 1));
		}
		else
			return '\0';
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			try {
				if (!str.matches("[0-9]+\\.[0-9]*[eE][-+]?[0-9]+"))
					throw e;
				String[] parts = str.split("[eE]");
				return Math.pow(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
			}
			catch(NumberFormatException e2) {
				System.out.println(e2);
			}
		}
		return -1;
	}

}
