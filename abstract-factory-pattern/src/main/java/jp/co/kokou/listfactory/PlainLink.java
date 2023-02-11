package jp.co.kokou.listfactory;

import jp.co.kokou.factory.Link;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public record PlainLink(String title, String url) implements Link {

    @Override
    public void write(OutputStream out) throws IOException {
        var value = "<a href=\"" + url() + "\">" + title() + "</a>";
        out.write(value.getBytes(StandardCharsets.UTF_8));
    }
}
