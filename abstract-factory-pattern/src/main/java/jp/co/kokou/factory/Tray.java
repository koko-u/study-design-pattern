package jp.co.kokou.factory;

/**
 * 内部にDOMノードを入れ子に保持することができるDOMノードです
 */
public interface Tray extends Item {
    /**
     * 子ノードを追加します
     *
     * @param items 追加する子ノードです
     * @return 追加したあとのDOMノードです
     */
    Tray items(Item... items);
}
