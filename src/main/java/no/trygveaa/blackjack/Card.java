package no.trygveaa.blackjack;

public class Card {
    private final CardSuit suit;
    private final CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuit getSuit() {
        return this.suit;
    }

    public CardRank getRank() {
        return this.rank;
    }

    public int getGameValue() {
        return this.rank.getGameValue();
    }

    @Override
    public String toString() {
        return String.format("%s%s", this.suit, this.rank);
    }

    public static Card fromString(String card) {
        CardSuit suit = CardSuit.fromString(card.substring(0, 1));
        CardRank rank = CardRank.fromString(card.substring(1));
        return new Card(suit, rank);
    }
}
