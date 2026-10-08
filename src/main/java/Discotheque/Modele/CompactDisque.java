package Discotheque.Modele;

import Discotheque.Modele.Abstract.Album;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CompactDisque extends Album {

    private String numero;
    private String type;

    @JsonCreator
    public CompactDisque(@JsonProperty("nom") String nom, @JsonProperty("auteur") Auteur auteur,
                         @JsonProperty("annee") LocalDate annee, @JsonProperty("quantite") int quantite,
                         @JsonProperty("numero") String numero, @JsonProperty("type") String type) {
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
