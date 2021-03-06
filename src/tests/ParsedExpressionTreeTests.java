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
	public void negateExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("!x");
		assertEquals(new Negation(new X()), e);
		
		e = parser.makeExpression("!(y/x)");
		assertEquals(new Negation(new Division(new Y(), new X())), e);
	}
	
	@Test
	public void moduloExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x%y");
		assertEquals(new Modulo(new X(), new Y()), e);
		
		e = parser.makeExpression("y%x");
		assertEquals(new Modulo(new Y(), new X()), e);
		
		e = parser.makeExpression("x%[0, 0, 0]");
		assertEquals(new Modulo(new X(), new RGBColor(0, 0, 0)), e);
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
		assertEquals(new Abs(new X()), e);

		e = parser.makeExpression("abs( x + y )");
		assertEquals(new Abs(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void cosFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("cos( x )");
		assertEquals(new Cosine(new X()), e);

		e = parser.makeExpression("cos( x + y )");
		assertEquals(new Cosine(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void logFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("log( x )");
		assertEquals(new Log(new X()), e);

		e = parser.makeExpression("log( x + y )");
		assertEquals(new Log(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void sinFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("sin( x )");
		assertEquals(new Sine(new X()), e);

		e = parser.makeExpression("sin( x + y )");
		assertEquals(new Sine(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void tanFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("tan( x )");
		assertEquals(new Tangent(new X()), e);

		e = parser.makeExpression("tan( x + y )");
		assertEquals(new Tangent(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void atanFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("atan( x )");
		assertEquals(new ATangent(new X()), e);

		e = parser.makeExpression("atan( x + y )");
		assertEquals(new ATangent(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void wrapFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("wrap( x )");
		assertEquals(new Wrap(new X()), e);

		e = parser.makeExpression("wrap( x + y )");
		assertEquals(new Wrap(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void clampFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("clamp( x )");
		assertEquals(new Clamp(new X()), e);

		e = parser.makeExpression("clamp( x + y )");
		assertEquals(new Clamp(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void perlinBWFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("perlinBW( x , y )");
		assertEquals(new PerlinBW(new X(), new Y()), e);

		e = parser.makeExpression("perlinBW( x + y , x)");
		assertEquals(new PerlinBW(new Addition(new X(), new Y()), new X()), e);
	}
	
	@Test
	public void perlinColorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("perlinColor( x , y )");
		assertEquals(new PerlinColor(new X(), new Y()), e);

		e = parser.makeExpression("perlinColor( x + y , x)");
		assertEquals(new PerlinColor(new Addition(new X(), new Y()), new X()), e);
	}
	
	@Test
	public void randomFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("random()");
		assertEquals(new Random(), e);

		e = parser.makeExpression("perlinColor( random(), x)");
		assertEquals(new PerlinColor(new Random(), new X()), e);
	}

	@Test
	public void negateOperatorTests() {
		ExpressionTreeNode e = parser.makeExpression("!x");
		assertEquals(new Negation(new X()), e);
		
		e = parser.makeExpression("!(x * y)");
		assertEquals(new Negation(new Multiplication(new X(), new Y())), e);
	}
	
	@Test
	public void RgbToYCrCbFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("rgbToYCrCb(x+y)");
		assertEquals(new RgbToYCrCb(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void YCrCbtoRGBFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("yCrCbtoRGB(x+y)");
		assertEquals(new YCrCbtoRGB(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void mandelbrotTest(){
		ExpressionTreeNode e = parser.makeExpression("mandelbrot()");
		assertEquals(new Mandelbrot(), e);
		}
	
	@Test
	public void juliaTest(){
		ExpressionTreeNode e = parser.makeExpression("julia()");
		assertEquals(new Julia(), e);
		}

	@Test
	public void ImageWrapFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("imageWrap(\"images/AmoebaMorris.png\", x, y)");
		assertEquals(new ImageWrap(new Image(new String()), new X(), new Y()), e);
		
		e = parser.makeExpression("imageWrap(\"images/AmoebaMorris.png\", x + x, y)");
		assertEquals(new ImageWrap(new Image(new String()), new Addition(new X(), new X()), new Y()), e);
	}

	@Test
	public void ImageClipFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("imageClip(\"images/AmoebaMorris.png\", x, y)");
		assertEquals(new ImageClip(new Image(new String()), new X(), new Y()), e);
		
		e = parser.makeExpression("imageClip(\"images/AmoebaMorris.png\", x + x, y)");
		assertEquals(new ImageClip(new Image(new String()), new Addition(new X(), new X()), new Y()), e);
	}
}
