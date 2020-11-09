/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of the evaluation of x
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {

	private ExpressionTreeGenerator parser;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("[1, -1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
		ExpressionTreeNode etn = parser.makeExpression("[2, -2, 0]");
		assertEquals(new RGBColor(1, -1, 0), etn);
	}
	
	@Test
	public void testConstantEvaluationOutOfRange() {
		assertThrows(IllegalArgumentException.class, () -> {
			ExpressionTreeNode e = parser.makeExpression("[1.2, -1, 1]");
			});
	}
		
	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		assertEquals(new RGBColor(1, 1, 1), x.evaluate(1, 0));
		}
	}
	
	@Test
	public void testYEvaluation() {
		Y y = new Y();
		assertEquals(new RGBColor(-1, -1, -1), y.evaluate(1, -1));
	}
	
	
	// TODO: More tests of evaluation

	
}
