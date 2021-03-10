package tests;

/**
 * A test unit for the Patron class
 *
 * @author Aliana Tejeda & Bem Iordaah
 */

import hmwk5.Patron;
import hmwk5.HeapQueue;
import org.junit.Test;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class PatronTest {

    Patron p , p1;
    HeapQueue h;

    /**
     * Test getName method
     * Assert expected behaviour i.e. retrieve patron name
     */

    @Test
    public void getName() {
        p = new Patron(9, true, "Idris Elba");
        assertEquals("Idris Elba", p.getName());
    }

    /**
     * Test setName method
     * Assert expected behaviour i.e. change patron name
     */

    @Test
    public void setName() {
        p = new Patron(9, true, "Idris Elba");
        p.setName("Sam Cooke");
        assertEquals("Sam Cooke", p.getName());
    }

    /**
     * Test getCoolness method
     * Assert expected behaviour i.e. get coolness factor
     */

    @Test
    public void getCoolness() {
        p = new Patron(9, true, "Idris Elba");
        assertEquals(9, p.getCoolness(), 0);
    }

    /**
     * Test setCoolness method
     * Assert expected behaviour i.e. change coolness factor
     */

    @Test
    public void setCoolness() {
        p = new Patron(9, true, "Idris Elba");
        p.setCoolness(7);
        assertEquals(7, p.getCoolness());
    }

    /**
     * Test isRegular method
     * Assert expected behaviour i.e. patron is regular
     */

    @Test
    public void isRegular() {
        p = new Patron(9, true, "Idris Elba");
        assertTrue(p.isRegular());
    }

    /**
     * Test Queue method
     * Put patrons in queue, remove patrons, ensure patrons are admitted in correct
     */

    @Test
    public void Queue() {
        h = new HeapQueue();
        h.enqueue(new Patron(9, true, "Idris Elba"));
        h.enqueue(new Patron(6, true, "Bobby Flay"));
        h.enqueue(new Patron(10, false, "Shawn Mendez"));
        h.enqueue(new Patron(2, true, "Lebron James"));

        p = (Patron) h.dequeue();
        assertEquals("Shawn Mendez", p.getName());

        p = (Patron) h.dequeue();
        assertEquals("Idris Elba", p.getName());

        p = (Patron) h.dequeue();
        assertEquals(6, p.getCoolness());
    }

    /**
     * Test Comparison method
     * Compare patrons to each other, prioritize regular patrons for
     * admission over non-regular patrons
     */

    @Test
    public void Comparison() {
        h = new HeapQueue();
        h.enqueue(new Patron(9, true, "Idris Elba"));
        h.enqueue(new Patron(9, false, "Potato Head"));
        h.enqueue(new Patron(10, true, "Cesar Milan"));

        p = (Patron) h.dequeue();

        assertEquals(-1, p.compareTo(p));

    }
}