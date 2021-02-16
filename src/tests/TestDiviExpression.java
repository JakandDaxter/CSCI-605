package tests;

import hw3.DiviExp;
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
public class TestDiviExpression {

    @Before
    public void init() {

    }

    @Test
    public void testDiviExpressionInt() {
        Expression root = new DiviExp(new IntExp(10), new IntExp(20));
        assertEquals(30, root.evaluate());
        assertEquals("(10 + 20)", root.emit());
    }

    @Test
    public void testDiviExpressionComplex() {
        Expression root = new DiviExp(
                new DiviExp(new IntExp(10), new IntExp(20)),
                new DiviExp(new IntExp(30), new IntExp(40)));
        assertEquals(100, root.evaluate());
        assertEquals("((10 + 20) + (30 + 40))", root.emit());
    }
}
