package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    List<Ball> ballList;
    public Balls() {
        ballList = new ArrayList<>();
    }

    public void add(Ball ball){
        this.ballList.add(ball);
    }

    public Score compare(Balls balls) {
        Score score  = new Score();
        List<Ball> ballList = balls.ballList;
        for (int i = 0; i < 3; i++) {
            Ball ball = ballList.get(i);
            Ball thisBall = this.ballList.get(i);
            score.update(ball.match(thisBall));
        }

        return score;
    }
}
