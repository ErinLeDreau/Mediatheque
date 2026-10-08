package Videotheque.Modeles.Abstracts;

import Videotheque.Modeles.Interfaces.Lisible;
import Videotheque.Modeles.Dvd;
import Videotheque.Modeles.VideoAvi;
import Videotheque.Modeles.VideoMp4;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dvd.class, name = "Dvd"),
        @JsonSubTypes.Type(value = VideoMp4.class, name = "VideoMp4"),
        @JsonSubTypes.Type(value = VideoAvi.class, name = "VideoAvi")
})
public abstract class Video implements Lisible {

    protected String titre;
    protected String realisateur;
    protected LocalDate dateSortie;
    protected int duree;

    public Video(String titre, String realisateur, LocalDate dateSortie, int duree) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.dateSortie = dateSortie;
        this.duree = duree;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Video{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", dateSortie=" + dateSortie +
                ", duree=" + duree +
                '}';
    }

    @JsonIgnore
    public abstract String getSupport();
}
