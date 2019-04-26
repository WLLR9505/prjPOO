
import fatec.poo.model.Cliente;
import java.util.ArrayList;


public class Aplic {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        clientes.add(new Cliente("319.587.718-05", "Pedro Bernardo de SOUSA", 900.00));
        clientes.add(new Cliente("223.861.678-01", "Vitor", 9000.00));
        clientes.add(new Cliente("458.038.288-90", "Weuller", 52000.00));
    }
}
