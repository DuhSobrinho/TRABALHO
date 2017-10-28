
import java.io.File;

public class LiberaAnimal {

    public static void main(String[] args) {

        liberarAnimal();

    }

    static void liberarAnimal() {
        String nomeRemover = Dialogo.lerTexto("Liberação do Animal", "Qual o nome do animal que deseja liberar: ");
        File pastaAnimal = new File("Animais", nomeRemover);
        if (pastaAnimal.exists()) {
            pastaAnimal.delete();
            Dialogo.mostraMensagem("Arquivo Deletado", "O animal foi liberado!");
            return;
        } else {
            Dialogo.mostraErro("Ops!", "Animal inexistente!");
            Dialogo.obterConfirmacao("Tentar Novamente", "Deseja colocar outro animal?");
            if (Dialogo.obterConfirmacao(nomeRemover, nomeRemover) == true) {
                liberarAnimal();
            } else {
              return;
            }
        }
    }

}
