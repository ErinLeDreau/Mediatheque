import Discotheque.Modele.Audio.SauvAlbum;
import Sauvegarde.SauvAlbumJson;

import java.nio.file.Path;
import java.util.Scanner;

public class Controller {

    public static Scanner scan = new Scanner(System.in);

    private final SauvAlbum sauvAlbum = new SauvAlbumJson(Path.of("src/main/resources/disco.json"));

    public void afficherMenu() {
        System.out.println("===== MEDIATHÈQUE =====");
        System.out.println("1. Accéder à la discothèque");
        System.out.println("2. Accéder à la vidéothèque");
        System.out.println("0. Quitter");
        System.out.println("=======================");
    }

    public void lancerDiscotheque() {
        Discotheque.Main.main(sauvAlbum);
    }

    public void lancerVideotheque() {
        Videotheque.Applications.Main.main(new String[]{});
    }


}
