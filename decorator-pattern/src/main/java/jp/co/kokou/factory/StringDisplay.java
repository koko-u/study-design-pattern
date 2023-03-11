package jp.co.kokou.factory;

import jp.co.kokou.decorators.Display;
import jp.co.kokou.decorators.FullBorder;
import jp.co.kokou.decorators.SideBorder;
import jp.co.kokou.decorators.SingleLine;

public class StringDisplay {
    private Display display;

    private StringDisplay() {}

    public static StringDisplay text(String text) {
        var sd = new StringDisplay();
        sd.display = new SingleLine(text);
        return sd;
    }

    public StringDisplay withBorder(char border) {
        this.display = new SideBorder(this.display, border);
        return this;
    }
    public StringDisplay withBorder(char border, char ceiling) {
        this.display = new FullBorder(this.display, border, ceiling);
        return this;
    }

    public Display create() {
        return this.display;
    }
}
