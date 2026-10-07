package Discotheque;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;

public class Testmp3 {
    static void main() {
        try (InputStream flux = new BufferedInputStream(
                new FileInputStream("src/main/resources/musique/monfichier.m"))) {
            Player player = new Player(flux);
            player.play();
            System.out.println("Après play()");
        } catch (JavaLayerException | FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
