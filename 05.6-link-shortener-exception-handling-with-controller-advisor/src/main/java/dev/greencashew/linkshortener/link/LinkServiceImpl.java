package dev.greencashew.linkshortener.link;

import dev.greencashew.linkshortener.link.api.LinkDto;
import dev.greencashew.linkshortener.link.api.LinkService;
import dev.greencashew.linkshortener.link.api.exception.LinkAlreadyExistsException;
import dev.greencashew.linkshortener.link.api.exception.LinkNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class LinkServiceImpl implements LinkService {

    private final CrudRepository<LinkEntity, String> repository;

    @Override
    @Transactional
    public LinkDto createLink(final LinkDto createLink) throws LinkAlreadyExistsException {
        if (repository.findById(createLink.id()).isPresent()) {
            throw new LinkAlreadyExistsException(createLink.id());
        }

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
