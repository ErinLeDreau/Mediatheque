package Discotheque.Modele;

import java.time.LocalDate;

public class Disque {

    private String nom;
    private Auteur auteur;
    private LocalDate annee;

    public Disque() {
    }

    public Disque(String nom, Auteur auteur, LocalDate annee) {
        this.nom = nom;
        this.auteur = auteur;
        this.annee = annee;
    }

    public Disque(String nom, Auteur auteur) {
        this.nom = nom;
        this.auteur = auteur;
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

    @Override
    public String toString() {
        return "disque{" +
                "nom='" + nom + '\'' +
                ", auteur=" + auteur +
                ", annee=" + annee +
                '}';
    }
}
