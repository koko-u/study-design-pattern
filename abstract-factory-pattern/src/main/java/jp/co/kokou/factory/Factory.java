package jp.co.kokou.factory;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

/**
 * HTMLドキュメントを生成するためのファクトリクラスです
 */
@Slf4j
public abstract class Factory {

    /**
     * HTMLドキュメントを生成するファクトリクラスを取得します
     *
     * @param className ファクトリクラスの完全修飾名です
     * @return ファクトリインスタンスを返却します
     */
    public static Optional<Factory> getFactory(String className) {
        try {
            var clz = Class.forName(className);
            var ctor = clz.getConstructor();
            return Optional.of((Factory) ctor.newInstance());
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * ハイパーリンクを作成します
     *
     * @param title リンクに表示するテキストです
     * @param url   リンク先のURLです
     * @return ハイパーリンクを表すオブジェクトを返却します
     */
    public abstract Link link(String title, String url);

    /**
     * 他のHTML要素を集約する「トレイ」に相当するDOM要素を作成します。
     *
     * @return トレイに相当する要素です。div タグや ul タグを想定しています。
     */
    public abstract Tray tray();

    /**
     * HTML ドキュメント全体を作成します
     *
     * @param title  HTMLドキュメントのタイトルです
     * @param author HTMLドキュメントの製作者です
     * @return HTMLドキュメントを返却します。
     */
    public abstract Page page(String title, String author);
}
