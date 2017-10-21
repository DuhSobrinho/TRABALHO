
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CadastroAnimal {

    public static void main(String[] args) throws IOException {
        nemSeiMais();

    }

    static File GerarLocalPasta() {

        File folder = null;
        boolean bool = false;
        File PastaOrigem = new File("C:\\Users\\Eduardo\\Desktop\\Trabalho");
        try {

            folder = new File(PastaOrigem, "Animais");
            bool = folder.mkdir();
            System.out.println("Pasta Criada? " + bool);

        } catch (Exception ex) {
            Dialogo.mostraErro("Error", ex.getMessage());

        }

        return folder;
    }

    static void nemSeiMais() {
        boolean confirmacao = false;
        do {
            try {
                executarCadastroAnimal();
            } catch (Exception ex) {
                confirmacao = Dialogo.obterConfirmacao("Aviso", "Você deseja realmente cancelar?");
                if (confirmacao == true) {
                    Menu.executaMenu();
                } else {
                    try {
                        executarCadastroAnimal();

                    } catch (IOException e) {
                        Dialogo.mostraErro("Error", e.getMessage());

                    }
                }
            }
        } while (confirmacao != true);
    }

    static void executarCadastroAnimal() throws IOException {
        File folder = GerarLocalPasta();
        File fanimal = GerarPastaAnimal(folder);
        GerarTexto(fanimal);
    }

    static File GerarPastaAnimal(File folder) {
        boolean bool = false;
        File fanimal = null;

        int a = -1;
        do {
            try {
                String NomeAnimal = JOptionPane.showInputDialog("Nome do Animal");
                fanimal = new File(folder, NomeAnimal);

                if (!fanimal.exists()) {

                    if (NomeAnimal.length() > 0) {

                        bool = fanimal.mkdir();

                        a++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Por Favor colocar o nome do Animal!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pasta existente");
                    a++;
                }

                System.out.println("Pasta Criada? " + bool);

            } catch (HeadlessException ex) {
                Dialogo.mostraErro("Error", ex.getMessage());

            }
        } while (a == -1);
        return fanimal;

    }

    static File GerarTexto(File fanimal) throws FileNotFoundException {

        File arquivo = new File(fanimal, "dados.txt");

        if (!arquivo.exists()) {
            String NomedoAnimal = Dialogo.lerTexto("Entrada", "Insira o nome do animal: ");
            String TipoAnimal = Dialogo.lerTexto("Entrada", "Insira a especie do animal: ");
            String RacaAnimal = Dialogo.lerTexto("Entrada", "Insira a raca do animal: ");
            String Dono = Dialogo.lerTexto("Entrada", "Insira o nome do Dono: ");
            String AnoAnimal = Dialogo.lerTexto("Entrada", "Insira o ano de nascimento do animal: ");
            FileOutputStream fos = new FileOutputStream(arquivo);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            PrintWriter pw = new PrintWriter(osw);
            pw.println(NomedoAnimal);
            pw.println(TipoAnimal);
            pw.println(RacaAnimal);
            pw.println(Dono);
            pw.println(AnoAnimal);
            pw.close();
        }

        return null;

    }

}
