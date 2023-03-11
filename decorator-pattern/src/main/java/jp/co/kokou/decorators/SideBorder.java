package jp.co.kokou.decorators;

public record SideBorder(Display component, char border) implements Display {

    @Override
    public int getRows() {
        return component.getRows();
    }

    @Override
    public String getText(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < getRows()) {
            return "%c %s %c".formatted(border, component.getText(rowIndex), border);
        }
        return "";
    }
}
