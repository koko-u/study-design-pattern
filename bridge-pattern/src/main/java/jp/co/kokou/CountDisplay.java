package jp.co.kokou;

import jp.co.kokou.impl.DisplayImpl;

import java.util.stream.IntStream;

public class CountDisplay extends Display {

    public void multiDisplay(int times, DisplayImpl displayImpl) {
        displayImpl.open();
        IntStream.range(0, times).forEach((i) -> displayImpl.print());
        displayImpl.close();
    }
}
