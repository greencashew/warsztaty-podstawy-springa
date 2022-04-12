package dev.greencashew.linkshortener.link;

import dev.greencashew.linkshortener.link.api.LinkDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class LinkEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String targetUrl;

    private LocalDate expirationDate;

    private int visits;

    static LinkEntity fromDto(LinkDto link) {
        return new LinkEntity(
                link.id(),
                link.email(),
                link.targetUrl(),
                link.expirationDate(),
                link.visits()
        );
    }

    LinkDto toDto() {
        return new LinkDto(id, email, targetUrl, expirationDate, visits);
    }
}
