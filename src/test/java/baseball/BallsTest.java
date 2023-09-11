package baseball;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {
    @Test
    public void strikeOut() {
        Ball computerBall1 = new Ball(0, 5);
        Ball computerBall2 = new Ball(1, 2);
        Ball computerBall3 = new Ball(2, 7);

        Balls computerballs = new Balls();
        computerballs.add(computerBall1);
        computerballs.add(computerBall2);
        computerballs.add(computerBall3);

        Ball userBall1 = new Ball(0, 5);
        Ball userBall2 = new Ball(1, 2);
        Ball userBall3 = new Ball(2, 7);

        Balls userBalls = new Balls();
        userBalls.add(userBall1);
        userBalls.add(userBall2);
        userBalls.add(userBall3);

        assertThat(computerballs.compare(userBalls).isStrikeOut()).isTrue();
    }

    @Test
    public void oneBallOneStrike() {
        Ball computerBall1 = new Ball(0, 5);
        Ball computerBall2 = new Ball(1, 2);
        Ball computerBall3 = new Ball(2, 7);

        Balls computerballs = new Balls();
        computerballs.add(computerBall1);
        computerballs.add(computerBall2);
        computerballs.add(computerBall3);

        Ball userBall1 = new Ball(0, 9);
        Ball userBall2 = new Ball(1, 2);
        Ball userBall3 = new Ball(2, 5);

        Balls userBalls = new Balls();
        userBalls.add(userBall1);
        userBalls.add(userBall2);
        userBalls.add(userBall3);

        Score score = computerballs.compare(userBalls);
        String expected = "1볼 1스트라이크";
        System.out.println(score);
        assertThat(expected.equals(score.toString())).isTrue();
    }

    @Test
    public void Nothing() {
        Ball computerBall1 = new Ball(0, 1);
        Ball computerBall2 = new Ball(1, 2);
        Ball computerBall3 = new Ball(2, 3);

        Balls computerballs = new Balls();
        computerballs.add(computerBall1);
        computerballs.add(computerBall2);
        computerballs.add(computerBall3);

        Ball userBall1 = new Ball(0, 4);
        Ball userBall2 = new Ball(1, 5);
        Ball userBall3 = new Ball(2, 6);

        Balls userBalls = new Balls();
        userBalls.add(userBall1);
        userBalls.add(userBall2);
        userBalls.add(userBall3);

        Score score = computerballs.compare(userBalls);
        String expected = "Nothing";
        System.out.println(score);
        assertThat(expected.equals(score.toString())).isTrue();
    }
}
