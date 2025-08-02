package com.mycomicvault.api.dto;

import com.mycomicvault.domain.entity.HQ;

import java.util.Set;
import java.util.UUID;

public class PersonagemDTO {
    private UUID id;
    private String aliases;
    private String birth;
    private Integer countOfIssueAppearances;
    private String deck;
    private String firstAppearedName;
    private String firstAppearedIssueNumber;
    private String gender;
    private Integer idComicVineCharacter;
    private String imagemMediumUrl;
    private String imagemSmallUrl;
    private String imagemTinyUrl;
    private String name;
    private String originName;
    private String realName;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Integer getCountOfIssueAppearances() {
        return countOfIssueAppearances;
    }

    public void setCountOfIssueAppearances(Integer countOfIssueAppearances) {
        this.countOfIssueAppearances = countOfIssueAppearances;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIdComicVineCharacter() {
        return idComicVineCharacter;
    }

    public void setIdComicVineCharacter(Integer idComicVineCharacter) {
        this.idComicVineCharacter = idComicVineCharacter;
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

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
