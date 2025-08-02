package com.mycomicvault.api.mapper;

import com.mycomicvault.api.dto.EquipeDTO;
import com.mycomicvault.domain.entity.Equipe;

public class EquipeMapper {

    public static EquipeDTO toDTO(Equipe equipe) {
        EquipeDTO dto = new EquipeDTO();
        dto.setId(equipe.getId());
        dto.setAliases(equipe.getAliases());
        dto.setDeck(equipe.getDeck());
        dto.setIdComicVineTeam(equipe.getIdComicVineTeam());
        dto.setImagemMediumUrl(equipe.getImagemMediumUrl());
        dto.setImagemSmallUrl(equipe.getImagemSmallUrl());
        dto.setImagemTinyUrl(equipe.getImagemTinyUrl());
        dto.setName(equipe.getName());
        dto.setSiteDetailUrl(equipe.getSiteDetailUrl());
        return dto;
    }

    public static Equipe toEntity(EquipeDTO dto) {
        Equipe equipe = new Equipe();
        if (dto.getId() != null) {
            equipe.setId(dto.getId());
        }
        equipe.setAliases(dto.getAliases());
        equipe.setDeck(dto.getDeck());
        equipe.setIdComicVineTeam(dto.getIdComicVineTeam());
        equipe.setImagemMediumUrl(dto.getImagemMediumUrl());
        equipe.setImagemSmallUrl(dto.getImagemSmallUrl());
        equipe.setImagemTinyUrl(dto.getImagemTinyUrl());
        equipe.setName(dto.getName());
        equipe.setSiteDetailUrl(dto.getSiteDetailUrl());
        return equipe;
    }
}
