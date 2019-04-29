
import fatec.poo.model.Cliente;
import java.util.ArrayList;
import fatec.poo.model.Produto;
import fatec.poo.model.Vendedor;

public class Aplic {
    public static void main(String[] args) {
        // instanciar 3 vendedores
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
        vendedores.add(new Vendedor("111.111.111-11", "Huguinho", 1200.00));
        vendedores.add(new Vendedor("222.222.222-22", "Zezinho", 1200.00));
        vendedores.add(new Vendedor("333.333.333-33", "Luizinho", 1200.00));

        // instanciar 3 clientes
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("555.555.555-55", "Bernardo", 900.00));
        clientes.add(new Cliente("555.555.555-56", "Vitor", 9000.00));
        clientes.add(new Cliente("555.555.555-57", "Weuller", 52000.00));

        // instanciar e configurar 2 produtos
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

        // mostrar os clientes
        for (int i=0; i<clientes.size(); i++){
            System.out.println("\nCPF: " + clientes.get(i).getCpf());
            System.out.println("Nome: " + clientes.get(i).getNome());
            System.out.println("Limite: " + clientes.get(i).getLimiteCred());
        }

        // mostrar os vendedores
        for (int i = 0; i < vendedores.size(); i++) {
            System.out.println("\nCPF: " + vendedores.get(i).getCpf());
            System.out.println("Vendedor: " + vendedores.get(i).getNome());
            System.out.println("Salario Base: " + vendedores.get(i).getSalarioBase());
        }

        // efetuar uma compra/venda
        
    }
}
