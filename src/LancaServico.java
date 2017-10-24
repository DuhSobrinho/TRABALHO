
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class LancaServico {

    public static void main(String[] args) {
        int quantidadeServicos = 0;
        int opcao = 0;
        do {
            try {
                mostraOpcao(opcao);

                String nomepet = pedeNome();
                GeraArquivoServico(nomepet);
                executa(quantidadeServicos);
                 {
                    
                }
            } catch (Exception ex) {
                Dialogo.mostraErro("Error", ex.getMessage());
            }

        } while (quantidadeServicos == 0);
    }

    static String pedeNome() {
        String nomePet = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o nome do pet: ");
        
        do {
            try {
                String petList = ListaAnimal.executaListaAnimal();
                boolean found = petList.contains(nomePet);
                
                if (found != true){
                    Dialogo.mostraAviso("Aviso", "Nome do pet é inválido!");
                    break;
                }else{
                    return nomePet;
                }
            } catch (Exception ex) {
                Dialogo.mostraErro("Error", ex.getMessage());
            }
            
        } while (nomePet.isEmpty());
        return nomePet;
    }

    static File GeraArquivoServico(String nomepet) throws Exception {
        
        File arqValida = new File("Animais", nomepet);
        File arqServico = new File("Animais//"+ nomepet, "servico.txt");
        if(arqValida.exists()){
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
            
        }else{
            Dialogo.mostraErro("Pasta Não Encontrada", "pasta: " + nomepet + "Não foi cadastrada,\nPor favor realizar cadastro!");
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
            case 0:
                pedeNome();
                executa();
                break;
            case 1:
                executa(); //inserir novo serviço
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
