package jp.co.kokou.listfactory;

import jp.co.kokou.factory.Link;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public final class PlainLink implements Link {
    private final String title;
    private final String url;


    @Override
    public void write(OutputStream out) throws IOException {
        var value = "<a href=\"" + url() + "\">" + title() + "</a>";
        out.write(value.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public URL url() throws IOException {
        return new URL(url);
    }
}
