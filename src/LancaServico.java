
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class LancaServico {

    public static void main(String[] args) {
        executaLancaServico();
    }

    static void executaLancaServico() {
        int quantidadeServicos = 0;
        int opcao = 0;
        do {
            try {

                String nomepet = pedeNome();
                File servicoCriado = GeraArquivoServico(nomepet);

                if (servicoCriado.exists()) {
                    mostraOpcao(opcao);
                } else {
                    break;
                }
            } catch (Exception ex) {
                Dialogo.mostraErro("Error", ex.getMessage());
                opcao += -1;
            }

        } while (opcao == 0);
        System.exit(0);

    }

    static String pedeNome() {
        String nomePet;
        do {
            nomePet = null;
            try {
                nomePet = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o nome do pet: ");

            } catch (Exception ex) {
                Dialogo.mostraErro("Error", ex.getMessage());
                Menu.executaMenu();
            }

        } while (nomePet.length() != 0);

        return nomePet;
    }

    static File GeraArquivoServico(String nomepet) throws Exception {

        File arqValida = new File("Animais", nomepet);
        File arqServico = new File("Animais//" + nomepet, "servico.txt");
        if (arqValida.exists()) {
            arqServico.createNewFile();
            FileOutputStream fos = new FileOutputStream(arqServico);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            PrintWriter pw = new PrintWriter(osw);

            //So falta alterar os testes p/ os servicos lancados!!!
            pw.println("teste");
            pw.println("teste");
            pw.println("teste");
            pw.println("teste");
            pw.println("teste");
            pw.close();

        } else {
            Dialogo.mostraErro("Pasta Não Encontrada", "pasta: " + nomepet + "Não foi cadastrada,\nPor favor realizar cadastro!");
            return null;
        }

        return arqServico;

    }

    static String pedeServico() {
        String serviço = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o serviço prestado: ");
        return serviço;
    }

    static int pedeValor() {
        String valorServico = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o valor do serviço: ");
        return Integer.parseInt(valorServico);
    }

    static void executa() {
        pedeServico();
        pedeValor();
    }

    static int mostraOpcao(int opcao) {
        opcao = Dialogo.lerInteiro("Ordem Serviço",
                "1 - Adicionar serviço\n"
                + "2 - Fechar ordem de serviços");

        switch (opcao) {
            case 1:
                executa();
                break;
            case 2:
                Menu.executaMenu();
                break;
            default:
                throw new AssertionError();
        }
        return opcao;
    }

    static String executaListaAnimal() throws FileNotFoundException, IOException {
        File folder = new File("./" + "Animais/");
        File[] listOfFolders = folder.listFiles();
        String gambiarra = "";

        for (int i = 0; i < listOfFolders.length; i++) {
            File auxFolder = new File("./Animais/" + listOfFolders[i].getName());
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
                        aux += (linha + ": ");
                        break;
                    case 1:
                        aux += (linha + " - ");
                        break;
                    case 3:
                        aux += linha;
                        break;
                }
                counter++;
            }
            System.out.println(aux);
            gambiarra += aux + "\n";
            br.close();
        }
        return gambiarra;
    }
}
