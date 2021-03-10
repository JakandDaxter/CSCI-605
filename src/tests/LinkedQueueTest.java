package tests;

import hmwk5.LinkedQueue;
import hmwk5.Patron;
import org.junit.Test;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the ------- class.
 *
 * * @author Aliana Tejeda & Bem Lordaah
 */

public class LinkedQueueTest {

    Patron p ;
    LinkedQueue L;

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
        L = new LinkedQueue();
        L.enqueue(new Patron(9, true, "Idris Elba"));
        L.enqueue(new Patron(6, true, "Bobby Flay"));
        L.enqueue(new Patron(10, false, "Shawn Mendez"));
        L.enqueue(new Patron(2, true, "Lebron James"));

        p = (Patron) L.dequeue();
        assertEquals("Lebron James", p.getName());

        p = (Patron) L.dequeue();
        assertEquals("Shawn Mendez", p.getName());

        p = (Patron) L.dequeue();
        assertEquals(6, p.getCoolness());
    }


    @Test
    public void Comparison() {
        L = new LinkedQueue();
        L.enqueue(new Patron(9, true, "Idris Elba"));
        L.enqueue(new Patron(9, false, "Potato Head"));
        L.enqueue(new Patron(10, true, "Cesar Milan"));

        p = (Patron) L.dequeue();

        assertEquals(-1, p.compareTo(p));

    }
}