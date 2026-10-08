package Sauvegarde;

import Discotheque.Modele.Abstract.Album;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StockageJsonDiscotheque {

    private final String chemin;
    private final ObjectMapper mapper = new ObjectMapper();

    public StockageJsonDiscotheque(String chemin) {
        this.chemin = chemin;
    }

    public void sauvegarder(List<Album> albums) throws IOException {
        preparerFichier();
        mapper.writerFor(new TypeReference<List<Album>>() {})
                .withDefaultPrettyPrinter()
                .writeValue(Path.of(chemin).toFile(), albums);
    }

    public List<Album> charger() throws IOException {
        Path fichier = Path.of(chemin);
        if (!Files.exists(fichier)) {
            return new ArrayList<>();
        }
        return mapper.readValue(fichier.toFile(), new TypeReference<List<Album>>() {});
    }

    private void preparerFichier() throws IOException {
        Path fichier = Path.of(chemin);
        if (fichier.getParent() != null) {
            Files.createDirectories(fichier.getParent());
        }
    }
}
