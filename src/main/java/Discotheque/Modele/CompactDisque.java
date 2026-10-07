package Discotheque.Modele;

import Discotheque.Modele.Abstract.Album;

import java.time.LocalDate;

public class CompactDisque extends Album {

    private String numero;
    private String type;

    public CompactDisque(String nom, Auteur auteur, LocalDate annee, int quantite, String numero, String type) {
        super(nom, auteur, annee, quantite);
        this.numero = numero;
        this.type = type;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSupport() {
        return "CD";
    }

    @Override
    public String toString() {
        return this.getSupport() + " " + this.getNumero() + " " + this.getType() + " " + super.toString();
        /**return "Album{" +
         "nom='" + nom + '\'' +
         ", auteur=" + auteur +
         ", annee=" + annee +
         ", quantite=" + quantite +
         '}';*/
    }
}
