package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes two arguments.
 * 
 * @author Linkimals
 *
 */
public abstract class BinaryFunction extends ExpressionTreeNode {

	ExpressionTreeNode param;
	ExpressionTreeNode param2;

	/**
	 * 
	 * @param param
	 */
	public BinaryFunction(ExpressionTreeNode param, ExpressionTreeNode param2) {
		this.param = param;
		this.param2 = param2;
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass() + ": " + param + param2;
	}
}
