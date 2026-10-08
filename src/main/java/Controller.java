import java.util.Scanner;

public class Controller {

    public static Scanner scan = new Scanner(System.in);

    public void afficherMenu() {
        System.out.println("===== MEDIATHÈQUE =====");
        System.out.println("1. Accéder à la discothèque");
        System.out.println("2. Accéder à la vidéothèque");
        System.out.println("0. Quitter");
        System.out.println("=======================");
    }

    public void lancerDiscotheque() {
        Discotheque.Application.Controller.scan = scan;
        Discotheque.Main.main(new String[]{});
    }

    public void lancerVideotheque() {
        Videotheque.Applications.Controller.scan = scan;
        Videotheque.Applications.Main.main(new String[]{});
    }


}
