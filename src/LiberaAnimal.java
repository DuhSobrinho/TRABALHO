
import java.io.File;
import java.io.IOException;

public class LiberaAnimal {

    public static void main(String[] args) {

        executaLiberarAnimal();

    }

    static void executaLiberarAnimal() {
        boolean confirmador;
        try {
            String nomeRemover = Dialogo.lerTexto("Liberação do Animal", "Qual o nome do animal que deseja liberar: ");
            File pastaAnimal = new File("Animais", nomeRemover);
            if (pastaAnimal.exists()) {
                pastaAnimal.delete();
                Dialogo.mostraMensagem("Arquivo Deletado", "O animal foi liberado!");
            } else {
                Dialogo.mostraErro("Ops!", "Animal inexistente!");
                confirmador = Dialogo.obterConfirmacao("Tentar Novamente", "Deseja colocar outro animal?");
                
                if (confirmador == true) {
                    executaLiberarAnimal();
                } else {
                    Menu.executaMenu();
                }
            }
        } catch (Exception ex) {
            Dialogo.mostraErro("Error", ex.getMessage());
        }
        Menu.executaMenu();

    }
}
