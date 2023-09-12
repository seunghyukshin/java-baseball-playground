package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
    List<Ball> ballList;

    public Balls() {
        ballList = new ArrayList<>();
    }

    public void add(Ball ball)  {
        // TODO: ALERT 출력
        if (!_validate(ball)) {
            return;
        }
        this.ballList.add(ball);
    }

    // add가능한 ball인지 검증
    private boolean _validate(Ball ball) {
        boolean check;

        // size가 3보다 작은지 검증
        if (this.ballList.size() > 3) {
            check = false;
            return check;
        }


        // 중복값 검증 (모든 ball에서 같은 value가 없어야함)
        check = ballList.stream().noneMatch(thisBall -> thisBall.isEqualValue(ball));

        return check;

    }

    // Balls와 Balls 비교하며 Score Update
    public Score compare(Balls paramBalls) {
        Score score = new Score();
        List<Ball> paramBallList = paramBalls.ballList;
        for (int i = 0; i < 3; i++) {
            BallStatus ballStatus = _compare(paramBallList.get(i));
            score.update(ballStatus);
        }

        return score;
    }

    // Balls와 Ball 비교
    private BallStatus _compare(Ball paramBall) {
        /*
          모든 리스트 원소 BallStatus로 변경
          Ball이나 Strike 하나라도 있으면 반환
          없으면 Nothing 반환
         */
        return this.ballList.stream()
                .map(ball -> ball.match(paramBall))
                .filter(BallStatus::isHit)
                .findAny()
                .orElse(BallStatus.NOTHING);
    }


    // 난수 Balls 생성
    public void initRandomBalls()  {
        ballList.clear();

        while (this.ballList.size() != 3) {
            try {
                addBall(NumberUtils.createSingleDigitNumber());
            } catch (BallNumberOutOfBoundsException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Ball getBall(int position) {
        return this.ballList.get(position);
    }

    public void addBall(int value) throws BallNumberOutOfBoundsException {
        int position = this.ballList.size();
        this.add(new Ball(position, value));
    }

    // 3글자 String을 Ball 3개로 만들어서 ballList에 저장
    public void makeBalls(String paramString) throws BallNumberOutOfBoundsException {
        Arrays.stream(paramString.split(""))
                .map(userBall -> Integer.parseInt(userBall))
                .forEach(value -> {
                    try {
                        this.addBall(value);
                    } catch (BallNumberOutOfBoundsException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    @Override
    public String toString(){
        return ballList.toString();
    }
}
