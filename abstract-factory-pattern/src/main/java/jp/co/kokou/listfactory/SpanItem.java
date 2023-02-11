package jp.co.kokou.listfactory;

import jp.co.kokou.factory.Item;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public record SpanItem(String text) implements Item {
    @Override
    public void write(OutputStream out) throws IOException {
        var value = "<span>" + text + "</span>";
        out.write(value.getBytes(StandardCharsets.UTF_8));
    }
}
