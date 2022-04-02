package dev.greencashew.linkshortener.controller;

import dev.greencashew.linkshortener.link.api.LinkDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

record CreateLinkDto(
        @Schema(description = "Identifier/alias to link. Used for redirection.", example = "link-alias", required = true)
        String id,

        @Schema(description = "User email required for shortened link management (deletion, updating)", example = "test@greencashew.dev", required = true)
        String email,

        @Schema(description = "Destination url we would like to ", example = "https://github.com/greencashew/warsztaty-podstawy-springa", required = true)
        String targetUrl,

        @Schema(description = "Link expiration time. If would like to have shortened link forever do not fill this field.", example = "2054-06-23", required = false)
        LocalDate expirationDate) {

    LinkDto toDto() {
        return new LinkDto(
                id,
                email,
                targetUrl,
                expirationDate,
                0
        );
    }
}
