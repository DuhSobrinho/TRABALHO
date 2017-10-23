
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodolfo
 */


public class ListaAnimal {
     public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File arquivo = new File("teste.txt");
        File folder = new File("./Trabalho/" + "Animais/");
        File[] listOfFolders = folder.listFiles();
        
        for (int i = 0; i < listOfFolders.length; i++) {
            File auxFolder = new File("./Trabalho/Animais/"+listOfFolders[i].getName());
            File[] auxFile = auxFolder.listFiles();
            FileInputStream fis = new FileInputStream(auxFile[0]);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String linha;
            int counter = 0;
            String aux = "";
            while ((linha = br.readLine()) != null) {
                
               switch (counter) {
                   case 0:
                       aux+=(linha + ": ");
                       break;
                   case 1:
                       aux+=(linha + " - ");
                       break;
                   case 3:
                        aux+=linha;
                       break;
               }
               counter++;
            }
            System.out.println(aux);
            br.close();
           
        }
    }
}
