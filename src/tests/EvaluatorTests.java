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
	}
	
	@Test
	public void testConstantEvaluationOutOfRange() {
		assertThrows(IllegalArgumentException.class, () -> {
			ExpressionTreeNode e = parser.makeExpression("[1.2, -1, 1]");
			});
		assertThrows(IllegalArgumentException.class, () -> {
			ExpressionTreeNode etn = parser.makeExpression("[2, -2, 0]");
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
	
	@Test
	public void testAbsEvaluation() {
		Abs testabs = new Abs(new X());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.abs(i), Math.abs(i), Math.abs(i)), testabs.evaluate(i, i));
		assertEquals(new RGBColor(1, 1, 1), testabs.evaluate(1, 0));
		}
	}
	
	@Test
	public void testAdditionEvaluation() {
		Addition testadd = new Addition(new X(), new Y());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i + i, i + i, i + i), testadd.evaluate(i, i));
		assertEquals(new RGBColor(1, 1, 1), testadd.evaluate(1, 0));
		}
	}
	
	@Test
	public void testATangentEvaluation() {
		ATangent testatan = new ATangent(new X());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.atan(i), Math.atan(i), Math.atan(i)), testatan.evaluate(i, i));
		assertEquals(new RGBColor(Math.atan(1), Math.atan(1), Math.atan(1)), testatan.evaluate(1, 0));
		}
	}
	
	@Test
	public void testCeilingEvaluation() {
		Ceiling testceil = new Ceiling(new X());
		// for loop with decimal increment to test ceiling
		for (int i = -1; i <= 1; i+=1.5) {
			assertEquals(new RGBColor(Math.ceil(i), Math.ceil(i), Math.ceil(i)), testceil.evaluate(i, i));
		assertEquals(new RGBColor(Math.ceil(1), Math.ceil(1), Math.ceil(1)), testceil.evaluate(1, 0));
		}
	}
	
	@Test
	public void testClampEvaluation() {
		Clamp testclamp = new Clamp(new X());
		assertEquals(new RGBColor(1, 1, 1), testclamp.evaluate(2, 3));
		assertEquals(new RGBColor(-1, -1, -1), testclamp.evaluate(-4, -5));
		}
	
	@Test
	public void testCosineEvaluation() {
		Cosine testcos = new Cosine(new X());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), testcos.evaluate(i, i));
		assertEquals(new RGBColor(Math.cos(1), Math.cos(1), Math.cos(1)), testcos.evaluate(1, 0));
		}
	}
	
	@Test
	public void testDivisionEvaluation() {
		Division testdiv = new Division(new X(), new Y());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i / 1, i / 1, i / 1), testdiv.evaluate(i, 1));
		// test division by 0 handling
		assertEquals(new RGBColor(0, 0, 0), testdiv.evaluate(1, 0));
		}
	}
	
	@Test
	public void testExpEvaluation() {
		Exp testexp = new Exp(new X());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), testexp.evaluate(i, i));
		assertEquals(new RGBColor(Math.exp(1), Math.exp(1), Math.exp(1)), testexp.evaluate(1, 0));
		}
	}
	
	@Test
	public void testExponentiateEvaluation() {
		Exponentiate testexpo = new Exponentiate(new X(), new Y());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.pow(i, i), Math.pow(i, i), Math.pow(i, i)), testexpo.evaluate(i, i));
		assertEquals(new RGBColor(Math.pow(1, 0), Math.pow(1, 0), Math.pow(1, 0)), testexpo.evaluate(1, 0));
		}
	}
	
	@Test
	public void testFloorEvaluation() {
		Floor testfloor = new Floor(new X());
		// for loop with decimal increment to test floor
		for (int i = -1; i <= 1; i+=1.5) {
			assertEquals(new RGBColor(Math.floor(i), Math.floor(i), Math.floor(i)), testfloor.evaluate(i, i));
		assertEquals(new RGBColor(Math.floor(1), Math.floor(1), Math.floor(1)), testfloor.evaluate(1, 0));
		}
	}
	
	@Test
	public void testLogEvaluation() {
		Log testlog = new Log(new X());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.log(Math.abs(i)), Math.log(Math.abs(i)), Math.log(Math.abs(i))), testlog.evaluate(i, i));
		assertEquals(new RGBColor(Math.log(1), Math.log(1), Math.log(1)), testlog.evaluate(1, 0));
		}
	}
	
	@Test
	public void testModEvaluation() {
		Modulo testmod = new Modulo(new X(), new Y());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i % 1, i % 1, i % 1), testmod.evaluate(i, 1));
		}
		// test modulo by 0 handling
		assertEquals(new RGBColor(0, 0, 0), testmod.evaluate(1, 0));
	}
	
	@Test
	public void testMultiplicationEvaluation() {
		Multiplication testmult = new Multiplication(new X(), new Y());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i * i, i * i, i * i), testmult.evaluate(i, i));
		assertEquals(new RGBColor(0, 0, 0), testmult.evaluate(1, 0));
		}
	}
	
	// TODO: More tests of evaluation

	
}
