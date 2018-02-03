package no.trygveaa.blackjack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CardDeck {
    private List<Card> cards;

    public CardDeck() {
        this.cards = Arrays.stream(CardSuit.values())
                .flatMap(suit -> (
                        Arrays.stream(CardRank.values()).map(rank -> new Card(suit, rank))
                ))
                .collect(Collectors.toList());
        Collections.shuffle(this.cards);
    }

    public CardDeck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return this.cards;
    }
}
