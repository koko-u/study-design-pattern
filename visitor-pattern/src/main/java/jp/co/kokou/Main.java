package jp.co.kokou;

import jp.co.kokou.entries.Directory;
import jp.co.kokou.entries.File;
import jp.co.kokou.visitors.ListVisitor;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Visitor Pattern");

        var entry = new Directory("root")
                .add(
                        new Directory("bin")
                                .add(
                                        new File("vi", 10_000L),
                                        new File("latex", 20_000L)
                                ),
                        new Directory("tmp"),
                        new Directory("usr")
                );

        entry.accept(new ListVisitor(Path.of("/")));
    }
}
