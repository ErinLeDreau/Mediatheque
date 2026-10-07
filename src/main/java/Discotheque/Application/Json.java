package Discotheque.Application;

import Discotheque.Modele.Abstract.Album;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class Json {

public static void remplirJson(ArrayList<Album> liste){
    ObjectMapper mapper = new ObjectMapper();
    mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/disco.json"),liste);

}

public static ArrayList<Album> lireJson(){
    //TODO: Lire le fichier disco.json et le convertir en ArrayList<Album>
    return null;
}


}
