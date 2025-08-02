package com.mycomicvault.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Set;

@Entity
@Table(name = "editora")
public class Editora {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "aliases", columnDefinition = "TEXT")
    private String aliases;

    @Column(name = "deck", columnDefinition = "TEXT")
    private String deck;

    @Column(name = "id_comic_vine_publisher")
    private Integer idComicVinePublisher;

    @Column(name = "logotipo_medium_url")
    private String logotipoMediumUrl;

    @Column(name = "logotipo_small_url")
    private String logotipoSmallUrl;

    @Column(name = "logotipo_tiny_url")
    private String logotipoTinyUrl;

    private String address;

    private String city;

    private String state;

    @Column(nullable = false)
    private String name;

    @Column(name = "site_detail_url")
    private String siteDetailUrl;

    @ManyToMany(mappedBy = "editoras")
    private Set<HQ> hqs;

    // Construtor padrão
    public Editora() {
        this.id = UUID.randomUUID();
    }

    // Getters e setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public Integer getIdComicVinePublisher() {
        return idComicVinePublisher;
    }

    public void setIdComicVinePublisher(Integer idComicVinePublisher) {
        this.idComicVinePublisher = idComicVinePublisher;
    }

    public String getLogotipoMediumUrl() {
        return logotipoMediumUrl;
    }

    public void setLogotipoMediumUrl(String logotipoMediumUrl) {
        this.logotipoMediumUrl = logotipoMediumUrl;
    }

    public String getLogotipoSmallUrl() {
        return logotipoSmallUrl;
    }

    public void setLogotipoSmallUrl(String logotipoSmallUrl) {
        this.logotipoSmallUrl = logotipoSmallUrl;
    }

    public String getLogotipoTinyUrl() {
        return logotipoTinyUrl;
    }

    public void setLogotipoTinyUrl(String logotipoTinyUrl) {
        this.logotipoTinyUrl = logotipoTinyUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteDetailUrl() {
        return siteDetailUrl;
    }

    public void setSiteDetailUrl(String siteDetailUrl) {
        this.siteDetailUrl = siteDetailUrl;
    }

    public Set<HQ> getHqs() {
        return hqs;
    }

    public void setHqs(Set<HQ> hqs) {
        this.hqs = hqs;
    }
}
