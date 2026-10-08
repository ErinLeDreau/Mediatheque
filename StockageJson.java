package Utils;

import Interfaces.Appareil;
import Interfaces.Reglable;
import Interfaces.Stockage;
import Models.Lampe;
import Models.MachineACafe;
import Models.Thermostat;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StockageJson implements Stockage {

    private final String chemin;
    private final ObjectMapper mapper;

    public StockageJson(String chemin) {
        this.chemin = chemin;
        this.mapper = new ObjectMapper();
    }

    @Override
    public void sauvegarder(List<Appareil> appareils) throws IOException {
        ArrayNode racine = mapper.createArrayNode();

        for (Appareil appareil : appareils) {
            ObjectNode json = mapper.createObjectNode();
            json.put("type", typeDe(appareil));
            json.put("nom", appareil.getNom());
            json.put("allume", appareil.estAllume());

            if (appareil instanceof Reglable reglable) {
                json.put("niveau", reglable.getNiveau());
            }

            racine.add(json);
        }

        Path fichier = Path.of(chemin);
        if (fichier.getParent() != null) {
            Files.createDirectories(fichier.getParent());
        }
        mapper.writerWithDefaultPrettyPrinter().writeValue(fichier.toFile(), racine);
    }

    @Override
    public List<Appareil> charger() throws IOException {
        Path fichier = Path.of(chemin);
        if (!Files.exists(fichier)) {
            return new ArrayList<>();
        }

        JsonNode racine = mapper.readTree(fichier.toFile());
        List<Appareil> appareils = new ArrayList<>();

        for (JsonNode json : racine) {
            String type = json.get("type").asString();
            String nom = json.get("nom").asString();
            Appareil appareil;

            switch (type) {
                case "Lampe" -> appareil = new Lampe(nom);
                case "Thermostat" -> appareil = new Thermostat(nom);
                case "MachineACafe" -> appareil = new MachineACafe(nom);
                default -> throw new IllegalArgumentException("Type d'appareil inconnu : " + type);
            }

            if (appareil instanceof Reglable reglable) {
                reglable.setNiveau(json.get("niveau").asInt());
            }

            if (json.get("allume").asBoolean()) {
                appareil.allumer();
            } else {
                appareil.eteindre();
            }

            appareils.add(appareil);
        }

        return appareils;
    }

    private String typeDe(Appareil appareil) throws IOException {
        if (appareil instanceof Lampe) {
            return "Lampe";
        }
        if (appareil instanceof Thermostat) {
            return "Thermostat";
        }
        if (appareil instanceof MachineACafe) {
            return "MachineACafe";
        }
        throw new IOException("Type d'appareil non pris en charge : "
                + appareil.getClass().getName());
    }
}
