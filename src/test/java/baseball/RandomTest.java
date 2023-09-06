package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomTest {
    @Test
    public void init(){
        Balls balls = new Balls();
        balls.initRandomBalls();

        for (int i = 0; i < 3; i++) {
            Ball ball = balls.getBall(i);
            int value = balls.ballList.get(i).value;
            assertThat(value < 9 && value > 0).isTrue();
        }




//        Balls balls = new Balls(randomList);


    }
}
