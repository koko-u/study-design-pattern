package jp.co.kokou.factory;

import java.io.IOException;
import java.io.OutputStream;

/**
 * HTMLドキュメントとその部分が出力可能であることを示すインターフェースです
 */
public interface Writable {
    /**
     * 対象のDOMノードを出力します
     *
     * @param out 出力先です
     * @throws IOException 出力で発生したIO例外です
     */
    void write(OutputStream out) throws IOException;
}
