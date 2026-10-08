package Discotheque.Modele;

import Discotheque.Exceptions.AlbumIntrouvableException;
import Discotheque.Exceptions.DiscothequeVideException;
import Discotheque.Exceptions.DoublonException;
import Discotheque.Modele.Abstract.Album;

import java.util.ArrayList;
import java.util.List;

public class Discotheque {
    private static List<Album> discotheque = new ArrayList<>();


    /**public static void creerAlbum(Album a) {
        // ajouter le disque à la discotheque
        getDiscotheque().add(a);
        System.out.println("Album ajouté la discotheque");
    }

    public static void supprimerAlbumParNom(String n) throws DoublonException {
        int compteur =0;
        Album trouve=null;
        for (Album a : getDiscotheque()) {
            if (a.getNom().equals(n)) {
                trouve = a;
                compteur++;
            }
        }
        //levée d'exception si supprime 2 disques
        if(compteur>1){
            throw new DoublonException("Doublons détectés! Utiliser l'autre suppression : choix 3");
        }
        else if(compteur==1) {
            getDiscotheque().remove(trouve);
            System.out.println("disque supprimé de la discotheque");
        }else {
            System.err.println("Impossible de supprimer.disque non trouvé!");
        }
    }

    public static void supprimeAlbum(String n, Auteur auteur) {
        Album trouve = null;
        for (Album a : getDiscotheque()) {
            if (a.getNom().equals(n) &&
                    a.getAuteur().getNom().equals(auteur.getNom()) &&
                    a.getAuteur().getPrenom().equals(auteur.getPrenom())) {
                trouve = a;
                break;
            }
        }
        if (trouve != null) {
            System.out.println("disque trouvé:" + trouve);
            discotheque.remove(trouve);
            System.out.println("disque supprimé de la discotheque");
        } else {
            System.err.println("Impossible de supprimer.disque non trouvé!");
        }

    }*/

    public static List<Album> getDiscotheque() {
        return discotheque;
    }

    public static void setDiscotheque(List<Album> discotheque) {
        Discotheque.discotheque = discotheque;
    }

    public static void afficherDiscotheque() {
        System.out.println(getDiscotheque());
    }
    public static void viderDiscotheque() {
       getDiscotheque().clear();
        System.out.println("discotheque vidée!");
    }
    public static void ajouterAlbum(Album a) throws DoublonException {
        //TODO vérification si l'album existe déjà dans la discotheque et exception si c'est le cas
        //TODO ajouter album dans discotheque
        try {
            rechercherAlbum(a.getNom());

        } catch (DiscothequeVideException | AlbumIntrouvableException e) {
            discotheque.add(a);
            System.out.println(a + "ajouté avec succès !");
            return;
        }
        throw new DoublonException("Cette album exciste déjà !");
    }

    public static void listerAlbums() throws DiscothequeVideException {
        if (getDiscotheque().isEmpty()) {
            throw new DiscothequeVideException("Discothèque vide !");
        }
        for (Album a : getDiscotheque()) {
            System.out.println(a);
        }
    }

    public static Album rechercherAlbum(String nom) throws AlbumIntrouvableException, DiscothequeVideException {
        if (getDiscotheque().isEmpty()) {
            throw new DiscothequeVideException("La discothèque est vide.");
        }
        for (Album a : getDiscotheque()) {
            if (a.getNom().equalsIgnoreCase(nom)) {
                System.out.println("Album trouvé: " + a);
                return a;
            }
        }
        throw new AlbumIntrouvableException("Album introuvable: " + nom);
    }

    public static void supprimerAlbum(String nom) throws DiscothequeVideException, AlbumIntrouvableException {
        Album a = rechercherAlbum(nom);
        getDiscotheque().remove(a);
        System.out.println("Album supprimé de la discothèque: " + a);
    }
}
