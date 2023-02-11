package jp.co.kokou.listfactory;

import jp.co.kokou.factory.Item;
import jp.co.kokou.factory.Tray;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UnorderdListTray implements Tray {
    private final List<Item> items;

    public UnorderdListTray() {
        items = new ArrayList<>();
    }

    @Override
    public Tray items(Item... items) {
        this.items.addAll(List.of(items));
        return this;
    }

    @Override
    public void write(OutputStream out) throws IOException {
        var pout = new PrintStream(out);
        pout.println("<ul>");

        for (final Item item : items) {
            pout.println("<li>");
            item.write(out);
            pout.println("</li>");
        }
        pout.println("</ul>");
    }
}
