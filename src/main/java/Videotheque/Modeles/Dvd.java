package Videotheque.Modeles;

import Videotheque.Modeles.Abstracts.Video;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Dvd extends Video {

    private String numero;
    private int zone;

    @JsonCreator
    public Dvd(@JsonProperty("titre") String titre, @JsonProperty("realisateur") String realisateur,
               @JsonProperty("dateSortie") LocalDate dateSortie, @JsonProperty("duree") int duree,
               @JsonProperty("numero") String numero, @JsonProperty("zone") int zone) {
        super(titre, realisateur, dateSortie, duree);
        this.numero = numero;
        this.zone = zone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public String getSupport() {
        return "DVD";
    }
    public void lire() {
        String message = "Prenez le DVD " + this.titre + " " + this.numero + " et insérez-le dans un lecteur zone 2.";
        System.out.println(message);
    }

    @Override
    public String toString() {
        return super.toString() + "support='" + this.getSupport() + '\'' + ", numero='" + this.getNumero() + '\'' + ", zone=" + this.getZone() + '}';
    }
}
