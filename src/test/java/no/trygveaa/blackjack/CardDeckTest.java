package no.trygveaa.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardDeckTest {

    @Test
    void shouldCreateFullDeckWhenNoCardsGiven() {
        CardDeck deck = new CardDeck();
        int numberOfCards = CardSuit.values().length * CardRank.values().length;

        assertThat(deck.getCards().size()).isEqualTo(numberOfCards);
    }
}
