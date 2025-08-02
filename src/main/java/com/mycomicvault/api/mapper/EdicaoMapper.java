package com.mycomicvault.api.mapper;

import com.mycomicvault.api.dto.EdicaoDTO;
import com.mycomicvault.domain.entity.Edicao;
import com.mycomicvault.domain.entity.HQ;

public class EdicaoMapper {

    public static EdicaoDTO toDTO(Edicao edicao) {
        EdicaoDTO dto = new EdicaoDTO();
        dto.setId(edicao.getId());
        dto.setAliases(edicao.getAliases());
        dto.setCoverDate(edicao.getCoverDate());
        dto.setDeck(edicao.getDeck());
        dto.setDescription(edicao.getDescription());
        dto.setCapaMediumUrl(edicao.getCapaMediumUrl());
        dto.setCapaSmallUrl(edicao.getCapaSmallUrl());
        dto.setCapaTinyUrl(edicao.getCapaTinyUrl());
        dto.setIssueNumber(edicao.getIssueNumber());
        dto.setName(edicao.getName());
        dto.setSiteDetailUrl(edicao.getSiteDetailUrl());
        dto.setUrlCapa(edicao.getUrlCapa());

        if (edicao.getHq() != null) {
            dto.setHq(edicao.getHq());
        }

        return dto;
    }

    public static Edicao toEntity(EdicaoDTO dto) {
        Edicao edicao = new Edicao();
        if (dto.getId() != null) {
            edicao.setId(dto.getId());
        }
        edicao.setAliases(dto.getAliases());
        edicao.setCoverDate(dto.getCoverDate());
        edicao.setDeck(dto.getDeck());
        edicao.setDescription(dto.getDescription());
        edicao.setCapaMediumUrl(dto.getCapaMediumUrl());
        edicao.setCapaSmallUrl(dto.getCapaSmallUrl());
        edicao.setCapaTinyUrl(dto.getCapaTinyUrl());
        edicao.setIssueNumber(dto.getIssueNumber());
        edicao.setName(dto.getName());
        edicao.setSiteDetailUrl(dto.getSiteDetailUrl());
        edicao.setUrlCapa(dto.getUrlCapa());

        if (dto.getHq() != null) {
            HQ hq = new HQ();
            hq.setId(dto.getHq()); // Usa apenas o ID da HQ
            edicao.setHq(hq);
        }

        return edicao;
    }
}
