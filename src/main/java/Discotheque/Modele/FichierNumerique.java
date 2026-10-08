package Discotheque.Modele;

import Discotheque.Modele.Abstract.Album;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;
import java.time.LocalDate;

public class FichierNumerique extends Album {

    private String format;
    private double taille;
    private int duree;
    private String chemin;

    public FichierNumerique() {
    }

    public FichierNumerique(String nom, Auteur auteur, LocalDate annee, int quantite, String format, double taille, int duree) {
        super(nom, auteur, annee, quantite);
        this.format = format;
        this.taille = taille;
        this.duree = duree;
    }

    @JsonCreator
    public FichierNumerique(@JsonProperty("nom") String nom, @JsonProperty("auteur") Auteur auteur,
                            @JsonProperty("annee") LocalDate annee, @JsonProperty("quantite") int quantite,
                            @JsonProperty("format") String format, @JsonProperty("taille") double taille,
                            @JsonProperty("duree") int duree, @JsonProperty("chemin") String chemin) {
        super(nom, auteur, annee, quantite);
        this.format = format;
        this.taille = taille;
        this.duree = duree;
        this.chemin = chemin;
    }

    public String getChemin() {
        return chemin;
    }

    @JsonIgnore
    public File getFichier(){
        return new File(chemin);
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getSupport() {
        return "Fichier Numérique";
    }

    @Override
    public String toString() {
        return this.getSupport() + " " + this.getFormat() + " " + this.getTaille() + " Mo " + this.getDuree() + " min " + super.toString() + " chemin :  " + this.getChemin();
        /**return "Album{" +
         "nom='" + nom + '\'' +
         ", auteur=" + auteur +
         ", annee=" + annee +
         ", quantite=" + quantite +
         ", chemin=" + chemin
         '}';*/
    }
}
