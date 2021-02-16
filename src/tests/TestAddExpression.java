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
 * @author RIT CS
 */
public class TestAddExpression {

    String input;
    Expression exp;
    Interp interp ;
    @Before
    public void init() {
        interp = new Interp();
        exp = interp.parseExpression(input);
    }



    @Test
    public void testAddExpressionInt() {
        input = "+ 10 20";
        assertTrue(exp.emit() == "10 + 20");
        assertTrue(exp.evaluate() == 30);

    }

    @Test
    public void testAddExpressionComplex() {
        input = "+ + 10 20 + 30 40";
        assertTrue(exp.emit() == "((10 + 20) + (30 + 40))");
        assertTrue(exp.evaluate() == 30);
    }

    @Test
    public void testEmit(){
        input = "+ - 4 5 6";
        assertEquals(exp.emit(),"((4 - 5) - 6)");
    }

    @Test
    public void testEvaluate(){
        input = "* - 10 4 + 8 6 2";
        assertTrue(exp.evaluate()==40);
    }
}
