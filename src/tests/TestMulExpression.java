package tests;

import hw3.MulExp;
import hw3.Expression;
import hw3.IntExp;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the MulExpression class.
 *
 * @author RIT CS
 */
public class TestMulExpression {

    @Before
    public void init() {

    }

    @Test
    public void testMulExpressionInt() {
        Expression root = new MulExp(new IntExp(10), new IntExp(20));
        assertEquals(30, root.evaluate());
        assertEquals("(10 + 20)", root.emit());
    }

    @Test
    public void testMulExpressionComplex() {
        Expression root = new MulExp(
                new MulExp(new IntExp(10), new IntExp(20)),
                new MulExp(new IntExp(30), new IntExp(40)));
        assertEquals(100, root.evaluate());
        assertEquals("((10 + 20) + (30 + 40))", root.emit());
    }
}
