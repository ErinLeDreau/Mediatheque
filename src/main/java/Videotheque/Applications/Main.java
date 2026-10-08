package Videotheque.Applications;

import Videotheque.Modeles.Interfaces.GestionVideotheque;
import Videotheque.Modeles.Videotheque;
import Videotheque.Video.LecteurVideo;
import Sauvegarde.StockageJsonVideotheque;

import java.util.InputMismatchException;

public class Main {

    private static final GestionVideotheque videotheque = new Videotheque();

    public static void main(String[] args) {

        Controller c = new Controller();

        videotheque.initList();
        int choix = -1;
        String pass;

        do {
            pass = c.saisirMdp();
            if(!Auth.authentification(pass)){
                System.out.println("Mot de passe incorrect");
            }
        }while (!Auth.authentification(pass));

        do {
            try {
                c.afficherMenu();
                System.out.print("Choix:");
                choix = Controller.scan.nextInt();
                Controller.scan.nextLine();

                switch (choix) {
                    case 1:
                        c.ajouterVideo(videotheque);
                        break;
                    case 2:
                        c.listerVideos(videotheque);
                        break;
                    case 3:
                        c.rechercherVideo(videotheque);
                        break;
                    case 4:
                        c.supprimerVideo(videotheque);
                        break;
                    case 5:
                        c.lireVideo(videotheque);
                        break;
                    case 6:
                        c.convertirVideo(videotheque);
                        break;
                    case 7:
                        c.arreterVideo();
                        break;
                    case 8:
                        LecteurVideo.voirLecteurActif();
                        break;
                    case 9:
                        c.lancerWebcam();
                        break;
                    case 10:
                        new StockageJsonVideotheque("src/main/resources/video.json").sauvegarder(Videotheque.getVideotheque());
                        break;
                    case 11:
                        Videotheque.getVideotheque().clear();
                        Videotheque.getVideotheque().addAll(new StockageJsonVideotheque("src/main/resources/video.json").charger());
                        System.out.println("Vidéothèque restaurée avec succès !");
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        c.arreterVideo();
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }

                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("La saisie n'est pas valide. Veuillez entrer un nombre.");
                Controller.scan.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (choix != 0);

    }
}
