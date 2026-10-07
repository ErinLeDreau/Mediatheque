package Sauvegarde;

import Discotheque.Exceptions.DoublonException;
import Discotheque.Modele.Abstract.Album;
import Discotheque.Modele.Audio.SauvAlbum;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class SauvAlbumJson implements SauvAlbum {
    private final FichierJson<Album> fichier;

    public SauvAlbumJson(Path chemin) {
        this.fichier = new FichierJson<>(chemin, Album.class);
    }

    @Override
    public void sauvegarder(ArrayList<Album> albums) throws IOException {
        fichier.ecrire(albums);
    }

    @Override
    public ArrayList<Album> charger() throws IOException {
        return new ArrayList<>(fichier.lire());
    }
}
