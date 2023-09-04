package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {

    @Test
    public void ball(){
        Ball ball1 = new Ball(0,5);
        Ball ball2 = new Ball(3,5);
        assertThat(BallStatus.isBall(ball1.match(ball2))).isTrue();
    }
    @Test
    public void ball_fail(){
        Ball ball1 = new Ball(0,5);
        Ball ball2 = new Ball(3,3);
        assertThat(BallStatus.isBall(ball1.match(ball2))).isFalse();
    }


    @Test
    public void strike(){
        Ball ball1  = new Ball(0,5);
        Ball ball2  = new Ball(0,5);
        assertThat(BallStatus.isStrike(ball1.match(ball2))).isTrue();
    }

    @Test
    public void strike_fail(){
        Ball ball1  = new Ball(0,5);
        Ball ball2  = new Ball(3,5);
        assertThat(BallStatus.isStrike(ball1.match(ball2))).isFalse();
    }
}
