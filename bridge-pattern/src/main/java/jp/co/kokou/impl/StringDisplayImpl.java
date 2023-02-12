package jp.co.kokou.impl;

import java.util.stream.Collectors;

public record StringDisplayImpl(String text) implements DisplayImpl {

    public String getBorder() {
        // "-".repeat(text().codePoints().count())
        return "+-" + text().codePoints().mapToObj(c -> "-").collect(Collectors.joining()) + "-+";
    }

    @Override
    public void open() {
        System.out.println(getBorder());
    }

    @Override
    public void print() {
        System.out.println("| " + text() + " |");
    }

    @Override
    public void close() {
        System.out.println(getBorder());
    }
}
