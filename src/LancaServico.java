
public class LancaServico {

    public static void main(String[] args) {
        int quantidadeServicos = 0;
        int opcao = 0;
        do {
            try {
                

            } catch (Exception ex) {
                Dialogo.mostraErro("Error", ex.getMessage());
            }

        } while (quantidadeServicos == 0);
    }

    static String pedeNome() {
        String nomePet = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o nome do pet: ");
        return nomePet;
    }

    static String pedeServico() {
        String serviço = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o serviço prestado: ");
        return serviço;
    }

    static int pedeValor(int quantidadeServicos) {
        String valorServico = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o valor do serviço: ");
        quantidadeServicos++;
        return Integer.parseInt(valorServico);
    }

    static void executa(int quantidadeServiços) {
        pedeServico();
        pedeValor(quantidadeServiços);
    }
    static int mostraOpcao(int opcao, int quantidadeServiços){
        opcao = Dialogo.lerInteiro("Ordem Serviço", 
                "1 - Adicionar serviço" 
                + "2 - Ferchar ordem de serviços");
        
        switch (opcao) {
                    case 0:
                        pedeNome();
                        executa(quantidadeServiços);
                        break;
                    case 1:
                        executa(quantidadeServiços); //inserir novo serviço
                        break;
                    case 2:
                        //
                    default:
                        throw new AssertionError();
                }
        return opcao;
    }
}
