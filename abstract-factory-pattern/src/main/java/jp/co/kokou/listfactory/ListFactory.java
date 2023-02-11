package jp.co.kokou.listfactory;

import jp.co.kokou.factory.Factory;
import jp.co.kokou.factory.Link;
import jp.co.kokou.factory.Page;
import jp.co.kokou.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link link(String title, String url) {
        return new PlainLink(title, url);
    }

    @Override
    public Tray tray() {
        return new UnorderdListTray();
    }

    @Override
    public Page page(String title, String author) {
        return new HtmlPage(title, author);
    }
}
