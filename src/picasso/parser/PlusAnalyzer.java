package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.tokens.NumberToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.PlusToken;

/**
 * Handles parsing the plus or "addition function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class PlusAnalyzer implements SemanticAnalyzerInterface {
	
	private static PlusAnalyzer singleton;

	public static PlusAnalyzer getInstance() {
		if (singleton == null) {
			singleton = new PlusAnalyzer();
		}
		return singleton;
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// Remove the plus token
		Token ptoken = (Token) tokens.pop(); 
		
		System.out.println(ptoken.toString());
		
		if (ptoken.toString() != "Character: +") {
			throw new ParseException("Not the plus function.");
		}
		
		// the parameters are the next tokens on the stack.
		//IdentfierToken vtoken = (IdentifierToken) tokens.pop();
		
		// But, they need to be processed
		//if (vtoken.toString() != "Variable Token: ") {
		//	throw new ParseException("Not a variable.");
		//}
		
		// TODO: Need to finish.
		return new Addition(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens), SemanticAnalyzer.getInstance().generateExpressionTree(
						tokens) );
	}

}
