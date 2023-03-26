package jp.co.kokou.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "jp.co.kokou.pagemaker")
public class Config {

    @Bean
    @SneakyThrows(IOException.class)
    Writer getFileWriter(@Value("${filename}") String filename) {
        return new FileWriter(filename);
    }
}
