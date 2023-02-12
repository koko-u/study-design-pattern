package jp.co.kokou.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;

@RequiredArgsConstructor
public class FileDisplayImpl implements DisplayImpl, AutoCloseable {

    private final String filename;

    @Override
    public void open() {
    }

    @SneakyThrows
    @Override
    public void print() {
        Files.readAllLines(Path.of(filename)).forEach(System.out::println);
    }

    @Override
    public void close() {
    }
}
