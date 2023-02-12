package jp.co.kokou.players;

import jp.co.kokou.hands.Hand;
import jp.co.kokou.results.Result;
import jp.co.kokou.strategies.Strategy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class Player {
    private final Strategy strategy;
    private Optional<Hand> lastHand = Optional.empty();

    @Getter
    private int numberOfWins = 0;

    public Hand nextHand() {
        var hand = strategy.nextHand();
        this.lastHand = Optional.of(hand);
        return hand;
    }

    public void notifyResult(Result result) {
        this.lastHand.ifPresent(hand -> {
            strategy.study(hand, result);
            if (result == Result.Win) {
                this.numberOfWins++;
            }
        });
        this.lastHand = Optional.empty();
    }
}
