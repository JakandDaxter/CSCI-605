package tests;

import hw3.Expression;
import hw3.IntExp;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the IntExpression class.
 *
 * @author RIT CS
 */
public class TestIntExpression {


    @Test
    public void testIntExpression() {
        Expression root = new IntExp(10);
        assertEquals(10, root.evaluate());
        assertEquals("10", root.emit());
    }

}
