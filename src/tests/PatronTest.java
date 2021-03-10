package tests;

import hmwk5.Patron;
import hmwk5.HeapQueue;
import org.junit.Test;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the ------- class.
 *
 * * @author Aliana Tejeda & Bem Lordaah
 */

public class PatronTest {

    Patron p;
    HeapQueue h;

    @Test
    public void getName() {
        p = new Patron(9, true, "Idris Elba");
        assertEquals("Idris Elba", p.getName());
    }

    @Test
    public void setName() {
        p = new Patron(9, true, "Idris Elba");
        p.setName("Sam Cooke");
        assertEquals("Sam Cooke", p.getName());
    }

    @Test
    public void getCoolness() {
        p = new Patron(9, true, "Idris Elba");
        assertEquals(9, p.getCoolness(), 0);
    }

    @Test
    public void setCoolness() {
        p = new Patron(9, true, "Idris Elba");
        p.setCoolness(7);
        assertEquals(7, p.getCoolness());
    }

    @Test
    public void isRegular() {
        p = new Patron(9, true, "Idris Elba");
        assertTrue(p.isRegular());
    }

    @Test
    public void Queue() {
        h.enqueue(new Patron(9, true, "Idris Elba"));
        h.enqueue(new Patron(6, true, "Bobby Flay"));
        h.enqueue(new Patron(10, false, "Shawn Mendez"));
        h.enqueue(new Patron(2, true, "Lebron James"));

        p = (Patron) h.dequeue();

        System.out.println(p.getName());
    }


    @Test
    public void Comparison() {
        h.enqueue(new Patron(9, true, "Idris Elba"));
        h.enqueue(new Patron(6, true, "Idris Elba"));
    }
}