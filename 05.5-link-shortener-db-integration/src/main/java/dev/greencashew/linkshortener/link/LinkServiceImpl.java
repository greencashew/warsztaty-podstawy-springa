package dev.greencashew.linkshortener.link;

import dev.greencashew.linkshortener.link.api.LinkDto;
import dev.greencashew.linkshortener.link.api.LinkService;
import dev.greencashew.linkshortener.link.api.exception.LinkNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class LinkServiceImpl implements LinkService {

    private final LinkRepository repository;

    @Override
    @Transactional
    public LinkDto createLink(final LinkDto createLink) {
        final LinkEntity linkEntity = LinkEntity.fromDto(createLink);
        repository.save(linkEntity);
        return createLink;
    }

    @Override
    @Transactional
    public LinkDto gatherLinkAndIncrementVisits(final String id) {
        final LinkEntity linkEntity = repository.findById(id)
                .orElseThrow(() -> new LinkNotFoundException(id));
        linkEntity.setVisits(linkEntity.getVisits() + 1);
        return linkEntity.toDto();
    }
}
