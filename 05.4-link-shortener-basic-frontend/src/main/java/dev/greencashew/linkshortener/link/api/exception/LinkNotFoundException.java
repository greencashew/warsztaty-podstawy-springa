package dev.greencashew.linkshortener.link.api.exception;

public final class LinkNotFoundException extends LinkBusinessException {

    public LinkNotFoundException(final String url) {
        super("Shortened link " + url + " not found.");
    }
}
