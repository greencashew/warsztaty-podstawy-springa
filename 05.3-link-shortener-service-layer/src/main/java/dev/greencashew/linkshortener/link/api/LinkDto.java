package dev.greencashew.linkshortener.link.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public record LinkDto(
        String id,
        @JsonIgnore String email,
        String targetUrl,
        LocalDate expirationDate,
        int visits
) {
}
