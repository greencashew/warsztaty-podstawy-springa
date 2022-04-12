package dev.greencashew.linkshortener.link.api;

public interface LinkService {
    LinkDto createLink(LinkDto linkDto);

    LinkDto gatherLinkAndIncrementVisits(String id);
}
