package ru.job4j.shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4j.shortcut.entity.Url;
import ru.job4j.shortcut.entity.Site;
import ru.job4j.shortcut.repository.UrlRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Url registerLink(Url url) {
        Optional<Url> findLink = urlRepository.findByUrl(url.getUrl());
        if (findLink.isPresent()) {
            return findLink.get();
        }
        url.setCode(UUID.randomUUID().toString());
        urlRepository.save(url);
        return url;
    }

    public Url findByCode(String code) {
        return urlRepository.findByCode(code).get();
    }

    public int updateStatistic(Url url) {
        return urlRepository.increaseTotal(url);
    }

    public List<Url> findBySite(Site site) {
        return urlRepository.findBySite(site);
    }
}
