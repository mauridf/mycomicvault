package com.mycomicvault.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Set;

@Entity
@Table(name = "hq")
public class HQ {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "aliases", columnDefinition = "TEXT")
    private String aliases;

    @Column(name = "count_of_issues")
    private Integer countOfIssues;

    @Column(name = "deck", columnDefinition = "TEXT")
    private String deck;

    @Column(name = "id_comic_vine_volume")
    private Integer idComicVineVolume;

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

    @Column(name = "start_year")
    private String startYear;

    @ManyToMany
    @JoinTable(
            name = "hq_editora",
            joinColumns = @JoinColumn(name = "hq_id"),
            inverseJoinColumns = @JoinColumn(name = "editora_id")
    )
    private Set<Editora> editoras;

    @ManyToMany
    @JoinTable(
            name = "hq_personagem",
            joinColumns = @JoinColumn(name = "hq_id"),
            inverseJoinColumns = @JoinColumn(name = "personagem_id")
    )
    private Set<Personagem> personagens;

    @ManyToMany
    @JoinTable(
            name = "hq_equipe",
            joinColumns = @JoinColumn(name = "hq_id"),
            inverseJoinColumns = @JoinColumn(name = "equipe_id")
    )
    private Set<Equipe> equipes;

    @OneToMany(mappedBy = "hq", cascade = CascadeType.ALL)
    private Set<Edicao> edicoes;

    public HQ() {
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

    public Set<Editora> getEditoras() {
        return editoras;
    }

    public void setEditoras(Set<Editora> editoras) {
        this.editoras = editoras;
    }

    public Set<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Set<Personagem> personagens) {
        this.personagens = personagens;
    }

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
    }

    public Set<Edicao> getEdicoes() {
        return edicoes;
    }

    public void setEdicoes(Set<Edicao> edicoes) {
        this.edicoes = edicoes;
    }
}
