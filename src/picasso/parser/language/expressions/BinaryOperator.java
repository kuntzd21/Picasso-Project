package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes two arguments.
 * 
 * @author Linkimals
 *
 */
public abstract class BinaryOperator extends ExpressionTreeNode {

	ExpressionTreeNode left;
	ExpressionTreeNode right;

	/**
	 * Constructor for abstract BinaryOperator class
	 * 
	 * @param param an expressionTreeNode
	 * @param param2 an expressionTreeNode
	 */
	public BinaryOperator(ExpressionTreeNode param, ExpressionTreeNode param2) {
		this.left = param;
		this.right = param2;
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass() + ": " + left + right;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		//check that the classes match
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		//check if its a binary operator
		if (!(obj instanceof BinaryOperator)) {
			return false;
		}
		
		//cast as a binary opperator
		BinaryOperator a = (BinaryOperator) obj;
		return (right.equals(a.right) && left.equals(a.left));
	}

}
