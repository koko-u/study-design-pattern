package jp.co.kokou.players;

import jp.co.kokou.results.Result;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Game {
    private final Player playerA;
    private final Player playerB;

    public void play() {
        var result = match(playerA, playerB);
        playerA.notifyResult(result.a);
        playerB.notifyResult(result.b);
    }

    private MatchResult match(Player a, Player b) {
        var aHand = a.nextHand();
        var bHand = b.nextHand();
        return new MatchResult(aHand.match(bHand), bHand.match(aHand));
    }

    record MatchResult(Result a, Result b) {
    }
}
