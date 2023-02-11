package jp.co.kokou.factory;

import java.io.IOException;
import java.net.URL;

/**
 * HTMLリンクを表現するインターフェースです
 */
public interface Link extends Item {
    String title();

    URL url() throws IOException;
}
