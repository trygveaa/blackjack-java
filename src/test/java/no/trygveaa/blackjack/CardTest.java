package no.trygveaa.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    @Test
    void shouldReturnStringRepresentationForCard() {
        Card card = new Card(CardSuit.CLUBS, CardRank.ACE);

        assertThat(card.toString()).isEqualTo("CA");
    }

    @Test
    void shouldReturnCardWhenGivenValidString() {
        Card card = Card.fromString("CA");

        assertThat(card.getSuit()).isEqualTo(CardSuit.CLUBS);
        assertThat(card.getRank()).isEqualTo(CardRank.ACE);
    }
}
