package no.trygveaa.blackjack;

public class Blackjack {

    private CardDeck deck;
    private Player dealer;
    private Player sam;

    public Blackjack(CardDeck deck, Player dealer, Player sam) {
        this.dealer = dealer;
        this.sam = sam;
        this.deck = deck;
    }
}
