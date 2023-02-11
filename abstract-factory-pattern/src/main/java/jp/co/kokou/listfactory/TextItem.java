package jp.co.kokou.listfactory;

import jp.co.kokou.factory.Text;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public record TextItem(String text) implements Text {
    @Override
    public void write(OutputStream out) throws IOException {
        out.write(text().getBytes(StandardCharsets.UTF_8));
    }
}
