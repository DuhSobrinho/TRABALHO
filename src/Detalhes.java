import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Detalhes {
    public static void main(String[] args) throws Exception{
       iniciaDetalhes();
    }
    static void iniciaDetalhes()throws Exception {
       String nomepet = detalhesServico();
       File arquivoServico = encontraArquivoServico(nomepet);
       File arquivoDados = encontraArquivoDados(nomepet);
       Dialogo.mostraMensagem("Detalhes de Serviço", geraInvoice(arquivoServico, arquivoDados));
    }
    
    static String detalhesServico() {
        String nomepet = LancaServico.pedeNome();
        return nomepet;
    }
    
    static File encontraArquivoServico(String nomepet) throws Exception {
        File arqValida = new File("Animais", nomepet);
        File arqServico = new File("Animais//" + nomepet, "servico.txt");
        if (arqValida.exists()) {
//            System.out.println("arqServico");
            return arqServico;
        } else {
            Dialogo.mostraErro("Pasta Não Encontrada", "pasta: " + nomepet + "Não foi cadastrada,\nPor favor realizar cadastro!");
            return null;
        }
    }
    
    static File encontraArquivoDados(String nomepet) throws Exception {
        File arqValida = new File("Animais", nomepet);
        File arqServico = new File("Animais//" + nomepet, "dados.txt");
        if (arqValida.exists()) {
//            System.out.println("arqdados");
            return arqServico;
        } else {
            Dialogo.mostraErro("Pasta Não Encontrada", "pasta: " + nomepet + "Não foi cadastrada,\nPor favor realizar cadastro!");
            return null;
        }
    }
    
    static String geraInvoice(File arquivoServico, File arquivoDados) throws FileNotFoundException, IOException {
        String linha = "";
        String auxLinha = "";
        int auxValue = 0;
        int counter = 0;
        
        File arquivoDado = arquivoDados;
        FileInputStream fis = new FileInputStream(arquivoDado);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br;
        br = new BufferedReader(isr);
        
        while ((linha = br.readLine()) != null) {
            switch (counter) {
                case 0:
                    auxLinha += ("Nome: " + linha + "\r\n");
                    break;
                case 1:
                    auxLinha += ("Espécie: " + linha + "\r\n");
                    break;
                case 2:
                    auxLinha += ("Raça: " + linha + "\r\n");
                    break;
                case 3:
                    auxLinha += ("Dono: " + linha + "\r\n");
                    break;
                case 4:
                    auxLinha += ("Nascimento: " + linha + "\r\n");
                    break;
                default:
                    break;
            }
              counter++;
           }
        auxLinha += ("\r\n");
        counter = 0;
        File arquivoServicos = arquivoServico;
        FileInputStream fis2 = new FileInputStream(arquivoServicos);
        InputStreamReader isr2 = new InputStreamReader(fis2);
        BufferedReader br2;
        br2 = new BufferedReader(isr2);
        
        while ((linha = br2.readLine()) != null) {
              if(counter != 0){
                  String kept = linha.substring( 0, linha.indexOf(","));
                  String remainder = linha.substring(linha.indexOf(",")+1, linha.length());
                  auxValue += Integer.parseInt(remainder);
//                  System.out.println(auxValue);
                  auxLinha += linha + "\r\n";
              }
              
              counter++;
           }
        auxLinha += ("Total: " + Integer.toString(auxValue) + "\r\n");
        System.out.println(auxLinha);
        return auxLinha;
    }
}
