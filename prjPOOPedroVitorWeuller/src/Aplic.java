
import fatec.poo.model.Cliente;
import java.util.ArrayList;
import fatec.poo.model.Produto;

public class Aplic {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Produto prod1 = new Produto("1", "Mouse Gamer");
        Produto prod2 = new Produto("2", "Keyboard Iluminado");

        clientes.add(new Cliente("555.555.555-55", "Pedro Bernardo de SOUSA", 900.00));
        clientes.add(new Cliente("555.555.555-56", "Vitor", 9000.00));
        clientes.add(new Cliente("555.555.555-57", "Weuller", 52000.00));

        prod1.setEstoqueMinimo(10);
        prod1.setPreco(150.00);
        prod1.setUnidadeMedida("un");
        prod1.setQtdeEstoque(95);

        prod2.setEstoqueMinimo(10);
        prod2.setPreco(350.00);
        prod2.setUnidadeMedida("un");
        prod2.setQtdeEstoque(95);
    }
}
