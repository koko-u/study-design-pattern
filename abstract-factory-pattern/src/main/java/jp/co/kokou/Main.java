package jp.co.kokou;

import jp.co.kokou.factory.Factory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Abstract Factory Pattern");
        if (args.length < 2) {
            printUsage();
            System.exit(1);
        }

        var filename = args[0];
        var className = args[1];

        Factory.getFactory(className).ifPresent(f -> {
            var page = f.page("Blog and News", "YUKI Hiroshi")
                .items(
                    f.tray()
                        .items(
                            f.link("Blog1", "https://example.com/blog1"),
                            f.link("Blog2", "https://example.com/blog2"),
                            f.link("Blog3", "https://example.com/blog3")
                        ),
                    f.tray()
                        .items(
                            f.link("News 1", "https://example.com/news1"),
                            f.link("News 2", "https://example.com/news2"),
                            f.tray()
                                .items(
                                    f.link("News 3 (US)", "https://example.com/news3/en"),
                                    f.link("News 3 (JP)", "https://example.com/news3/jp")
                                )
                        )
                );

            try (var out = Files.newOutputStream(Path.of(filename), StandardOpenOption.CREATE)) {
                page.write(out);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void printUsage() {
        System.out.println("[Usage] java Main <filename> <qualified class name>");
        System.out.println("\t(1) java Main list.html listfactory.ListFactory");
        System.out.println("\t(2) java Main div.html divfactory.DivFactory");
    }
}
