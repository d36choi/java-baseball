package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private static final List<BallNumber> BALL_NUMBER_GENERATOR = new ArrayList<>();

    private final BaseBallNumbers baseBallNumbers;

    static {
        for (int i = 1; i < 10; i++) {
            BALL_NUMBER_GENERATOR.add(BallNumber.of(i));
        }
    }

    private Computer(List<BallNumber> ballNumbers) {
        this.baseBallNumbers = BaseBallNumbers.of(ballNumbers);
    }

    public BaseBallNumbers getBaseBallNumbers() {
        return baseBallNumbers;
    }

    private static List<BallNumber> generateBallNumbers () {
        Collections.shuffle(BALL_NUMBER_GENERATOR);
        return BALL_NUMBER_GENERATOR.subList(0,3);
    }

    public static Computer of () {
        return new Computer(generateBallNumbers());
    }
}
