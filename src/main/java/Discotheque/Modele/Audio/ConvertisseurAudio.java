package Discotheque.Modele.Audio;

import Discotheque.Exceptions.FichierAudioException;
import Discotheque.Modele.Ffmpeg;
import Discotheque.Modele.FichierNumerique;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertisseurAudio {

    public static void mp3VersAac(FichierNumerique album) throws FichierAudioException, IOException, InterruptedException {
        File fichierEntrant = new File(album.getChemin());
        String format = "aac";
        String chemin = "src/main/resources/musique/" + album.getNom().replaceAll("\\s","") + "." + format;
        FichierNumerique fichier = new FichierNumerique(album.getNom(), album.getAuteur(), album.getAnnee(), album.getQuantite(), "aac", album.getTaille(), album.getDuree(),chemin);
        File fichierSortant = new File(fichier.getChemin());
        List<String> options = new ArrayList<>();
        options.add("-vn");
        options.add("-c:a");
        options.add("aac");
        options.add("-b:a");
        options.add("192k");
        System.out.println("Conversion en cours...");
        Ffmpeg.convertir(fichierEntrant, fichierSortant, options);
        System.out.println("Conversion réussie, nouveau fichier : " + fichierSortant.getAbsolutePath() );
    }

}
