package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of creating an expression tree from a string expression. Will have
 * compiler errors until some code is created.
 * 
 * @author Sara Sprenkle
 * 
 */
public class ParsedExpressionTreeTests {

	private ExpressionTreeGenerator parser;

	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void constantExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("[1,-1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
	}

	@Test
	public void variableExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x");
		assertEquals(new X(), e);
	}

	@Test
	public void additionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x + y");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Addition(new RGBColor(1, .3, -1), new Y()), e);
		
		e = parser.makeExpression("x + y + [ -.51, 0, 1]");
		assertEquals(new Addition(new Addition(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}
	
	@Test
	public void minusExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x - y");
		assertEquals(new Subtraction(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] - y");
		assertEquals(new Subtraction(new RGBColor(1, .3, -1), new Y()), e);
		
		e = parser.makeExpression("x - y - [ -.51, 0, 1]");
		assertEquals(new Subtraction(new Subtraction(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}
	
	@Test
	public void divisionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x/y");
		assertEquals(new Division(new X(), new Y()), e);
		
		e = parser.makeExpression("y/x");
		assertEquals(new Division(new Y(), new X()), e);
		
		e = parser.makeExpression("x/[0, 0, 0]");
		assertEquals(new Division(new X(), new RGBColor(0, 0, 0)), e);
	}
	
	@Test
	public void exponentiatesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x^y");
		assertEquals(new Exponentiate(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1]^y");
		assertEquals(new Exponentiate(new RGBColor(1, .3, -1), new Y()), e);
	}

	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("( x + y )");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		assertEquals(new Addition(new X(), new Addition(new Y(), new RGBColor(1, 1, 1))), e);
	}

	@Test
	public void floorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("floor( x )");
		assertEquals(new Floor(new X()), e);

		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Floor(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void absFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("abs( x )");
		assertEquals(new Absolute(new X()), e);

		e = parser.makeExpression("abs( x + y )");
		assertEquals(new Absolute(new Addition(new X(), new Y())), e);
	}
}
