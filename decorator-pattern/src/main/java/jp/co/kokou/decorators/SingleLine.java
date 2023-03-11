package jp.co.kokou.decorators;

public record SingleLine(String text) implements Display {
    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getText(int rowIndex) {
        if (rowIndex == 0) {
            return this.text;
        }
        return "";
    }
}
