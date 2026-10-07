package Discotheque.Application;

import Discotheque.Exceptions.FichierAudioException;
import Discotheque.Modele.FichierNumerique;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;

public class LecteurMp3 implements Runnable {

    private final FichierNumerique album;
    private volatile Player player; //partagé entre deux threads
    private Thread thread;

    public LecteurMp3(FichierNumerique album) throws FichierAudioException {
        this.album = album;

        File fichier = album.getFichier();
        String format = album.getFormat();

        if (!"mp3".equalsIgnoreCase(format)) {
            throw new FichierAudioException("format invalide");
        }

        if (!fichier.exists()) {
            throw new FichierAudioException("fichier introuvable : " + fichier.getPath());
        }
    }

    public void demarrer(){
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
        this.thread = thread;
    }


    @Override
    public void run() {

        System.out.println("Lecture...");

        try (InputStream flux = new BufferedInputStream(new FileInputStream(album.getFichier()))) {
            player = new Player(flux);
            player.play();
        } catch (IOException | JavaLayerException e) {
            System.out.println("!! Erreur : " + e.getMessage());
        }

        System.out.println("fin de lecture...");

    }


    public void arreter(){
        if(player != null){
            player.close();
        }
        thread.interrupt();
    }

    public boolean estEnCours(){
        boolean verif = false;
        if(thread.isAlive()){
            verif=true;
        }
        return verif;
    }

    public void attendreFin()throws InterruptedException{
        thread.join();
        //????
    }

    public int getPosition(){
        return player.getPosition();
    }


}

