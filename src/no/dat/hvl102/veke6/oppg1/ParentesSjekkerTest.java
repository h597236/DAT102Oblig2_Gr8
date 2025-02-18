package no.dat.hvl102.veke6.oppg1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParentesSjekkerTest {

    @Test
    public void testKorrektParenteser() {
        ParentesSjekker sjekker = new ParentesSjekker();
        assertTrue(sjekker.sjekkParenteser("{ [ ( ) ] }"));
    }

    @Test
    public void testManglerSluttparentes() {
        ParentesSjekker sjekker = new ParentesSjekker();
        assertFalse(sjekker.sjekkParenteser("{ [ ( ) }"));
    }

    @Test
    public void testManglerStartparentes() {
        ParentesSjekker sjekker = new ParentesSjekker();
        assertFalse(sjekker.sjekkParenteser("[ ( ) ] }"));
    }

    @Test
    public void testSluttparentesForTidlig() {
        ParentesSjekker sjekker = new ParentesSjekker();
        assertFalse(sjekker.sjekkParenteser("{ [ ( ] ) }"));
    }

    @Test
    public void testJavaProgram() {
        ParentesSjekker sjekker = new ParentesSjekker();
        String javaprogram = """
            class HelloWorld {
                public static void main(String[] args) {
                    System.out.println("Hello World!");
                }
            }
            """;
        assertTrue(sjekker.sjekkParenteser(javaprogram));
    }
}
