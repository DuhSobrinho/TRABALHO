
import java.io.File;
import javax.swing.JOptionPane;

public class Dialogo {

    static void mostraMensagem(String titulo, String texto) {
        JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    static void mostraAviso(String titulo, String texto) {
        JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.WARNING_MESSAGE);
    }

    static void mostraErro(String titulo, String texto) {
        JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.ERROR_MESSAGE);
    }

    static String lerTexto(String titulo, String texto) {
        return JOptionPane.showInputDialog(null, texto, titulo, JOptionPane.QUESTION_MESSAGE);
    }

    static String lerTextoObrigatorio(String titulo, String texto) {
        String entrada = lerTexto(titulo, texto);

        if (entrada == null || entrada.isEmpty()) { 
            throw new RuntimeException("Valor obrigatório");
        }

        return entrada;
    }

    static int lerInteiro(String titulo, String texto) {
        String entrada = lerTexto(titulo, texto);

        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Valor inválido", ex);
        }
    }

    static int lerNatural(String titulo, String texto) {
        int entrada = lerInteiro(titulo, texto);

        if (entrada < 0) {
            throw new RuntimeException("Valor não pode ser negativo");
        }

        return entrada;
    }

    static double lerReal(String titulo, String texto) {
        String entrada = lerTexto(titulo, texto);

        try {
            return Double.parseDouble(entrada);
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Valor inválido", ex);
        }
    }

    static double lerPositivo(String titulo, String texto) {
        double entrada = lerReal(titulo, texto);

        if (entrada < 0.0) {
            throw new RuntimeException("Valor não pode ser negativo");
        }

        return entrada;
    }

    static boolean obterConfirmacao(String titulo, String texto) {
        int entrada = JOptionPane.showConfirmDialog(null, texto, titulo,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        return (entrada == 0);
    }

    static File validaAnimal(String nomePet) {
        int i=0;
        return null;
    }

}
