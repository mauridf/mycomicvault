package com.mycomicvault.api.dto;

import java.util.UUID;

public class EditoraDTO {

    private UUID id;
    private String aliases;
    private String deck;
    private Integer idComicVinePublisher;
    private String logotipoMediumUrl;
    private String logotipoSmallUrl;
    private String logotipoTinyUrl;
    private String address;
    private String city;
    private String state;
    private String name;
    private String siteDetailUrl;

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
}
