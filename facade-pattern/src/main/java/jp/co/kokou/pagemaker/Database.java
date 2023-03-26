package jp.co.kokou.pagemaker;

import jp.co.kokou.data.EmailAddress;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Component
public class Database {
    @NonNull
    private final String db;

    public Database(@NonNull @Value("${maildata}") String db) {
        this.db = db;
    }

    @SneakyThrows(IOException.class)
    public List<EmailAddress> getEmailList() {
        var stream = Files.newInputStream(Path.of(this.db), StandardOpenOption.READ);
        try (stream) {
            var prop = new Properties();
            prop.load(stream);

            return prop.entrySet().stream().map(entry -> {
                var email = entry.getKey().toString();
                var name = entry.getValue().toString();

                return new EmailAddress(email, name);
            }).collect(Collectors.toList());
        }
    }
}
