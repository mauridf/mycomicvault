package com.mycomicvault.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "edicao")
public class Edicao {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "aliases", columnDefinition = "TEXT")
    private String aliases;

    @Column(name = "cover_date")
    private String coverDate;

    @Column(name = "deck", columnDefinition = "TEXT")
    private String deck;

    private String description;

    @Column(name = "capa_medium_url")
    private String capaMediumUrl;

    @Column(name = "capa_small_url")
    private String capaSmallUrl;

    @Column(name = "capa_tiny_url")
    private String capaTinyUrl;

    @Column(name = "issue_number")
    private String issueNumber;

    @Column(nullable = false)
    private String name;

    @Column(name = "site_detail_url")
    private String siteDetailUrl;

    @Column(name = "url_capa")
    private String urlCapa;

    @ManyToOne
    @JoinColumn(name = "hq_id", nullable = false)
    private HQ hq;

    public Edicao() {
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

    public HQ getHq() {
        return hq;
    }

    public void setHq(HQ hq) {
        this.hq = hq;
    }
}
