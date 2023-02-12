package jp.co.kokou.strategies;

import jp.co.kokou.hands.Hand;
import jp.co.kokou.results.Result;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private final Random random = new Random();

    @Override
    public Hand nextHand() {
        return switch (random.nextInt(3)) {
            case 0 -> Hand.Rock;
            case 1 -> Hand.Paper;
            default -> Hand.Scissors;
        };
    }

    @Override
    public void study(Hand hand, Result result) {
        // nothing to study
    }
}
