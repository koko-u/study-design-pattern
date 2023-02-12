package jp.co.kokou;

import jp.co.kokou.impl.DisplayImpl;

public class Display {

    public void display(DisplayImpl displayImpl) {

        displayImpl.open();
        displayImpl.print();
        displayImpl.close();
    }
}
