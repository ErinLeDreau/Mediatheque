package Sauvegarde;
import Discotheque.Modele.Abstract.Album;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FichierJson<T> {
    private static final ObjectMapper MAPPER = JsonMapper.builder().addMixIn(Album.class, AlbumJson.class).build();

    private final Path chemin;
    private final JavaType typeListe;

    FichierJson(Path chemin, Class<T> typeElement) {
        this.chemin = chemin;
        // Le type complet (List<T>) est indispensable : sans lui, Jackson
        // n'écrit pas le champ "support" qui permet de retrouver la sous-classe.
        this.typeListe = MAPPER.getTypeFactory().constructCollectionType(List.class, typeElement);
    }

    void ecrire(List<T> elements) throws IOException {
        Path dossier = chemin.toAbsolutePath().getParent();
        if (dossier != null) {
            Files.createDirectories(dossier);
        }
        try {
            MAPPER.writerFor(typeListe)
                    .withDefaultPrettyPrinter()
                    .writeValue(chemin.toFile(), elements);
        } catch (Exception e) {
            throw new IOException("Impossible d'écrire " + chemin + " : " + e.getMessage(), e);
        }
    }

    List<T> lire() throws IOException {
        File fichier = chemin.toFile();
        if (!fichier.exists()) {
            return new ArrayList<>();
        }
        try {
            return MAPPER.readValue(fichier, typeListe);
        } catch (Exception e) {
            throw new IOException("Fichier " + chemin + " illisible : " + e.getMessage(), e);
        }
    }
}