package ru.job4j.shortcut.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.shortcut.entity.Url;
import ru.job4j.shortcut.entity.Site;
import ru.job4j.shortcut.entity.Registration;
import ru.job4j.shortcut.service.UrlService;
import ru.job4j.shortcut.service.SiteService;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
public class SiteController {
    private final SiteService siteService;
    private final UrlService urlService;

    public SiteController(SiteService siteService, UrlService urlService) {
        this.siteService = siteService;
        this.urlService = urlService;
    }

    @PostMapping("/registration")
    public Registration register(@RequestBody Site site) {
        return siteService.register(site);
    }

    @PostMapping("/convert")
    public Url convert(@RequestBody Map<String, String> body, Principal principal) {
        Site site = siteService.findByLogin(principal.getName());
        return urlService.registerLink(new Url(body.get("url"), site));
    }

    @GetMapping("/redirect/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        Url url = urlService.findByCode(code);
        if (url == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        urlService.updateStatistic(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", url.getUrl());
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/statistic")
    public List<Url> statistic(Principal principal) {
        return urlService.findBySite(siteService.findByLogin(principal.getName())
        );
    }
}