import java.util.InputMismatchException;

public class App {

    public static void main(String[] args) {

        Controller c = new Controller();

        int choix = -1;

        do {
            try {
                c.afficherMenu();
                System.out.print("Choix:");
                choix = Controller.scan.nextInt();
                Controller.scan.nextLine();

                switch (choix) {
                    case 1:
                        c.lancerDiscotheque();
                        break;
                    case 2:
                        c.lancerVideotheque();
                        break;
                    case 0:
                        System.out.println("Au revoir !");
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

        Controller.scan.close();

    }
}
