package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents an operator that takes one argument.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Linkimals
 *
 */
public abstract class UnaryOperator extends ExpressionTreeNode {

	ExpressionTreeNode param;

	/**
	 * 
	 * @param param
	 */
	public UnaryOperator(ExpressionTreeNode param) {
		this.param = param;
	}

	/**
	 * Returns the string representation of the operator in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass() + ": " + param;
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
		
		//check if its a unary function
		if (!(obj instanceof UnaryOperator)) {
			return false;
		}
		
		//cast as a binary operator
		UnaryOperator u = (UnaryOperator) obj;
		return param.equals(u.param);
	}
	
}
