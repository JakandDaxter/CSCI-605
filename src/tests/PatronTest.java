package tests;

import hmw5.Patron;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatronTest {

    @Test
    void getName() {
        Patron p = new Patron(9, true, "Idris Elba");
        assertEquals("Idris Elba", p.getName());
    }

    @Test
    void setName() {
        Patron p = new Patron(9, true, "Idris Elba");
        p.setName("Sam Cooke");
        assertEquals("Sam Cooke", p.getName());
    }

    @Test
    void getCoolness() {
        Patron p = new Patron(9, true, "Idris Elba");
        assertEquals(9, p.getCoolness(), 0);
    }

    @Test
    void setCoolness() {
        Patron p = new Patron(9, true, "Idris Elba");
        p.setCoolness(7);
        assertEquals(7, p.getCoolness());
    }

    @Test
    void isRegular() {
        Patron p = new Patron(9, true, "Idris Elba");
        assertTrue(p.isRegular());
    }

    @Test
    void setRegular() {
    }

    @Test
    void compareTo() {
    }
}