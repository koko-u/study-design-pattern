package jp.co.kokou;

import jp.co.kokou.factory.StringDisplay;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Decorator Pattern");
        var d = StringDisplay.text("Hello World")
                .withBorder('*', '~')
                .withBorder('/')
                .withBorder('#', '=')
                .create();

        d.show();
    }
}
//
//  +=====================+
//  # / +~~~~~~~~~~~~~+ / #
//  # / * Hello World * / #
//  # / +~~~~~~~~~~~~~+ / #
//  +=====================+