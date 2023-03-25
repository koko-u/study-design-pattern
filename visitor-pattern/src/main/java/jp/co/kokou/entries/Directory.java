package jp.co.kokou.entries;

import jp.co.kokou.elements.Element;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Directory implements Entry, Element {

    /**
     * ディレクトリ名です
     */
    private final String name;

    /**
     * ディレクトリに含まれる（サブディレクトリを含めた）ファイルのファイルサイズ総計です
     */
    private Long size = 0L;

    /**
     * ディレクトリに含まれるファイル、またはディレクトリのリストです
     */
    private final List<Entry> children = new ArrayList<>();

    /**
     * 自身が保持する「子供」の中で、Element を実装しているものを順に処理するためのイテレータを返却します
     *
     * @return children の中から Element に相当する分です
     */
    @Override
    public Iterator<Element> getIterator() {
        return this.children
                .stream()
                .filter(Element.class::isInstance)
                .map(Element.class::cast)
                .iterator();
    }

    /**
     * 自身の子供として指定しElementた Entry を順に追加します
     *
     * @param entries ディレクトリに追加する Entry のリストです
     * @return 自分自身を返却します。メソッドチェーンで続けて add() を呼べるようにします。
     */
    public Directory add(Entry... entries) {
        this.children.addAll(List.of(entries));
        this.size += Arrays.stream(entries).mapToLong(Entry::getSize).sum();
        return this;
    }

    /**
     * @return ディレクトリの文字列表現 「ディレクトリ名」です
     */
    @Override
    public String toString() {
        return this.name;
    }
}
