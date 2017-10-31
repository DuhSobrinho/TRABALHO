import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListaAnimal {
    public static void main(String[] args) throws IOException{
       executaListaAnimal();     
    }
    static void executaListaAnimal()  throws FileNotFoundException, IOException {
       File folder = new File("./" + "Animais/");
       File[] listOfFolders = folder.listFiles();
       String gambiarra = "";
       
       for (int i = 0; i < listOfFolders.length; i++) {
           File auxFolder = new File("./Animais/"+listOfFolders[i].getName());
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
           gambiarra += aux + "\n";
           br.close();
       }
      Dialogo.mostraMensagem("Animais cadastrados", gambiarra);
    }
    }
