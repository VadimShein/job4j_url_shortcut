package ru.job4j.shortcut.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.shortcut.entity.Url;
import ru.job4j.shortcut.entity.Site;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UrlRepository extends CrudRepository<Url, Long> {
    List<Url> findBySite(Site site);
    Optional<Url> findByCode(String code);
    Optional<Url> findByUrl(String url);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update Url u set u.total = u.total + 1 where u = ?1")
    int increaseTotal(Url url);
}
