package no.trygveaa.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CardDeck {
    private List<Card> cards;

    public CardDeck() {
        this.cards = Arrays.stream(CardSuit.values())
                .flatMap(suit -> (
                        Arrays.stream(CardRank.values()).map(rank -> new Card(suit, rank))
                ))
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(this.cards);
    }

    public CardDeck(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public Optional<Card> draw() {
        if (this.cards.size() == 0) {
            return Optional.empty();
        }
        return Optional.of(this.cards.remove(0));
    }
}
