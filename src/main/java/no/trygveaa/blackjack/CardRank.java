package no.trygveaa.blackjack;

public enum CardRank {
    RANK2(2),
    RANK3(3),
    RANK4(4),
    RANK5(5),
    RANK6(6),
    RANK7(7),
    RANK8(8),
    RANK9(9),
    RANK10(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);

    private final int gameValue;

    CardRank(int gameValue) {
        this.gameValue = gameValue;
    }

    public int getGameValue() {
        return this.gameValue;
    }
}
