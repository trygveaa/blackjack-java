package no.trygveaa.blackjack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void shouldAddCardToHand() {
        Player player = new Player("test");
        Card card = new Card(CardSuit.CLUBS, CardRank.ACE);
        player.addCard(card);

        assertThat(player.getHand()).containsExactly(card);
    }

    @Test
    void shouldSumCardValuesForScore() {
        Player player = new Player("test", Arrays.asList(
                new Card(CardSuit.CLUBS, CardRank.RANK3),
                new Card(CardSuit.DIAMONDS, CardRank.RANK5)
        ));

        assertThat(player.currentScore()).isEqualTo(8);
    }

    @Test
    void shouldReturnTrueForHasBlackjackWhenScoreIs21AndThereAreTwoCards() {
        Player player = new Player("test", Arrays.asList(
                new Card(CardSuit.CLUBS, CardRank.KING),
                new Card(CardSuit.DIAMONDS, CardRank.ACE)
        ));

        assertThat(player.hasBlackjack()).isTrue();
    }

    @Test
    void shouldReturnFalseForHasBlackjackWhenScoreIs21AndThereAreMoreThanTwoCards() {
        Player player = new Player("test", Arrays.asList(
                new Card(CardSuit.CLUBS, CardRank.RANK7),
                new Card(CardSuit.CLUBS, CardRank.RANK7),
                new Card(CardSuit.CLUBS, CardRank.RANK7)
        ));

        assertThat(player.hasBlackjack()).isFalse();
    }

    @Test
    void shouldReturnFalseForHasBlackjackWhenScoreIsOver21AndThereAreTwoCards() {
        Player player = new Player("test", Arrays.asList(
                new Card(CardSuit.CLUBS, CardRank.ACE),
                new Card(CardSuit.DIAMONDS, CardRank.ACE)
        ));

        assertThat(player.hasBlackjack()).isFalse();
    }

    @Test
    void shouldReturnTrueForHasLostWhenScoreIsOver21() {
        Player player = new Player("test", Arrays.asList(
                new Card(CardSuit.CLUBS, CardRank.ACE),
                new Card(CardSuit.DIAMONDS, CardRank.ACE)
        ));

        assertThat(player.hasLost()).isTrue();
    }

    @Test
    void shouldReturnFalseForHasLostWhenScoreIs21() {
        Player player = new Player("test", Arrays.asList(
                new Card(CardSuit.CLUBS, CardRank.KING),
                new Card(CardSuit.DIAMONDS, CardRank.ACE)
        ));

        assertThat(player.hasLost()).isFalse();
    }
}
