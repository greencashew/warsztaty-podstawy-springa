package dev.greencashew.linkshortener.controller;

import dev.greencashew.linkshortener.link.api.LinkDto;
import dev.greencashew.linkshortener.link.api.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/s")
class RedirectController {

    private final LinkService service;

    @GetMapping("/{id}")
    public void redirectLink(
            @PathVariable String id, HttpServletResponse httpServletResponse) throws IOException {

        final LinkDto linkDto = service.gatherLinkAndIncrementVisits(id);
        httpServletResponse.sendRedirect(linkDto.targetUrl());
    }
}
