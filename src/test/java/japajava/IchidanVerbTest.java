package japajava;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class IchidanVerbTest {

    @Test
    public void taberu_allForms_success() {
        final IchidanVerb v = new IchidanVerb("食べる");

        assertThat(v.dictionary()).isEqualTo("食べる");
        assertThat(v.polite()).isEqualTo("食べます");
        assertThat(v.past()).isEqualTo("食べた");
        assertThat(v.pastPolite()).isEqualTo("食べました");
    }

    @Test
    public void kariru_allForms_success() {
        final IchidanVerb v = new IchidanVerb("借りる");

        assertThat(v.dictionary()).isEqualTo("借りる");
        assertThat(v.polite()).isEqualTo("借ります");
        assertThat(v.past()).isEqualTo("借りた");
        assertThat(v.pastPolite()).isEqualTo("借りました");
    }

    @Test
    public void invalidInput_throws() {
        assertThatThrownBy(() -> new IchidanVerb("飲む"))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("final character for an ichidan verb must be る");
    }
    
}
