package jp.co.kokou;

import jp.co.kokou.players.Game;
import jp.co.kokou.players.Player;
import jp.co.kokou.strategies.RandomStrategy;
import jp.co.kokou.strategies.StatisticalStrategy;
import jp.co.kokou.strategies.WinningStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Strategy Pattern");

        var idiotPlayer = new Player(new WinningStrategy());
        var thoughtlessPlayer = new Player(new RandomStrategy());
        var seemsCleverPlayer = new Player(new StatisticalStrategy());

        var game = new Game(seemsCleverPlayer, thoughtlessPlayer);

        for (var i = 0; i < 100000; i++) {
            game.play();
        }

        System.out.println("Result");
        System.out.println("Seems Clever Player: " + seemsCleverPlayer.getNumberOfWins());
        System.out.println("Thoughtless Player:  " + thoughtlessPlayer.getNumberOfWins());
    }
}
