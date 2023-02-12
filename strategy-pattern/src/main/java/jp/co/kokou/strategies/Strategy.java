package jp.co.kokou.strategies;

import jp.co.kokou.hands.Hand;
import jp.co.kokou.results.Result;

public interface Strategy {
    Hand nextHand();

    void study(Hand hand, Result result);
}
