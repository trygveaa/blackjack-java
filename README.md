# Blackjack

Simple Blackjack implementation in Java. Creates a random deck of cards, or
takes in a file with a list of cards, and plays a round. Prints the winner and
the resulting hands of the player and the dealer.

## Example

Play with a random deck of cards:

```
$ java -jar target/blackjack-1.0-SNAPSHOT.jar
> dealer
> sam: C9, D5, CJ
> dealer: H10, H6
```

Or create a file with a list of cards and use that:

```
$ echo CA, D5, H9, HQ, S8 > input.txt
$ java -jar target/blackjack-1.0-SNAPSHOT.jar input.txt
> sam
> sam: CA, H9
> dealer: D5, HQ, S8
```
