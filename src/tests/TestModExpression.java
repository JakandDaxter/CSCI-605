package tests;

import hw3.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the ModExpression class.
 *
 * @author Aliana Tejeda & Bem Lordaah
 */
public class TestModExpression {

    Expression exp;
    Interp interp ;

    @Before
    public void init() {
        interp = new Interp();
    }

    //**** Testing Interp Functionality ***\\
    @Test
    public void testEmit(){
        exp = interp.parseExpression("% % 18 6 3");
        assertEquals(exp.emit(),"((18 % 6) % 3)");
    }

    @Test
    public void testEvaluate(){
        exp = interp.parseExpression("% 40 3");
        assertEquals(exp.evaluate(),1);
    }

    @Test
    public void testBadInput(){
        assertTrue(!interp.isNumber("B 4 / 8 6 2"));
    }

    @Test
    public void testGoodInput(){
        assertTrue(!interp.isNumber("4 / 8 6 2"));
    }

    //**** Testing ModExp() Functionality ***\\
    @Test
    public void testModExpressionInt() {
        Expression root = new ModExp(new IntExp(45), new IntExp(89));
        assertEquals(45, root.evaluate());
        assertEquals("(45 % 89)", root.emit());
    }

    @Test
    public void testModExpressionComplex() {
        Expression root = new ModExp(
                new ModExp(new IntExp(27), new IntExp(9)),
                new ModExp(new IntExp(9), new IntExp(27)));
        assertEquals(0, root.evaluate());
        assertEquals("((27 % 9) / (9 % 27))", root.emit());
    }
}
