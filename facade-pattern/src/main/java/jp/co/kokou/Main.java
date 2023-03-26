package jp.co.kokou;

import jp.co.kokou.config.Config;
import jp.co.kokou.pagemaker.PageMaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Facade Pattern");

        var context = new AnnotationConfigApplicationContext(Config.class);
        try (context) {
            var facade = context.getBean(PageMaker.class);
            facade.createWelcomePage("tderobert5@squarespace.com");
        }
    }
}
