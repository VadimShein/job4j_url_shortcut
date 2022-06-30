package ru.job4j.shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4j.shortcut.entity.Site;
import ru.job4j.shortcut.entity.Registration;
import ru.job4j.shortcut.repository.SiteRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class SiteService {
    private final SiteRepository siteRepository;

    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public Site findByLogin(String login) {
        return siteRepository.findByLogin(login).get();
    }

    public Registration register(Site site) {
        Optional<Site> findSite = siteRepository.findBySite(site.getSite());
        if (findSite.isPresent()) {
            return new Registration(
                    false, findSite.get().getLogin(), findSite.get().getPassword()
            );
        }
        String login = UUID.randomUUID().toString();
        site.setLogin(login);
        String password = UUID.randomUUID().toString();
        site.setPassword(password);
        siteRepository.save(site);
        return new Registration(true, site.getLogin(), password);
    }
}
