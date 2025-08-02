package com.mycomicvault.application.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${upload.capas.path}")
    private String uploadDir;

    @Value("${upload.capas.url}")
    private String uploadUrl;

    public String salvarCapa(MultipartFile file) throws IOException {
        String extensao = getExtensao(file.getOriginalFilename());
        String nomeArquivo = UUID.randomUUID() + "." + extensao;

        Path caminhoArquivo = Paths.get(uploadDir + nomeArquivo);

        Files.createDirectories(caminhoArquivo.getParent()); // Garante que a pasta existe
        file.transferTo(caminhoArquivo.toFile());

        return uploadUrl + nomeArquivo; // Exemplo: /uploads/capas/xyz123.jpg
    }

    private String getExtensao(String nome) {
        return nome.substring(nome.lastIndexOf(".") + 1);
    }
}
