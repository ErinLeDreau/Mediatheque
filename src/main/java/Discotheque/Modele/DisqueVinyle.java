package Discotheque.Modele;

import Discotheque.Modele.Abstract.Album;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class DisqueVinyle extends Album {

    private String numero;
    private int taille;

    @JsonCreator
    public DisqueVinyle(@JsonProperty("nom") String nom, @JsonProperty("auteur") Auteur auteur,
                        @JsonProperty("annee") LocalDate annee, @JsonProperty("quantite") int quantite,
                        @JsonProperty("numero") String numero, @JsonProperty("taille") int taille) {
        super(nom, auteur, annee, quantite);
        this.numero = numero;
        this.taille = taille;
    }

    public DisqueVinyle(String nom, Auteur auteur, LocalDate annee, int quantite) {
        super(nom, auteur, annee, quantite);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    @Override
    public String toString() {
        return  this.getSupport() + " " + this.getNumero() + " " + this.getTaille() + " cm " + super.toString() ;
        /**return "Album{" +
                "nom='" + nom + '\'' +
                ", auteur=" + auteur +
                ", annee=" + annee +
                ", quantite=" + quantite +
                '}';*/
    }

    public String getSupport() {
        return "Disque vinyle";
    }
}
