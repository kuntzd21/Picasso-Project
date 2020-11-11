package picasso.parser.tokens.operations;

/**
 * A marker interface
 * 
 */
public interface OperationInterface {
	
	//order of operations precedence
	public static final int CONSTANT = 0;
	public static final int ADD_OR_SUBTRACT = 1;
	public static final int MULTIPLY_DIVIDE_MOD = 2;
	public static final int EXPONENTIATION = 3;
	public static final int NEGATE = 4;
	public static final int GROUPING = 5;
	
	public int getPrecedence();
	
}
