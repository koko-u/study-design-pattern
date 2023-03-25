package jp.co.kokou.elements;

import jp.co.kokou.visitors.Visitor;

import java.util.Iterator;

/**
 * Visitor が往訪する対象となる Element を表現するインターフェースです
 */
public interface Element {

    /**
     * 訪問者を受け取ります
     *
     * @param visitor 訪れた訪問者です
     */
    default void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * @return 自身の子供を順に走査するためのイテレータです
     */
    Iterator<Element> getIterator();
}
