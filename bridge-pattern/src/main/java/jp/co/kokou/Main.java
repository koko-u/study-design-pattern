package jp.co.kokou;

import jp.co.kokou.impl.StringDisplayImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Bridge Pattern");

        var helloWorld = new StringDisplayImpl("Hello World");

        var display = new Display();
        display.display(helloWorld);

        var cdisplay = new CountDisplay();
        cdisplay.display(helloWorld);
        cdisplay.multiDisplay(5, helloWorld);
    }
}
