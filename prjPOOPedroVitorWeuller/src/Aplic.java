
import fatec.poo.model.Cliente;
import java.util.ArrayList;
import fatec.poo.model.Produto;

public class Aplic {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Produto prod1 = new Produto("1", "Mouse Gamer");
        Produto prod2 = new Produto("2", "Keyboard Iluminado");

        clientes.add(new Cliente("319.587.718-05", "Pedro Bernardo de SOUSA", 900.00));
        clientes.add(new Cliente("223.861.678-01", "Vitor", 9000.00));
        clientes.add(new Cliente("458.038.288-90", "Weuller", 52000.00));

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
