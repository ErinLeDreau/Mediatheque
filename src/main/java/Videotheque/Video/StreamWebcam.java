package Videotheque.Video;

import Videotheque.Outils.Ffmpeg;

public class StreamWebcam implements Runnable {
    private String url = "rtmp://a.rtmp.youtube.com/live2";
    private String key = "votre_cle_de_streaming"; // Remplacez par votre clé de streaming

    private static volatile StreamWebcam streamWebcamActif;
    private volatile boolean arretDemande;

    private volatile Process processus;
    private Thread thread;

    public StreamWebcam(String url, String key) {
        this.url = url;
        this.key = key;
    }

    @Override
    public void run() {
        try{
            if (arretDemande) {
                return;
            }

            System.out.println("Streaming de la webcam à l'URL : " + url);
            processus = Ffmpeg.webcam(this.url,this.key);
            int codeRetour = processus.waitFor();
            if (codeRetour != 0) {
                System.out.println("La lecture a échoué (code " + codeRetour + ").");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Le stream a été interrompue.");
        } catch (java.io.IOException e) {
            if (!arretDemande) {
                System.out.println("Erreur lors du stream de la webcam : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du streaming de la webcam : " + e.getMessage());
        } finally {
            processus = null;

            if (streamWebcamActif == this) {
                streamWebcamActif = null;
            }

        }

    }

    public void lancerWebcam(){
        thread = new Thread(this, "webcam streaming");
        thread.setDaemon(true);
        thread.start();
        if(streamWebcamActif != null) {
            //On force l'interruption de la lecture en cours si il y en a déjà une
            arreterStreamActif();
        }
        streamWebcamActif = this;
    }

    public void arreter(){
        arretDemande = true;
        if (processus != null && processus.isAlive()) {
            processus.destroy();
        }
        if (thread != null) {
            thread.interrupt();
        }
    }

    public static boolean arreterStreamActif() {
        StreamWebcam streamWebcam = streamWebcamActif;

        if (streamWebcam == null) {
            return false;
        }

        streamWebcam.arreter();
        return true;
    }
}
