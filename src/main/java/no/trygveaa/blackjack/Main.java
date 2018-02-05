package no.trygveaa.blackjack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        CardDeck deck = Arrays.stream(args).findFirst()
                .map(Main::createDeckFromFile)
                .orElseGet(CardDeck::new);

        Blackjack blackjack = new Blackjack(deck, new Player("dealer"), new Player("sam"));

        Player winner = blackjack.play();

        System.out.println(winner.getName());
        Stream.of(blackjack.getSam(), blackjack.getDealer())
                .map(player -> String.format("%s: %s", player.getName(), Main.cardsToString(player.getHand())))
                .forEach(System.out::println);
    }

    private static CardDeck createDeckFromFile(String fileName) {
        List<Card> cards;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            cards = stream
                    .flatMap(Pattern.compile(",")::splitAsStream)
                    .map(String::trim)
                    .map(Card::fromString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(String.format("Couldn't read file %s: %s", fileName, e));
        }

        return new CardDeck(cards);
    }

    private static String cardsToString(List<Card> cards) {
        return cards.stream().map(Card::toString).collect(Collectors.joining(", "));
    }
}
