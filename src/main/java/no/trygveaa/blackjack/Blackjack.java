package no.trygveaa.blackjack;

import java.util.Optional;

public class Blackjack {
    public static final int PLAYER_STOP_DRAW = 17;
    public static final int WIN_SCORE = 21;

    private CardDeck deck;
    private Player dealer;
    private Player sam;

    public Blackjack(CardDeck deck, Player dealer, Player sam) {
        this.dealer = dealer;
        this.sam = sam;
        this.deck = deck;
    }

    public Player getSam() {
        return this.sam;
    }

    public Player getDealer() {
        return this.dealer;
    }

    /**
     * Play through one game with the cards and players provided. The player
     * and the dealer will draw cards from the deck until one of them wins.
     *
     * @return the winner of the game
     */
    public Player play() {
        this.initializeHands();

        if (this.sam.hasBlackjack()) {
            return this.sam;
        } else if (this.sam.hasLost()) {
            return this.dealer;
        }

        this.drawUntilScore(this.sam, PLAYER_STOP_DRAW);

        if (this.sam.hasLost()) {
            return this.dealer;
        }

        this.drawUntilScore(this.dealer, this.sam.currentScore() + 1);

        return this.checkWinner();
    }

    private void initializeHands() {
        this.draw(this.sam);
        this.draw(this.dealer);
        this.draw(this.sam);
        this.draw(this.dealer);
    }

    private void drawUntilScore(Player player, int score) {
        while (player.currentScore() < score) {
            if (!this.draw(player)) {
                break;
            }
        }
    }

    private Player checkWinner() {
        if (this.dealer.hasLost()) {
            return this.sam;
        } else if (this.dealer.currentScore() > this.sam.currentScore()) {
            return this.dealer;
        } else {
            return this.sam;
        }
    }

    private boolean draw(Player p) {
        Optional<Card> card = this.deck.draw();
        card.ifPresent(p::addCard);
        return card.isPresent();
    }
}
