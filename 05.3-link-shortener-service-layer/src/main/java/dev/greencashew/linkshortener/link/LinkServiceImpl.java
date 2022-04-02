package dev.greencashew.linkshortener.link;

import dev.greencashew.linkshortener.link.api.LinkDto;
import dev.greencashew.linkshortener.link.api.LinkService;
import dev.greencashew.linkshortener.link.api.exception.LinkNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@AllArgsConstructor
class LinkServiceImpl implements LinkService {

    final HashMap<String, LinkDto> linkRepository = new HashMap<>();

    @Override
    @Transactional
    public LinkDto createLink(final LinkDto createLink) {
        linkRepository.put(createLink.id(), createLink);
        return createLink;
    }

    @Override
    @Transactional
    public LinkDto gatherLinkAndIncrementVisits(final String id) {
        final LinkDto linkDto = linkRepository.get(id);
        if (linkDto == null) {
            throw new LinkNotFoundException(id);
        }
        final LinkDto updatedLink = new LinkDto(id, linkDto.email(), linkDto.targetUrl(), linkDto.expirationDate(), linkDto.visits() + 1);
        linkRepository.replace(id, updatedLink);
        return updatedLink;
    }
}
