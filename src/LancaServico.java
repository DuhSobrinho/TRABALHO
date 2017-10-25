

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
                File arqServico = GeraArquivoServico(nomepet);
                if (arqServico.exists()) {
                    mostraOpcao(arqServico);
                    pedeServico(arqServico);
                }

            } catch (Exception ex) {
                Dialogo.mostraErro("Error", ex.getMessage());
                Menu.executaMenu();

            }

        } while (quantidadeServicos > 20);
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

        } while (nomePet.length() == 0);

        return nomePet;
    }

    static File GeraArquivoServico(String nomepet) throws Exception {

        File arqValida = new File("Animais", nomepet);
        File arqServico = new File("Animais//" + nomepet, "servico.txt");
        if (arqValida.exists()) {
            arqServico.createNewFile();

        } else {
            Dialogo.mostraErro("Pasta Não Encontrada", "pasta: " + nomepet + "Não foi cadastrada,\nPor favor realizar cadastro!");
            return null;
        }

        return arqServico;

    }

    static String pedeServico(File arqServico) throws FileNotFoundException {
        String servico = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o serviço prestado: ");

        String valorServico = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o valor do serviço: ");

        String servicoPrestado = servico + " - " + valorServico;
        FileOutputStream fos = new FileOutputStream(arqServico);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        PrintWriter pw = new PrintWriter(osw);
        pw.println(servicoPrestado + "\n");
        pw.close();
        return servicoPrestado;

    }

    

    static int mostraOpcao(File arqServico) throws FileNotFoundException {
        int opcao = 0;
        opcao = Dialogo.lerInteiro("Ordem Serviço",
                "1 - Adicionar serviço\n"
                + "2 - Fechar ordem de serviços");

        switch (opcao) {
            case 1:
                pedeServico(arqServico);
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
