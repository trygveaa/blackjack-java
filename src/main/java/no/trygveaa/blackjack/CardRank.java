package no.trygveaa.blackjack;

import java.util.Arrays;

public enum CardRank {
    RANK2(2, "2"),
    RANK3(3, "3"),
    RANK4(4, "4"),
    RANK5(5, "5"),
    RANK6(6, "6"),
    RANK7(7, "7"),
    RANK8(8, "8"),
    RANK9(9, "9"),
    RANK10(10, "10"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K"),
    ACE(11, "A");

    private final int gameValue;
    private final String stringRepresentation;

    CardRank(int gameValue, String stringRepresentation) {
        this.gameValue = gameValue;
        this.stringRepresentation = stringRepresentation;
    }

    public int getGameValue() {
        return this.gameValue;
    }

    @Override
    public String toString() {
        return this.stringRepresentation;
    }

    public static CardRank fromString(String value) {
        return Arrays.stream(CardRank.values())
                .filter(rank -> rank.stringRepresentation.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid card rank given: " + value));
    }
}
