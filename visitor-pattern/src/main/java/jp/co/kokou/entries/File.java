package jp.co.kokou.entries;

import jp.co.kokou.elements.Element;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Iterator;

/**
 * ファイルを表現するクラスです
 */
@RequiredArgsConstructor
@Getter
public class File implements Entry, Element {

    /**
     * ファイル名です
     */
    private final String name;

    /**
     * ファイルサイズです
     */
    private final Long size;

    /**
     * ファイルに対して子供は存在しません
     *
     * @return 空のイテレータを返却します
     */
    @Override
    public Iterator<Element> getIterator() {
        return Collections.emptyIterator();
    }

    /**
     * @return ファイルの文字列表現 「ファイル名\t(ファイルサイズ)」 です
     */
    @Override
    public String toString() {
        return "%s\t(%d)".formatted(this.name, this.size);
    }
}
