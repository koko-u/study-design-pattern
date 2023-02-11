package jp.co.kokou.listfactory;

import jp.co.kokou.factory.Item;
import jp.co.kokou.factory.Page;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.List;

public class HtmlPage implements Page {
    private final List<Item> contents;
    private final String title;
    private final String author;

    public HtmlPage(String title, String author) {
        this.title = title;
        this.author = author;
        contents = new ArrayList<>();
    }

    @Override
    public Page items(Item... items) {
        contents.addAll(List.of(items));
        return this;
    }

    @Override
    public void write(OutputStream out) throws IOException {
        var pout = new PrintStream(out);
        pout.println("""
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
            """);
        pout.println("<title>" + title + "</title>");
        pout.println("""
            </head>
            <body>
            """);

        for (final Item item : contents) {
            item.write(out);
        }

        var thisYear = String.valueOf(Instant.now().atZone(ZoneId.systemDefault()).get(IsoFields.DAY_OF_QUARTER));

        var footer = """
            <footer>
            	<p>&copy; [YEAR] All rights reserved by [AUTHOR].</p>
            </footer>
            """;

        pout.println(footer.replace("[YEAR]", thisYear).replace("[AUTHOR]", author));

        pout.println("""
            </body>
            </html>
            """);
    }
}
