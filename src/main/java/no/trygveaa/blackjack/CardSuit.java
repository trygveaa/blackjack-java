package no.trygveaa.blackjack;

import java.util.Arrays;

public enum CardSuit {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private final String stringRepresentation;

    CardSuit(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return this.stringRepresentation;
    }

    public static CardSuit fromString(String value) {
        return Arrays.stream(CardSuit.values())
                .filter(suit -> suit.stringRepresentation.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid card suit given: " + value));
    }
}
