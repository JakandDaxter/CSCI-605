package tests;

import hw3.SubExp;
import hw3.Interp;
import hw3.Expression;
import hw3.IntExp;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the SubExpression class.
 *
 * @author RIT CS
 */
public class TestSubExpression {

    @Before
    public void init() {
        Interp interp = new Interp();


    }

    @Test
    public void testSubExpressionInt() {
        Expression root = new SubExp(new IntExp(20), new IntExp(10));
        assertEquals(10, root.evaluate());
        assertEquals("(20 - 10)", root.emit());
    }

    @Test
    public void testSubExpressionComplex() {
        Expression root = new SubExp(
                new SubExp(new IntExp(40), new IntExp(20)),
                new SubExp(new IntExp(4), new IntExp(4)));
        assertEquals(100, root.evaluate());
        assertEquals("((40 - 20) - (4 - 4))", root.emit());
    }
}

