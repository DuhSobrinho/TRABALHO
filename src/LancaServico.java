
<<<<<<< HEAD
import java.io.File;
=======
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
>>>>>>> master
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
        do {
            try {

                String nomepet = pedeNome();
<<<<<<< HEAD
                File arqServico = GeraArquivoServico(nomepet);
                if (arqServico.exists()) {
                    mostraOpcao(arqServico);

=======
                File servicoCriado = GeraArquivoServico(nomepet);

                if (servicoCriado.exists()) {
                    mostraOpcao(opcao);
                } else {
                    break;
>>>>>>> master
                }

            } catch (Exception ex) {
                Dialogo.mostraErro("Error", ex.getMessage());
<<<<<<< HEAD
                Menu.executaMenu();

            }

        } while (quantidadeServicos > 20);
=======
                opcao += -1;
            }

        } while (opcao == 0);
        System.exit(0);

>>>>>>> master
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

<<<<<<< HEAD
        } while (nomePet.length() == 0);
=======
        } while (nomePet.length() != 0);
>>>>>>> master

        return nomePet;
    }

    static File GeraArquivoServico(String nomepet) throws Exception {

        File arqValida = new File("Animais", nomepet);
        File arqServico = new File("Animais//" + nomepet, "servico.txt");
        if (arqValida.exists()) {
            arqServico.createNewFile();
<<<<<<< HEAD
=======
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
>>>>>>> master

        } else {
            Dialogo.mostraErro("Pasta Não Encontrada", "pasta: " + nomepet + "Não foi cadastrada,\nPor favor realizar cadastro!");
            return null;
        }

        return arqServico;

    }

    static String pedeServico(int contador, File arqServico) throws FileNotFoundException {
        String servico = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o serviço prestado: ");

<<<<<<< HEAD
        String valorServico = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o valor do serviço: ");

        String servicoPrestado = servico + " - " + valorServico;
        FileOutputStream fos = new FileOutputStream(arqServico);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        PrintWriter pw = new PrintWriter(osw);
        pw.println(servicoPrestado + "\n");
        pw.close();
        
        System.out.println(contador);
        return servico;
        
    }

    static int mostraOpcao(File arqServico) throws FileNotFoundException {
        int opcao = 0;
        int contador = 0;
=======
    static int pedeValor() {
        String valorServico = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o valor do serviço: ");
        return Integer.parseInt(valorServico);
    }

    static void executa() {
        pedeServico();
        pedeValor();
    }

    static int mostraOpcao(int opcao) {
>>>>>>> master
        opcao = Dialogo.lerInteiro("Ordem Serviço",
                "1 - Adicionar serviço\n"
                + "2 - Fechar ordem de serviços");

        switch (opcao) {
            case 1:
<<<<<<< HEAD
                contador++;
                pedeServico(contador,arqServico);
                mostraOpcao(arqServico);
=======
                executa();
>>>>>>> master
                break;
            case 2:
                Menu.executaMenu();
                break;
            default:
                throw new AssertionError();
        }

        return contador;
    }

<<<<<<< HEAD
=======
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
>>>>>>> master
}
