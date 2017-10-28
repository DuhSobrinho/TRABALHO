
import java.io.IOException;


public class Menu {

    public static void main(String[] args) {
        executaMenu();
    }

    static int mostraMenu() {
        int opcao = Dialogo.lerInteiro("Menu de Opcões", "1 ​ ​-​ ​Cadastrar​ ​Animal"
                + "\n2 -​ ​Listar​ ​Animais"
                + "\n3 -​ ​Lançar​ ​Serviço"
                + "\n4 -​ ​Exibir​ ​Detalhes"
                + "\n5 -​ ​Liberar​ ​Animal\n"
                + "\n0 -​ ​Sair");

        return opcao;

    }
    
    static void executaMenu(){
        int opcao = -1;
        do {
            try {
                opcao = mostraMenu();
                validaOpcao(opcao);
            } catch (IOException ex) {
                Dialogo.mostraErro("Error", ex.getMessage());
            }

        } while (opcao != 0);
    }

    static int validaOpcao(int opcao) throws IOException {

        do {
            switch (opcao) {
                case 1:
                    CadastroAnimal.executarCadastroAnimal();
                    break;

                case 2:
                    ListaAnimal.class;
                    break;

                case 3:
                    LancaServico.class;
                    break;

                case 4:
                    Detalhes.class;
                    break;

                case 5:
                    LiberaAnimal.class;
                    break;
                case 0:
                    Dialogo.mostraAviso("Tchau!", "Até mais!");
                    break;
                default:
                    Dialogo.mostraErro("Erro de execução", "Opção invalida");
                    break;

            }
        } while (opcao != 0);
        return opcao;
    }
}
