package dev.greencashew.linkshortener.controller;

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
