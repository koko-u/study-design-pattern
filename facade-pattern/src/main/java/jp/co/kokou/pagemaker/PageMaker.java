package jp.co.kokou.pagemaker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PageMaker {
    @NonNull
    private final Database db;
    @NonNull
    private final HtmlWriter writer;

    @Value("${filename}")
    private String filename;

    public void createWelcomePage(@NonNull String emailAddress) {
        db.getEmailList().stream().filter(e -> e.email().equals(emailAddress)).findAny().ifPresent(e -> {
            this.writer
                    .title("%s's Web page".formatted(e.name()))
                    .p("Welcome to %s's web page!".formatted(e.name()))
                    .p("Nice to meet you.")
                    .email(e.email(), e.name())
                    .close();
            log.info("{} is created for {} ({})", this.filename, e.email(), e.name());
        });
    }
}
