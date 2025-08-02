package com.mycomicvault.api.mapper;

import com.mycomicvault.api.dto.EditoraDTO;
import com.mycomicvault.domain.entity.Editora;

public class EditoraMapper {

    public static EditoraDTO toDTO(Editora editora) {
        EditoraDTO dto = new EditoraDTO();
        dto.setId(editora.getId());
        dto.setAliases(editora.getAliases());
        dto.setDeck(editora.getDeck());
        dto.setIdComicVinePublisher(editora.getIdComicVinePublisher());
        dto.setLogotipoMediumUrl(editora.getLogotipoMediumUrl());
        dto.setLogotipoSmallUrl(editora.getLogotipoSmallUrl());
        dto.setLogotipoTinyUrl(editora.getLogotipoTinyUrl());
        dto.setAddress(editora.getAddress());
        dto.setCity(editora.getCity());
        dto.setState(editora.getState());
        dto.setName(editora.getName());
        dto.setSiteDetailUrl(editora.getSiteDetailUrl());
        return dto;
    }

    public static Editora toEntity(EditoraDTO dto) {
        Editora editora = new Editora();
        // Se o id vier nulo, cria novo, senão usa o passado (para update)
        if (dto.getId() != null) {
            editora.setId(dto.getId());
        }
        editora.setAliases(dto.getAliases());
        editora.setDeck(dto.getDeck());
        editora.setIdComicVinePublisher(dto.getIdComicVinePublisher());
        editora.setLogotipoMediumUrl(dto.getLogotipoMediumUrl());
        editora.setLogotipoSmallUrl(dto.getLogotipoSmallUrl());
        editora.setLogotipoTinyUrl(dto.getLogotipoTinyUrl());
        editora.setAddress(dto.getAddress());
        editora.setCity(dto.getCity());
        editora.setState(dto.getState());
        editora.setName(dto.getName());
        editora.setSiteDetailUrl(dto.getSiteDetailUrl());
        return editora;
    }
}
