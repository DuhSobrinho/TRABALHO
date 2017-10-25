
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

    static String executa(File arqServico) throws FileNotFoundException, IOException {
        String servico = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o serviço prestado: ");
        String valorServico = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o valor do serviço: ");
        String ServicoCompleto = new String(servico + "," + valorServico);
        
        FileInputStream fis = new FileInputStream(arqServico);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        
        String linha;
        String auxInfo = "";
        String auxOut = "";
        int counter = 0;
        while ((linha = br.readLine()) != null) {
            
            if(counter != 0) {
                auxInfo += (linha + "\r\n");
            }
            counter++;
        }
        auxInfo += ServicoCompleto;
        auxOut = Integer.toString(counter) + "\r\n" + auxInfo;
        
        
        FileOutputStream fos = new FileOutputStream(arqServico);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        PrintWriter pw = new PrintWriter(osw);

        //So falta alterar os testes p/ os servicos lancados!!!
        pw.println(auxOut);
        pw.close();

        return null;
    }

    static int mostraOpcao(File arqServico) throws FileNotFoundException, IOException {
        int opcao = 0;
        opcao = Dialogo.lerInteiro("Ordem Serviço",
                "1 - Adicionar serviço\n"
                + "2 - Fechar ordem de serviços");

        switch (opcao) {
            case 1:
                executa(arqServico);
                mostraOpcao(arqServico);
                break;
            case 2:
                Menu.executaMenu();
                break;
            default:
                throw new AssertionError();
        }
        return opcao;
    }

}
