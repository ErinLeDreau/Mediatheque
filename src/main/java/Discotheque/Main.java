package Discotheque;

import Discotheque.Application.Controller;
import Discotheque.Exceptions.*;
import Discotheque.Modele.Auth;
import Discotheque.Modele.Discotheque;
import Sauvegarde.StockageJsonDiscotheque;
import at.favre.lib.crypto.bcrypt.BCrypt;

import java.io.IOException;
import java.time.DateTimeException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Controller c = new Controller();
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

                switch (choix) {
                    case 1:
                        c.ajouterAlbum();
                        break;
                    case 2:
                        c.listerAlbums();
                        break;
                    case 3:
                        c.rechercherAlbum();
                        break;
                    case 4:
                        c.supprimerAlbumParNom();
                        break;
                    case 5:
                        c.ecouterFichierNumerique();
                        break;
                    case 6:
                        c.arretLecture();
                        break;
                    case 7:
                        c.convertirFichier();
                        break;
                    case 8:
                        new StockageJsonDiscotheque("src/main/resources/disco.json").sauvegarder(Discotheque.getDiscotheque());
                        break;
                    case 9:
                        Discotheque.setDiscotheque(new StockageJsonDiscotheque("src/main/resources/disco.json").charger());
                        System.out.println("Discothèque restaurée avec succès !");
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        c.arretLecture();
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }

                System.out.println();
            } catch (DiscothequeVideException | SaisieInvalideException | DoublonException | AlbumIntrouvableException | DateFormatException |
                     DateTimeException e) {
                System.out.println("Erreur: "+ e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
            } catch (InputMismatchException e){
                System.out.println("Erreur: " + e.getClass().getSimpleName());
                Controller.scan.nextLine();
            } catch (FichierAudioException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } while (choix != 0);

    }


}
