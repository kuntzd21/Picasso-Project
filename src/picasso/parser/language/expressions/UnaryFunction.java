package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes one argument.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 *
 */
public abstract class UnaryFunction extends ExpressionTreeNode {

	ExpressionTreeNode param;

	/**
	 * 
	 * @param param
	 */
	public UnaryFunction(ExpressionTreeNode param) {
		this.param = param;
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
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
		if (!(obj instanceof UnaryFunction)) {
			return false;
		}
		
		//cast as a binary operator
		UnaryFunction u = (UnaryFunction) obj;
		return param.equals(u.param);
	}
	
}
