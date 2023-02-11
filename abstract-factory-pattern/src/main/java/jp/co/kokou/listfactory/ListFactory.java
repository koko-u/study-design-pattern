package jp.co.kokou.listfactory;

import jp.co.kokou.factory.*;

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
    public Text text(String text) {
        return new TextItem(text);
    }

    @Override
    public Page page(String title, String author) {
        return new HtmlPage(title, author);
    }
}
