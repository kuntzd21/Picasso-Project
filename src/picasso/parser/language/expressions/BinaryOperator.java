package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes two arguments.
 * 
 * @author Nick Steinert
 *
 */
public abstract class BinaryOperator extends ExpressionTreeNode {

	ExpressionTreeNode left;
	ExpressionTreeNode right;

	/**
	 * Constructor for abstract BinaryOperator class
	 * 
	 * @param left an expressionTreeNode
	 * @param right an expressionTreeNode
	 */
	public BinaryOperator(ExpressionTreeNode left, ExpressionTreeNode right) {
		this.left = left;
		this.right = right;
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
		
		//cast as a binary operator
		BinaryOperator a = (BinaryOperator) obj;
		return (right.equals(a.right) && left.equals(a.left));
	}

}
