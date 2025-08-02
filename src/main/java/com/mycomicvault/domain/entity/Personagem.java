package com.mycomicvault.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Set;

@Entity
@Table(name = "personagem")
public class Personagem {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "aliases", columnDefinition = "TEXT")
    private String aliases;

    private String birth;

    @Column(name = "count_of_issue_appearances")
    private Integer countOfIssueAppearances;

    @Column(name = "deck", columnDefinition = "TEXT")
    private String deck;

    @Column(name = "first_appeared_name")
    private String firstAppearedName;

    @Column(name = "first_appeared_issue_number")
    private String firstAppearedIssueNumber;

    private String gender;

    @Column(name = "id_comic_vine_character")
    private Integer idComicVineCharacter;

    @Column(name = "imagem_medium_url")
    private String imagemMediumUrl;

    @Column(name = "imagem_small_url")
    private String imagemSmallUrl;

    @Column(name = "imagem_tiny_url")
    private String imagemTinyUrl;

    @Column(nullable = false)
    private String name;

    @Column(name = "origin_name")
    private String originName;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "site_detail_url")
    private String siteDetailUrl;

    @ManyToMany(mappedBy = "personagens")
    private Set<HQ> hqs;

    public Personagem() {
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

    public Set<HQ> getHqs() {
        return hqs;
    }

    public void setHqs(Set<HQ> hqs) {
        this.hqs = hqs;
    }
}
