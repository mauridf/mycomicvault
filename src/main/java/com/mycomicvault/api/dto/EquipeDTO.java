package com.mycomicvault.api.dto;

import com.mycomicvault.domain.entity.HQ;

import java.util.Set;
import java.util.UUID;

public class EquipeDTO {
    private UUID id;
    private String aliases;
    private Integer countOfIssueAppearances;
    private Integer countOfTeamMembers;
    private String deck;
    private String firstAppearedName;
    private String firstAppearedIssueNumber;
    private Integer idComicVineTeam;
    private String imagemMediumUrl;
    private String imagemSmallUrl;
    private String imagemTinyUrl;
    private String name;
    private String siteDetailUrl;
    private Set<UUID> hqs;

    // Getters e Setters
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

    public Integer getCountOfIssueAppearances() {
        return countOfIssueAppearances;
    }

    public void setCountOfIssueAppearances(Integer countOfIssueAppearances) {
        this.countOfIssueAppearances = countOfIssueAppearances;
    }

    public Integer getCountOfTeamMembers() {
        return countOfTeamMembers;
    }

    public void setCountOfTeamMembers(Integer countOfTeamMembers) {
        this.countOfTeamMembers = countOfTeamMembers;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getFirstAppearedName() {
        return firstAppearedName;
    }

    public void setFirstAppearedName(String firstAppearedName) {
        this.firstAppearedName = firstAppearedName;
    }

    public String getFirstAppearedIssueNumber() {
        return firstAppearedIssueNumber;
    }

    public void setFirstAppearedIssueNumber(String firstAppearedIssueNumber) {
        this.firstAppearedIssueNumber = firstAppearedIssueNumber;
    }

    public Integer getIdComicVineTeam() {
        return idComicVineTeam;
    }

    public void setIdComicVineTeam(Integer idComicVineTeam) {
        this.idComicVineTeam = idComicVineTeam;
    }

    public String getImagemMediumUrl() {
        return imagemMediumUrl;
    }

    public void setImagemMediumUrl(String imagemMediumUrl) {
        this.imagemMediumUrl = imagemMediumUrl;
    }

    public String getImagemSmallUrl() {
        return imagemSmallUrl;
    }

    public void setImagemSmallUrl(String imagemSmallUrl) {
        this.imagemSmallUrl = imagemSmallUrl;
    }

    public String getImagemTinyUrl() {
        return imagemTinyUrl;
    }

    public void setImagemTinyUrl(String imagemTinyUrl) {
        this.imagemTinyUrl = imagemTinyUrl;
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

    public Set<UUID> getHqs() {
        return hqs;
    }

    public void setHqs(Set<UUID> hqs) {
        this.hqs = hqs;
    }
}
