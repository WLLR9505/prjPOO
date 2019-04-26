
import fatec.poo.model.Produto;


public class Aplic {
    public static void main(String[] args) {
        
        Produto prod1 = new Produto("1", "Mouse Gamer");
        prod1.setEstoqueMinimo(10);
        prod1.setPreco(150.00);
        prod1.setUnidadeMedida("un");
        prod1.setQtdeEstoque(95);
        
        Produto prod2 = new Produto("2", "Keyboard Iluminado");
        prod2.setEstoqueMinimo(10);
        prod2.setPreco(350.00);
        prod2.setUnidadeMedida("un");
        prod2.setQtdeEstoque(95);
        
    }
    
}
