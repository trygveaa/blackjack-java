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
}
