package jp.co.kokou.pagemaker;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;

@Component
@RequiredArgsConstructor
public class HtmlWriter {
    @NonNull
    private final Writer writer;

    private boolean hasTitle = false;

    @SneakyThrows(IOException.class)
    public HtmlWriter title(String title) {
        if (this.hasTitle) {
            return this;
        }

        var header = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>%s</title>
                </head>
                """.formatted(title);

        var body = """
                <body>
                <h1>
                    %s
                </h1>
                """.formatted(title);

        this.writer.write(header);
        this.writer.write(body);

        this.hasTitle = true;

        return this;
    }

    @SneakyThrows(IOException.class)
    public HtmlWriter p(String message) {
        writer.write("""
                <p>
                    %s
                </p>
                """.formatted(message));

        return this;
    }

    public HtmlWriter link(String link, String caption) {
        return p("""
                <a href="%s">
                    %s
                </a>
                """.formatted(link, caption));
    }

    public HtmlWriter email(String emailAddress, String name) {
        return link("mailto: %s".formatted(emailAddress), name);
    }

    @SneakyThrows(IOException.class)
    public void close() {
        if (this.hasTitle) {
            writer.write("""
                    </body>
                    </html>
                    """);
        }
    }
}
