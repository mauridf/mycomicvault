package com.mycomicvault.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Set;

@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "aliases", columnDefinition = "TEXT")
    private String aliases;

    @Column(name = "count_of_issue_appearances")
    private Integer countOfIssueAppearances;

    @Column(name = "count_of_team_members")
    private Integer countOfTeamMembers;

    @Column(name = "deck", columnDefinition = "TEXT")
    private String deck;

    @Column(name = "first_appeared_name")
    private String firstAppearedName;

    @Column(name = "first_appeared_issue_number")
    private String firstAppearedIssueNumber;

    @Column(name = "id_comic_vine_team")
    private Integer idComicVineTeam;

    @Column(name = "imagem_medium_url")
    private String imagemMediumUrl;

    @Column(name = "imagem_small_url")
    private String imagemSmallUrl;

    @Column(name = "imagem_tiny_url")
    private String imagemTinyUrl;

    @Column(nullable = false)
    private String name;

    @Column(name = "site_detail_url")
    private String siteDetailUrl;

    @ManyToMany(mappedBy = "equipes")
    private Set<HQ> hqs;

    public Equipe() {
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

    public Set<HQ> getHqs() {
        return hqs;
    }

    public void setHqs(Set<HQ> hqs) {
        this.hqs = hqs;
    }
}
