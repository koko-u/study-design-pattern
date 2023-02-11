package jp.co.kokou.factory;

import java.io.IOException;
import java.io.OutputStream;

public interface Writable {
    void write(OutputStream out) throws IOException;
}
