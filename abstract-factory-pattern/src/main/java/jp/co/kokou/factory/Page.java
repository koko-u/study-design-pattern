package jp.co.kokou.factory;

/**
 * HTMLページ全体を表すインターフェースです
 */
public interface Page extends Writable {
    /**
     * HTMLページにDOMノードを追加します
     *
     * @param items 追加するDOMノードアイテムです
     * @return 追加されたあとのPageです
     */
    Page items(Item... items);
}
