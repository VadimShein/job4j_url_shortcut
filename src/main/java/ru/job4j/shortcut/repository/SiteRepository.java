package ru.job4j.shortcut.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.shortcut.entity.Site;

import java.util.Optional;

public interface SiteRepository extends CrudRepository<Site, Long> {
    Optional<Site> findByLogin(String login);
    Optional<Site> findBySite(String site);
}
