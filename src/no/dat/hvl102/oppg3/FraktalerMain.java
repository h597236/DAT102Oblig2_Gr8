package no.dat.hvl102.oppg3;

public class FraktalerMain {

    public static void main(String[] args) {

        Tegneflate tegneflate = new Tegneflate();
        new Tegneprogram("Fraktaler", tegneflate);

        /*
         * Starter tegning på tegneflaten med parametre for
         * dybde (20) og forsinkelse (200) i millisekunder (for animasjon).
         */
        Fraktal fraktal = new FraktalKvadrat1(20, 200, tegneflate);
        fraktal.tegn();
    }
}