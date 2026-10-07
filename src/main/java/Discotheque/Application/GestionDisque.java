package Discotheque.Application;

import Discotheque.Exceptions.DoublonException;
import Discotheque.Modele.Auteur;
import Discotheque.Modele.Disque;

import java.util.ArrayList;

public class GestionDisque {
    private static ArrayList<Disque> discotheque = new ArrayList<>();


    public static void creerDisque(Disque d) {
        // ajouter le disque à la discotheque
        getDiscotheque().add(d);
        System.out.println("disque ajouté la discotheque");
    }

    public static void supprimerDisqueParNom(String n) throws DoublonException {
        int compteur =0;
        Disque trouve=null;
        for (Disque d : getDiscotheque()) {
            if (d.getNom().equals(n)) {
                trouve = d;
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

    public static void supprimerDisque(String n, Auteur a) {
        Disque trouve = null;
        for (Disque d : getDiscotheque()) {
            if (d.getNom().equals(n) &&
                    d.getAuteur().getNom().equals(a.getNom()) && d.getAuteur().getPrenom().equals(a.getPrenom())) {
                trouve = d;
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

    }

    public static ArrayList<Disque> getDiscotheque() {
        return discotheque;
    }

    public static void setDiscotheque(ArrayList<Disque> discotheque) {
        GestionDisque.discotheque = discotheque;
    }

    public static void afficherDiscotheque() {
        System.out.println(getDiscotheque());
    }
    public static void viderDiscotheque() {
       getDiscotheque().clear();
        System.out.println("discotheque vidée!");
    }
}
