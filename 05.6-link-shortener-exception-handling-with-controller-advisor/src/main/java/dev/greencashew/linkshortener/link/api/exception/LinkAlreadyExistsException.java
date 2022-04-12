package dev.greencashew.linkshortener.link.api.exception;

public final class LinkAlreadyExistsException extends LinkBusinessException {

    public LinkAlreadyExistsException(final String id) {
        super("Link with id: " + id + " already exists.");
    }
}
