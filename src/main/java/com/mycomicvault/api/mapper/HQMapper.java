package com.mycomicvault.api.mapper;

import com.mycomicvault.api.dto.HQDTO;
import com.mycomicvault.domain.entity.HQ;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class HQMapper {

    public static HQDTO toDTO(HQ hq) {
        HQDTO dto = new HQDTO();
        dto.setId(hq.getId());
        dto.setAliases(hq.getAliases());
        dto.setCountOfIssues(hq.getCountOfIssues());
        dto.setDeck(hq.getDeck());
        dto.setIdComicVineVolume(hq.getIdComicVineVolume());
        dto.setImagemMediumUrl(hq.getImagemMediumUrl());
        dto.setImagemSmallUrl(hq.getImagemSmallUrl());
        dto.setImagemTinyUrl(hq.getImagemTinyUrl());
        dto.setName(hq.getName());
        dto.setSiteDetailUrl(hq.getSiteDetailUrl());
        dto.setStartYear(hq.getStartYear());

        dto.setEditoras(hq.getEditoras().stream().map(e -> e.getId()).collect(Collectors.toSet()));
        dto.setEquipes(hq.getEquipes().stream().map(e -> e.getId()).collect(Collectors.toSet()));
        dto.setPersonagens(hq.getPersonagens().stream().map(p -> p.getId()).collect(Collectors.toSet()));
        // dto.setEdicoes(...) se necessário futuramente

        return dto;
    }

    public static HQ toEntity(HQDTO dto) {
        HQ hq = new HQ();
        if (dto.getId() != null) {
            hq.setId(dto.getId());
        }
        hq.setAliases(dto.getAliases());
        hq.setCountOfIssues(dto.getCountOfIssues());
        hq.setDeck(dto.getDeck());
        hq.setIdComicVineVolume(dto.getIdComicVineVolume());
        hq.setImagemMediumUrl(dto.getImagemMediumUrl());
        hq.setImagemSmallUrl(dto.getImagemSmallUrl());
        hq.setImagemTinyUrl(dto.getImagemTinyUrl());
        hq.setName(dto.getName());
        hq.setSiteDetailUrl(dto.getSiteDetailUrl());
        hq.setStartYear(dto.getStartYear());

        // Os relacionamentos devem ser carregados no service (ex: buscar entidades por ID via repositório)

        return hq;
    }
}
