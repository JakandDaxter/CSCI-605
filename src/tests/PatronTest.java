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

    Patron p , p1;
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

    //put people in queue, take them out and make sure they are addmited in correct order
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