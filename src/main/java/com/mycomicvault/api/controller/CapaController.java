package com.mycomicvault.api.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/capas")
public class CapaController {

    private final Path diretorioCapa = Paths.get("uploads/capas");

    @GetMapping("/{nomeArquivo:.+}")
    public ResponseEntity<Resource> servirCapa(@PathVariable String nomeArquivo) {
        try {
            Path arquivoPath = diretorioCapa.resolve(nomeArquivo).normalize();
            Resource resource = new UrlResource(arquivoPath.toUri());

            if (resource.exists()) {
                String contentType = Files.probeContentType(arquivoPath);
                if (contentType == null) {
                    contentType = "application/octet-stream";
                }

                return ResponseEntity
                        .ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
