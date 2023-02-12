package jp.co.kokou.strategies;

import jp.co.kokou.hands.Hand;
import jp.co.kokou.results.Result;

import java.util.Optional;
import java.util.Random;

public class WinningStrategy implements Strategy {

    private final Random random = new Random();

    private Optional<Hand> winningHand = Optional.empty();

    @Override
    public Hand nextHand() {
        return winningHand.orElseGet(() ->
            switch (random.nextInt(3)) {
                case 0 -> Hand.Rock;
                case 1 -> Hand.Paper;
                default -> Hand.Scissors;
            }
        );
    }

    @Override
    public void study(Hand hand, Result result) {
        if (result == Result.Win) {
            winningHand = Optional.of(hand);
        }
    }
}
