
public class LancaServico {
    public static void main(String[] args) {
        int quantidadeServicos = 0;
        do {
            try {
                
            } catch (Exception ex) {
                Dialogo.mostraErro("Error", ex.getMessage());
            }
            
        } while ();
    }
    
    static String pedeNome(){
        String nomePet = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o nome do pet: ");
        return nomePet;
    }  
    
    static String pedeServico(){
        String serviço = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o serviço prestado: ");
        return serviço;
    }
    static int pedeValor(int quantidadeServicos){
        String valorServico = Dialogo.lerTextoObrigatorio("Lança Serviço", "Informe o valor do serviço: ");
         quantidadeServicos ++; 
        return Integer.parseInt(valorServico);
        return quantidadeServicos;
    }
    
}
