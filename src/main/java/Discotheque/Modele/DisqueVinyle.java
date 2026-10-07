package Discotheque.Modele;

import Discotheque.Modele.Abstract.Album;

import java.time.LocalDate;

public class DisqueVinyle extends Album {

    private String numero;
    private int taille;

    public DisqueVinyle(String nom, Auteur auteur, LocalDate annee, int quantite, String numero, int taille) {
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
