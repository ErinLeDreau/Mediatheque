package Videotheque.Modeles;

import Videotheque.Modeles.Abstracts.FichierVideo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class VideoAvi extends FichierVideo {

    @JsonCreator
    public VideoAvi(@JsonProperty("titre") String titre, @JsonProperty("realisateur") String realisateur,
                    @JsonProperty("dateSortie") LocalDate dateSortie, @JsonProperty("duree") int duree,
                    @JsonProperty("chemin") String chemin) {
        super(titre, realisateur, dateSortie, duree, chemin);
    }

    public VideoAvi(VideoMp4 videoMp4){
        String nouveauChemin = videoMp4.getChemin().replaceAll("(?i)\\.mp4$", ".avi");
        super(videoMp4.getTitre(), videoMp4.getRealisateur(), videoMp4.getDateSortie(), videoMp4.getDuree(), nouveauChemin);
    }

    @Override
    public String getSupport() {
        return "AVI";
    }

    @Override
    public List<String> optionsEncodage() {
        return List.of("-q:v", "5", "-c:a", "libmp3lame");
    }

    @Override
    public String toString() {
        return super.toString() + "support='" + this.getSupport();
    }
}
