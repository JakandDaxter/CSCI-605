package tests;

import hw3.SubExp;
import hw3.IntExp;
import hw3.Interp;
import hw3.Expression;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the SubExpression class.
 *
 * @author Aliana Tejeda & Bem Lordaah
 */
public class TestSubExpression {

    Expression exp;
    Interp interp ;

    @Before
    public void init() {
        interp = new Interp();
    }

    //**** Testing Interp Functionality ***\\
    @Test
    public void testEmit(){
        exp = interp.parseExpression("- - 4 5 6");
        assertEquals(exp.emit(),"((4 - 5) - 6)");
    }

    @Test
    public void testEvaluate(){
        exp = interp.parseExpression("* - 10 4 - 8 6 ");
        assertEquals(exp.evaluate(),12);
    }

    @Test
    public void testBadInput(){
        assertTrue(!interp.isNumber("B 4 + 8 6 2"));
    }

    @Test
    public void testGoodInput(){
        assertTrue(!interp.isNumber("4 + 8 6 2"));
    }

    //**** Testing SubExp Functionality ***\\
    @Test
    public void testSubExpressionInt() {
        Expression root = new SubExp(new IntExp(10), new IntExp(20));
        assertEquals(-10, root.evaluate());
        assertEquals("(10 - 20)", root.emit());
    }

    @Test
    public void testSubExpressionComplex() {
        Expression root = new SubExp(
                new SubExp(new IntExp(40), new IntExp(30)),
                new SubExp(new IntExp(20), new IntExp(10)));
        assertEquals(0, root.evaluate());
        assertEquals("((40 - 30) - (20 - 10))", root.emit());
    }
}

