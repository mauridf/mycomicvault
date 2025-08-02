package com.mycomicvault.api.mapper;

import com.mycomicvault.api.dto.PersonagemDTO;
import com.mycomicvault.domain.entity.Personagem;

public class PersonagemMapper {

    public static PersonagemDTO toDTO(Personagem personagem) {
        PersonagemDTO dto = new PersonagemDTO();
        dto.setId(personagem.getId());
        dto.setAliases(personagem.getAliases());
        dto.setBirth(personagem.getBirth());
        dto.setCountOfIssueAppearances(personagem.getCountOfIssueAppearances());
        dto.setDeck(personagem.getDeck());
        dto.setFirstAppearedName(personagem.getFirstAppearedName());
        dto.setFirstAppearedIssueNumber(personagem.getFirstAppearedIssueNumber());
        dto.setGender(personagem.getGender());
        dto.setIdComicVineCharacter(personagem.getIdComicVineCharacter());
        dto.setImagemMediumUrl(personagem.getImagemMediumUrl());
        dto.setImagemSmallUrl(personagem.getImagemSmallUrl());
        dto.setImagemTinyUrl(personagem.getImagemTinyUrl());
        dto.setName(personagem.getName());
        dto.setOriginName(personagem.getOriginName());
        dto.setRealName(personagem.getRealName());
        dto.setSiteDetailUrl(personagem.getSiteDetailUrl());
        return dto;
    }

    public static Personagem toEntity(PersonagemDTO dto) {
        Personagem personagem = new Personagem();
        if (dto.getId() != null) {
            personagem.setId(dto.getId());
        }
        personagem.setAliases(dto.getAliases());
        personagem.setBirth(dto.getBirth());
        personagem.setCountOfIssueAppearances(dto.getCountOfIssueAppearances());
        personagem.setDeck(dto.getDeck());
        personagem.setFirstAppearedName(dto.getFirstAppearedName());
        personagem.setFirstAppearedIssueNumber(dto.getFirstAppearedIssueNumber());
        personagem.setGender(dto.getGender());
        personagem.setIdComicVineCharacter(dto.getIdComicVineCharacter());
        personagem.setImagemMediumUrl(dto.getImagemMediumUrl());
        personagem.setImagemSmallUrl(dto.getImagemSmallUrl());
        personagem.setImagemTinyUrl(dto.getImagemTinyUrl());
        personagem.setName(dto.getName());
        personagem.setOriginName(dto.getOriginName());
        personagem.setRealName(dto.getRealName());
        personagem.setSiteDetailUrl(dto.getSiteDetailUrl());
        return personagem;
    }
}
