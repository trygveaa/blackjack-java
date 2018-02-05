package no.trygveaa.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return this.name;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public int currentScore() {
        return this.hand.stream().mapToInt(Card::getGameValue).sum();
    }

    public boolean hasBlackjack() {
        return this.hand.size() == 2 && this.currentScore() == Blackjack.WIN_SCORE;
    }

    public boolean hasLost() {
        return this.currentScore() > Blackjack.WIN_SCORE;
    }
}
