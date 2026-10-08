package Discotheque.Modele;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Auteur {

    private String nom;
    private String prenom;

    @JsonCreator
    public Auteur(@JsonProperty("nom") String nom, @JsonProperty("prenom") String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Auteur() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return this.nom + " " + this.prenom;
    }
}
