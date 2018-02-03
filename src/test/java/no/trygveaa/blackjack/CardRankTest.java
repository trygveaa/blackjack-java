package no.trygveaa.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CardRankTest {

    @Test
    void shouldReturnGameValueForRank() {
        assertThat(CardRank.ACE.getGameValue()).isEqualTo(11);
    }

    @Test
    void shouldReturnStringRepresentationForRank() {
        assertThat(CardRank.ACE.toString()).isEqualTo("A");
    }

    @Test
    void shouldReturnRankWhenGivenValidString() {
        assertThat(CardRank.fromString("A")).isEqualTo(CardRank.ACE);
    }

    @Test
    void shouldThrowExceptionWhenGivenInvalidString() {
        assertThatIllegalArgumentException().isThrownBy(() -> CardRank.fromString("invalid"));
    }
}
