package no.trygveaa.blackjack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CardDeckTest {

    @Test
    void shouldCreateFullDeckWhenNoCardsGiven() {
        CardDeck deck = new CardDeck();
        int numberOfCards = CardSuit.values().length * CardRank.values().length;

        assertThat(deck.getCards().size()).isEqualTo(numberOfCards);
    }

    @Test
    void shouldReturnFirstCardOnDraw() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Card card2 = new Card(CardSuit.HEARTS, CardRank.RANK2);
        CardDeck deck = new CardDeck(Arrays.asList(card1, card2));

        Optional<Card> drawn = deck.draw();

        assertThat(drawn).contains(card1);
    }

    @Test
    void shouldRemoveCardOnDraw() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Card card2 = new Card(CardSuit.HEARTS, CardRank.RANK2);
        CardDeck deck = new CardDeck(Arrays.asList(card1, card2));

        deck.draw();

        assertThat(deck.getCards().size()).isEqualTo(1);
    }

    @Test
    void shouldReturnEmptyWhenDeckIsEmpty() {
        CardDeck deck = new CardDeck(Collections.emptyList());

        Optional<Card> drawn = deck.draw();

        assertThat(drawn).isEmpty();
    }
}
