package jp.co.kokou.strategies;

import jp.co.kokou.hands.Hand;
import jp.co.kokou.results.Result;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StatisticalStrategy implements Strategy {
    private final Random random = new Random();

    private final Map<Hand, Integer> statistic;

    public StatisticalStrategy() {
        this.statistic = new HashMap<>();
        this.statistic.put(Hand.Rock, 0);
        this.statistic.put(Hand.Paper, 0);
        this.statistic.put(Hand.Scissors, 0);
    }

    @Override
    public Hand nextHand() {
        return this.statistic
            .entrySet()
            .stream()
            .max((kv1, kv2) -> kv1.getValue().compareTo(kv2.getValue()))
            .map(Map.Entry::getKey)
            .orElseGet(() -> switch (random.nextInt(3)) {
                case 0 -> Hand.Rock;
                case 1 -> Hand.Paper;
                default -> Hand.Scissors;
            });
    }

    @Override
    public void study(Hand hand, Result result) {
        switch (result) {
            case Win -> {
                this.statistic.computeIfPresent(hand, (key, value) -> value + 1);
            }
            case Lose -> {
                this.statistic.computeIfPresent(hand, (key, value) -> value - 1);
            }
            default -> {
                return;
            }
        }
    }
}
