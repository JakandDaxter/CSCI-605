package tests;

import hw3.ModExp;
import hw3.Expression;
import hw3.IntExp;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the AddExpression class.
 *
 * @author RIT CS
 */
public class TestModExpression {

    @Before
    public void init() {

    }

    @Test
    public void testAddExpressionInt() {
        Expression root = new ModExp(new IntExp(10), new IntExp(20));
        assertEquals(30, root.evaluate());
        assertEquals("(10 + 20)", root.emit());
    }

    @Test
    public void testAddExpressionComplex() {
        Expression root = new ModExp(
                new ModExp(new IntExp(10), new IntExp(20)),
                new ModExp(new IntExp(30), new IntExp(40)));
        assertEquals(100, root.evaluate());
        assertEquals("((10 + 20) + (30 + 40))", root.emit());
    }
}
