package no.trygveaa.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CardSuitTest {

    @Test
    void shouldReturnStringRepresentationForSuit() {
        assertThat(CardSuit.CLUBS.toString()).isEqualTo("C");
    }

    @Test
    void shouldReturnSuitWhenGivenValidString() {
        assertThat(CardSuit.fromString("C")).isEqualTo(CardSuit.CLUBS);
    }

    @Test
    void shouldThrowExceptionWhenGivenInvalidString() {
        assertThatIllegalArgumentException().isThrownBy(() -> CardSuit.fromString("invalid"));
    }
}
