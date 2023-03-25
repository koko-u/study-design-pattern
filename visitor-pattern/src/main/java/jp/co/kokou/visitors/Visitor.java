package jp.co.kokou.visitors;

import jp.co.kokou.elements.Element;

/**
 * Element を順に訪れて処理を行う Visitor インターフェースです
 */
@FunctionalInterface
public interface Visitor {
    /**
     * 往訪した Element の情報を受け取って「処理」を行います
     *
     * @param element 往訪した要素です
     */
    void visit(Element element);
}
