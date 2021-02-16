package tests;

import hw3.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the DiviExpression class.
 *
 * @author Aliana Tejeda & Bem Lordaah
 */
public class TestDiviExpression {

    Expression exp;
    Interp interp ;

    @Before
    public void init() {
        interp = new Interp();
    }

    //**** Testing Interp Functionality ***\\
    @Test
    public void testEmit(){
        exp = interp.parseExpression("/ / 18 6 3");
        assertEquals(exp.emit(),"((18 / 6) / 3)");
    }

    @Test
    public void testEvaluate(){
        exp = interp.parseExpression("/ / 60 2 / 30 2");
        assertEquals(exp.evaluate(),2);
    }

    @Test
    public void testBadInput(){
        assertTrue(!interp.isNumber("B 4 / 8 6 2"));
    }

    @Test
    public void testGoodInput(){
        assertTrue(!interp.isNumber("4 / 8 6 2"));
    }

    //**** Testing DiviExp Functionality ***\\
    @Test
    public void testDiviExpressionInt() {
        Expression root = new DiviExp(new IntExp(20), new IntExp(10));
        assertEquals(2, root.evaluate());
        assertEquals("(20 / 10)", root.emit());
    }

    @Test
    public void testDiviExpressionComplex() {
        Expression root = new DiviExp(
                new DiviExp(new IntExp(40), new IntExp(5)),
                new DiviExp(new IntExp(4), new IntExp(2)));
        assertEquals(4, root.evaluate());
        assertEquals("((40 / 5) / (4 / 2))", root.emit());
    }
}
