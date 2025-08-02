package com.mycomicvault.api.controller;

import com.mycomicvault.external.ComicVineClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comicvine")
public class ComicVineController {

    private final ComicVineClient client;

    public ComicVineController(ComicVineClient client) {
        this.client = client;
    }

    @GetMapping("/buscar")
    public ResponseEntity<String> buscar(
            @RequestParam String termo,
            @RequestParam(defaultValue = "issue") String recurso
    ) {
        return client.buscar(termo, recurso);
    }

    @GetMapping("/filtro")
    public ResponseEntity<String> buscarPorFiltro(
            @RequestParam String recurso,
            @RequestParam String nome
    ) {
        return client.buscarPorFiltro(recurso, nome);
    }

    @GetMapping("/edicao")
    public ResponseEntity<String> buscarEdicaoPorVolumeEEdicao(
            @RequestParam String volumeId,
            @RequestParam String numero
    ) {
        return client.buscarEdicaoPorVolumeEEdicao(volumeId, numero);
    }

}
