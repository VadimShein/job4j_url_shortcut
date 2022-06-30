package ru.job4j.shortcut.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "urls")
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String url;
    private String code;
    private int total;

    @ManyToOne
    @JsonIgnore
    private Site site;

    public Url() { }

    public Url(String url, Site site) {
        this.url = url;
        this.site = site;
    }

    public Url(String url, Site site, String code) {
        this.url = url;
        this.site = site;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Url url = (Url) o;
        return Objects.equals(id, url.id)
                && Objects.equals(this.url, url.url)
                && Objects.equals(site, url.site);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, site);
    }

    @Override
    public String toString() {
        return "Url{"
                + "id=" + id
                + ", url='" + url + '\''
                + ", code='" + code + '\''
                + ", total=" + total
                + ", site=" + site
                + '}';
    }
}

