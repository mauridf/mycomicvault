package com.mycomicvault.api.dto;

import java.util.Set;
import java.util.UUID;

public class HQDTO {
    private UUID id;
    private String aliases;
    private Integer countOfIssues;
    private String deck;
    private Integer idComicVineVolume;
    private String imagemMediumUrl;
    private String imagemSmallUrl;
    private String imagemTinyUrl;
    private String name;
    private String siteDetailUrl;
    private String startYear;

    // Apenas IDs, como você pretendia
    private Set<UUID> editoras;
    private Set<UUID> personagens;
    private Set<UUID> equipes;
    private Set<UUID> edicoes;

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

    public Integer getCountOfIssues() {
        return countOfIssues;
    }

    public void setCountOfIssues(Integer countOfIssues) {
        this.countOfIssues = countOfIssues;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public Integer getIdComicVineVolume() {
        return idComicVineVolume;
    }

    public void setIdComicVineVolume(Integer idComicVineVolume) {
        this.idComicVineVolume = idComicVineVolume;
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

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public Set<UUID> getEditoras() {
        return editoras;
    }

    public void setEditoras(Set<UUID> editoras) {
        this.editoras = editoras;
    }

    public Set<UUID> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Set<UUID> personagens) {
        this.personagens = personagens;
    }

    public Set<UUID> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<UUID> equipes) {
        this.equipes = equipes;
    }

    public Set<UUID> getEdicoes() {
        return edicoes;
    }

    public void setEdicoes(Set<UUID> edicoes) {
        this.edicoes = edicoes;
    }
}
