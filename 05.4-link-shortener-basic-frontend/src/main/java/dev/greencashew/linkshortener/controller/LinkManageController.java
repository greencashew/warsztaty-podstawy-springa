package dev.greencashew.linkshortener.controller;


import dev.greencashew.linkshortener.link.api.LinkDto;
import dev.greencashew.linkshortener.link.api.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/links")
class LinkManageController {

    private final LinkService service;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link) {
        return service.createLink(link.toDto());
    }
}
