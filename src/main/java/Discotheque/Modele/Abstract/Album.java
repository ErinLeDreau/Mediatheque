package Discotheque.Modele.Abstract;

import Discotheque.Modele.Auteur;
import Discotheque.Modele.CompactDisque;
import Discotheque.Modele.DisqueVinyle;
import Discotheque.Modele.FichierNumerique;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CompactDisque.class, name = "CompactDisque"),
        @JsonSubTypes.Type(value = DisqueVinyle.class, name = "DisqueVinyle"),
        @JsonSubTypes.Type(value = FichierNumerique.class, name = "FichierNumerique")
})
public abstract class Album {

    protected String nom;
    protected Auteur auteur;
    protected LocalDate annee;
    protected int quantite;

    protected Album() {
    }

    public Album(String nom, Auteur auteur, LocalDate annee, int quantite) {
        this.nom = nom;
        this.auteur = auteur;
        this.annee = annee;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public LocalDate getAnnee() {
        return annee;
    }

    public void setAnnee(LocalDate annee) {
        this.annee = annee;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @JsonIgnore
    public abstract String getSupport();

    @Override
    public String toString() {
        return " " + nom + " de " + auteur + " sortie en " + annee + " avec " + quantite + " album ";
    }
}
