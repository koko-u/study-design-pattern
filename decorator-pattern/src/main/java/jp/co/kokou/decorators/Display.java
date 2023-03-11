package jp.co.kokou.decorators;

public interface Display {

    int getRows();

    String getText(int rowIndex);

    default void show() {
        for (int rowIndex = 0; rowIndex < getRows(); rowIndex++) {
            System.out.println(getText(rowIndex));
        }
    }
}
