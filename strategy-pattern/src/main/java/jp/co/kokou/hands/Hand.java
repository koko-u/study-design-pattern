package jp.co.kokou.hands;

import jp.co.kokou.results.Result;

public enum Hand {
    Rock,
    Paper,
    Scissors;

    public Result match(Hand other) {
        return switch (this) {
            case Rock -> switch (other) {
                case Rock -> Result.Draw;
                case Paper -> Result.Lose;
                case Scissors -> Result.Win;
            };
            case Paper -> switch (other) {
                case Rock -> Result.Win;
                case Paper -> Result.Draw;
                case Scissors -> Result.Lose;
            };
            case Scissors -> switch (other) {
                case Rock -> Result.Lose;
                case Paper -> Result.Win;
                case Scissors -> Result.Draw;
            };
        };
    }
}
