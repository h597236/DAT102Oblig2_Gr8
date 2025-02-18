package no.dat.hvl102.oppg1;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

public class ParentesSjekkerTest {

    private final ParentesSjekker sjekker = new ParentesSjekker();

    @Test
    void testBalanserteParenteser() {
        assertTrue(sjekker.sjekkParenteser("()"));
        assertTrue(sjekker.sjekkParenteser("({[]})"));
        assertTrue(sjekker.sjekkParenteser("{[()]}"));
        assertTrue(sjekker.sjekkParenteser("((({}[])))"));
    }

    @Test
    void testUbalanserteParenteser() {
        assertFalse(sjekker.sjekkParenteser("("));
        assertFalse(sjekker.sjekkParenteser(")"));
        assertFalse(sjekker.sjekkParenteser("({[})]"));
        assertFalse(sjekker.sjekkParenteser("{[(()]}"));
        assertFalse(sjekker.sjekkParenteser("(()))"));
    }

    @Test
    void testTomStreng() {
        assertTrue(sjekker.sjekkParenteser(""));
    }

    @Test
    void testIngenParenteser() {
        assertTrue(sjekker.sjekkParenteser("Hello, World!"));
    }
}
