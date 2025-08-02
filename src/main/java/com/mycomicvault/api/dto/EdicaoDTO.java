package com.mycomicvault.api.dto;

import com.mycomicvault.domain.entity.HQ;

import java.util.UUID;

public class EdicaoDTO {
    private UUID id;
    private String aliases;
    private String coverDate;
    private String deck;
    private String description;
    private String capaMediumUrl;
    private String capaSmallUrl;
    private String capaTinyUrl;
    private String issueNumber;
    private String name;
    private String siteDetailUrl;
    private String urlCapa;
    private UUID hqId; // FK para HQ

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

    public String getCoverDate() {
        return coverDate;
    }

    public void setCoverDate(String coverDate) {
        this.coverDate = coverDate;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCapaMediumUrl() {
        return capaMediumUrl;
    }

    public void setCapaMediumUrl(String capaMediumUrl) {
        this.capaMediumUrl = capaMediumUrl;
    }

    public String getCapaSmallUrl() {
        return capaSmallUrl;
    }

    public void setCapaSmallUrl(String capaSmallUrl) {
        this.capaSmallUrl = capaSmallUrl;
    }

    public String getCapaTinyUrl() {
        return capaTinyUrl;
    }

    public void setCapaTinyUrl(String capaTinyUrl) {
        this.capaTinyUrl = capaTinyUrl;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
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

    public String getUrlCapa() {
        return urlCapa;
    }

    public void setUrlCapa(String urlCapa){
        this.urlCapa = urlCapa;
    }
    public UUID getHq() {
        return hqId;
    }

    public void setHq(HQ hq) {
        this.hqId = hq.getId();
    }
}
