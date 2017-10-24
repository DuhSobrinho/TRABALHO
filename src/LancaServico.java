
public class LancaServico {

    public static void main(String[] args) {
        int quantidadeServicos = 0;
        int opcao = 0;
        do {
            try {
                mostraOpcao(opcao);

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
