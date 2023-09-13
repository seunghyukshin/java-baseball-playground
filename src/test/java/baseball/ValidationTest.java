package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidationTest {
    @Test
    public void isSingleNaturalNumber() throws BallNumberOutOfBoundsException {

        assertThatThrownBy(() -> {
            Ball ball = new Ball( 3,17);
        }).isInstanceOf(BallNumberOutOfBoundsException.class);


//        .hasMessageContaining("String index out of range");

    }
}
