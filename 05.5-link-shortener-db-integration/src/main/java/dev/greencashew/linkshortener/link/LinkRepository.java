package dev.greencashew.linkshortener.link;

import org.springframework.data.repository.CrudRepository;

interface LinkRepository extends CrudRepository<LinkEntity, String> {
}
