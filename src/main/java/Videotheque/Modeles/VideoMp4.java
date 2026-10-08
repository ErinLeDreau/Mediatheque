package Videotheque.Modeles;

import Videotheque.Modeles.Abstracts.FichierVideo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VideoMp4 extends FichierVideo{

    @JsonCreator
    public VideoMp4(@JsonProperty("titre") String titre, @JsonProperty("realisateur") String realisateur,
                    @JsonProperty("dateSortie") java.time.LocalDate dateSortie, @JsonProperty("duree") int duree,
                    @JsonProperty("chemin") String chemin) {
        super(titre, realisateur, dateSortie, duree, chemin);
    }

    public VideoMp4(VideoAvi videoAvi){
        String nouveauChemin = videoAvi.getChemin().replaceAll("(?i)\\.avi$", ".mp4");
        super(videoAvi.getTitre(), videoAvi.getRealisateur(), videoAvi.getDateSortie(), videoAvi.getDuree(), nouveauChemin);
    }

    @Override
    public String getSupport() {
        return "MP4";
    }

    @Override
    public List<String> optionsEncodage() {
        return List.of("-crf", "23", "-c:a", "aac");
    }

    @Override
    public String toString() {
        return super.toString() + "support='" + this.getSupport();
    }
}
