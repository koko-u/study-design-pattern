package jp.co.kokou.entries;

/**
 * ディレクトリまたはファイルを表現するインターフェースです
 */
public interface Entry {
    /**
     * @return ファイル名またはディレクトリ名です
     */
    String getName();

    /**
     * @return ファイルサイズ、またはディレクトリに含まれるファイルのサイズ合計です
     */
    Long getSize();
}
