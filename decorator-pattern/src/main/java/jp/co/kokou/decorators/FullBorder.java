package jp.co.kokou.decorators;

import java.util.stream.IntStream;

public class FullBorder implements Display {

    private final Display component;
    private final char border;
    private final char ceiling;
    private final int columns;

    public FullBorder(Display component, char border, char ceiling) {
        this.component = component;
        this.border = border;
        this.ceiling = ceiling;
        this.columns = IntStream.range(0, component.getRows())
                .map(rowIndex -> component.getText(rowIndex).length())
                .max()
                .orElse(0);
    }

    @Override
    public int getRows() {
        return component.getRows() + 2;
    }

    @Override
    public String getText(int rowIndex) {
        if (rowIndex == 0) {
            return "+" + String.valueOf(this.ceiling).repeat(this.columns + 2) + "+";
        }
        if (rowIndex > 0 && rowIndex < getRows() - 1) {
            String text = component.getText(rowIndex - 1);
            var padding = this.columns - text.length();
            return String.valueOf(this.border) + " " + text + " ".repeat(padding + 1) + String.valueOf(this.border);
        }
        if (rowIndex == getRows() - 1) {
            return "+" + String.valueOf(this.ceiling).repeat(this.columns + 2) + "+";
        }
        return "";
    }
}
