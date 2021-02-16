package tests;

import hw3.AddExp;
import hw3.Expression;
import hw3.IntExp;
import hw3.Interp;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the AddExpression class.
 *
 * * @author Aliana Tejeda & Bem Lordaah
 */
public class TestAddExpression {

    Expression exp;
    Interp interp ;

    @Before
    public void init() {
        interp = new Interp();
    }

    //**** Testing Interp Functionality ***\\
    @Test
    public void testEmit(){
        exp = interp.parseExpression("+ + 4 5 6");
        assertEquals(exp.emit(),"((4 + 5) + 6)");
    }

    @Test
    public void testEvaluate(){
        exp = interp.parseExpression("* - 10 4 + 8 6 ");
        assertEquals(exp.evaluate(),84);
    }

    @Test
    public void testBadInput(){
        assertTrue(!interp.isNumber("B 4 + 8 6 2"));
    }

    @Test
    public void testGoodInput(){
        assertTrue(!interp.isNumber("4 + 8 6 2"));
    }

    //**** Testing AddExp Functionality ***\\
    @Test
    public void testAddExpressionInt() {
        Expression root = new AddExp(new IntExp(10), new IntExp(20));
        assertEquals(30, root.evaluate());
        assertEquals("(10 + 20)", root.emit());
    }

    @Test
    public void testAddExpressionComplex() {
        Expression root = new AddExp(
                new AddExp(new IntExp(10), new IntExp(20)),
                new AddExp(new IntExp(30), new IntExp(40)));
        assertEquals(100, root.evaluate());
        assertEquals("((10 + 20) + (30 + 40))", root.emit());
    }
}
