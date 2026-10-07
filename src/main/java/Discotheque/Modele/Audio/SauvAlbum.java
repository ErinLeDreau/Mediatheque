package Discotheque.Modele.Audio;

import Discotheque.Exceptions.DoublonException;
import Discotheque.Modele.Abstract.Album;

import java.io.IOException;
import java.util.ArrayList;

public interface SauvAlbum {
    void sauvegarder(ArrayList<Album>albums) throws IOException;
    ArrayList<Album> charger() throws DoublonException, IOException;
}
