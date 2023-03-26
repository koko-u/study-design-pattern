package jp.co.kokou.data;


import org.springframework.lang.NonNull;

public record EmailAddress(@NonNull String email, @NonNull String name) {
}
