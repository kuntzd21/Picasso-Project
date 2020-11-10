package picasso.parser.tokens;

/**
 * Represents a string
 * 
 * @author Nick Steinert
 * 
 */
public class StringToken extends Token {

	private final String myString;

	public StringToken(String value) {
		super("String Token");
		myString = value;
	}

	public boolean equals(Object o) {
		if( o == this ) {
			return true;
		}
		if (!(o instanceof StringToken)) {
			return false;
		}
		StringToken rhs = (StringToken) o;
		return myString.equals(rhs.myString);
	}

	public String getString() {
		return myString;
	}

	public String toString() {
		return super.toString() + ": " + myString;
	}

	@Override
	public boolean isConstant() {
		return true;
	}

	@Override
	public boolean isFunction() {
		return false;
	}

}
