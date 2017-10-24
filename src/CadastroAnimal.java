
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CadastroAnimal {

    public static void main(String[] args) throws IOException {
        excutaCadastroAnimal();

    }

    static File GerarLocalPasta() {

        File folder = null;
        boolean validaPasta = false;
        File PastaOrigem = new File("Trabalho");
        try {

            folder = new File(PastaOrigem, "Animais");
            validaPasta = folder.mkdir();
            System.out.println("Pasta Criada? " + validaPasta);

        } catch (Exception ex) {
            Dialogo.mostraErro("Error", ex.getMessage());

        }

        return folder;
    }

    static void excutaCadastroAnimal() throws IOException, NullPointerException {
        boolean confirmacao = false;
        do {
            try {
                cadastroAnimal();
            } catch (NullPointerException ex) {
                confirmacao = Dialogo.obterConfirmacao("Aviso", "Você deseja realmente cancelar?");
                if (confirmacao == true) {
                    Menu.executaMenu();
                } else {
                    try {
                        cadastroAnimal();

                    } catch (NullPointerException e) {
                        Dialogo.mostraErro("ErrorNp", e.getMessage());
                        Menu.executaMenu();
                    } catch (IOException e) {
                        Dialogo.mostraErro("ErrprIO", e.getMessage());
                        Menu.executaMenu();
                    } finally {
                        Menu.executaMenu();
                    }
                }
            }
        } while (confirmacao != true);
    }

    static void cadastroAnimal() throws IOException {
        File folder = GerarLocalPasta();
        File fanimal = GerarPastaAnimal(folder);
        GerarTexto(fanimal);
    }

    static File GerarPastaAnimal(File folder) {
        boolean validaPasta = false;
        File fanimal = null;

        int a = -1;
        do {
            try {
                String NomeAnimal = Dialogo.lerTextoObrigatorio("Cadastro Animal", "Nome do animal:");
                fanimal = new File(folder, NomeAnimal);
                if (NomeAnimal.isEmpty()){
                    return null;
                }
                if (!fanimal.exists()) {

                    if (NomeAnimal.length() > 0) {

                        validaPasta = fanimal.mkdir();

                        a++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Por Favor colocar o nome do Animal!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pasta já existe");
                    a++;
                }

                System.out.println("Pasta Criada? " + validaPasta);

            } catch (NullPointerException ex) {
                ex.printStackTrace();
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
