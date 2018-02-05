package no.trygveaa.blackjack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BlackjackTest {

    @Test
    void shouldDealFirstAndThirdCardToPlayer() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.RANK2);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.RANK3);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.RANK4);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.RANK5);
        Blackjack blackjack = new Blackjack(
                new CardDeck(Arrays.asList(card1, card2, card3, card4)),
                new Player("dealer"),
                new Player("sam")
        );

        blackjack.play();

        assertThat(blackjack.getSam().getHand()).containsExactly(card1, card3);
    }

    @Test
    void shouldDealSecondAndFourthCardToDealer() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.RANK2);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.RANK3);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.RANK4);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.RANK5);
        Blackjack blackjack = new Blackjack(
                new CardDeck(Arrays.asList(card1, card2, card3, card4)),
                new Player("dealer"),
                new Player("sam")
        );

        blackjack.play();

        assertThat(blackjack.getDealer().getHand()).containsExactly(card2, card4);
    }

    @Test
    void shouldReturnPlayerAsWinnerWhenBothStartWithBlackjack() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.KING);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.KING);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Player sam = new Player("sam");
        Blackjack blackjack = new Blackjack(
                new CardDeck(Arrays.asList(card1, card2, card3, card4)),
                new Player("dealer"),
                sam
        );

        Player winner = blackjack.play();

        assertThat(winner).isEqualTo(sam);
    }

    @Test
    void shouldReturnDealerAsWinnerWhenBothStartWith22() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Player dealer = new Player("dealer");
        Blackjack blackjack = new Blackjack(
                new CardDeck(Arrays.asList(card1, card2, card3, card4)),
                dealer,
                new Player("sam")
        );

        Player winner = blackjack.play();

        assertThat(winner).isEqualTo(dealer);
    }

    @Test
    void shouldDrawForPlayerBeforeDealer() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.RANK2);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.RANK2);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.RANK2);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.RANK2);
        Card card5 = new Card(CardSuit.CLUBS, CardRank.RANK2);
        Card card6 = new Card(CardSuit.CLUBS, CardRank.RANK2);
        Blackjack blackjack = new Blackjack(
                new CardDeck(Arrays.asList(card1, card2, card3, card4, card5, card6)),
                new Player("dealer"),
                new Player("sam")
        );

        blackjack.play();

        assertThat(blackjack.getSam().getHand()).contains(card5, card6);
    }

    @Test
    void shouldStopDrawingForPlayerAtScore17() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card5 = new Card(CardSuit.CLUBS, CardRank.RANK3);
        Card card6 = new Card(CardSuit.CLUBS, CardRank.RANK3);
        Blackjack blackjack = new Blackjack(
                new CardDeck(Arrays.asList(card1, card2, card3, card4, card5, card6)),
                new Player("dealer"),
                new Player("sam")
        );

        blackjack.play();

        assertThat(blackjack.getSam().getHand()).contains(card5);
        assertThat(blackjack.getSam().getHand()).doesNotContain(card6);
    }

    @Test
    void shouldStopDrawingForDealerWhenHigherScoreThanPlayer() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card5 = new Card(CardSuit.CLUBS, CardRank.RANK3);
        Card card6 = new Card(CardSuit.CLUBS, CardRank.RANK4);
        Card card7 = new Card(CardSuit.CLUBS, CardRank.RANK4);
        Blackjack blackjack = new Blackjack(
                new CardDeck(Arrays.asList(card1, card2, card3, card4, card5, card6, card7)),
                new Player("dealer"),
                new Player("sam")
        );

        blackjack.play();

        assertThat(blackjack.getDealer().getHand()).contains(card6);
        assertThat(blackjack.getDealer().getHand()).doesNotContain(card7);
    }

    @Test
    void shouldReturnPlayerWithHighestScoreBelow21AsWinner() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card5 = new Card(CardSuit.CLUBS, CardRank.RANK3);
        Card card6 = new Card(CardSuit.CLUBS, CardRank.RANK4);
        Player dealer = new Player("dealer");
        Blackjack blackjack = new Blackjack(
                new CardDeck(Arrays.asList(card1, card2, card3, card4, card5, card6)),
                dealer,
                new Player("sam")
        );

        Player winner = blackjack.play();

        assertThat(winner).isEqualTo(dealer);
    }

    @Test
    void shouldReturnPlayerAsWinnerWhenDealerHasHigherScoreThan21() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card5 = new Card(CardSuit.CLUBS, CardRank.RANK3);
        Card card6 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Player sam = new Player("sam");
        Blackjack blackjack = new Blackjack(
                new CardDeck(Arrays.asList(card1, card2, card3, card4, card5, card6)),
                new Player("dealer"),
                sam
        );

        Player winner = blackjack.play();

        assertThat(winner).isEqualTo(sam);
    }

    @Test
    void shouldReturnDealerAsWinnerWhenPlayerHasHigherScoreThan21() {
        Card card1 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.RANK7);
        Card card5 = new Card(CardSuit.CLUBS, CardRank.KING);
        Card card6 = new Card(CardSuit.CLUBS, CardRank.ACE);
        Player dealer = new Player("dealer");
        Blackjack blackjack = new Blackjack(
                new CardDeck(Arrays.asList(card1, card2, card3, card4, card5, card6)),
                dealer,
                new Player("sam")
        );

        Player winner = blackjack.play();

        assertThat(winner).isEqualTo(dealer);
    }
}
