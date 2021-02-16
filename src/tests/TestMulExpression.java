package tests;

import hw3.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the MulExpression class.
 *
 * @author Aliana Tejeda & Bem Lordaah
 */
public class TestMulExpression {

    Expression exp;
    Interp interp ;

    @Before
    public void init() {
        interp = new Interp();
    }

    //**** Testing Interp Functionality ***\\
    @Test
    public void testEmit(){
        exp = interp.parseExpression("* * 18 6 3");
        assertEquals(exp.emit(),"((18 * 6) * 3)");
    }

    @Test
    public void testEvaluate(){
        exp = interp.parseExpression("* * 60 2 * 30 2");
        assertEquals(exp.evaluate(),7200);
    }

    @Test
    public void testBadInput(){
        assertTrue(!interp.isNumber("B 4 * 8 6 2"));
    }

    @Test
    public void testGoodInput(){
        assertTrue(!interp.isNumber("4 * 8 6 2"));
    }

    //**** Testing MulExp Functionality ***\\
    @Test
    public void testMulExpressionInt() {
        Expression root = new MulExp(new IntExp(20), new IntExp(10));
        assertEquals(200, root.evaluate());
        assertEquals("(20 * 10)", root.emit());
    }

    @Test
    public void testMulExpressionComplex() {
        Expression root = new MulExp(
                new MulExp(new IntExp(4), new IntExp(5)),
                new MulExp(new IntExp(10), new IntExp(20)));
        assertEquals(4000, root.evaluate());
        assertEquals("((4 * 5) * (10 * 20))", root.emit());
    }
}
