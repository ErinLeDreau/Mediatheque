package Sauvegarde;

import Videotheque.Modeles.Abstracts.Video;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StockageJsonVideotheque {

    private final String chemin;
    private final ObjectMapper mapper = new ObjectMapper();

    public StockageJsonVideotheque(String chemin) {
        this.chemin = chemin;
    }

    public void sauvegarder(List<Video> videos) throws IOException {
        preparerFichier();
        mapper.writerFor(new TypeReference<List<Video>>() {})
                .withDefaultPrettyPrinter()
                .writeValue(Path.of(chemin).toFile(), videos);
    }

    public List<Video> charger() throws IOException {
        Path fichier = Path.of(chemin);
        if (!Files.exists(fichier)) {
            return new ArrayList<>();
        }
        return mapper.readValue(fichier.toFile(), new TypeReference<List<Video>>() {});
    }

    private void preparerFichier() throws IOException {
        Path fichier = Path.of(chemin);
        if (fichier.getParent() != null) {
            Files.createDirectories(fichier.getParent());
        }
    }
}
