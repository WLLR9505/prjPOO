
package fatec.poo.model;
import java.util.ArrayList;

public class Cliente extends Pessoa {
    private double limiteCred;
    private double limiteDisp;
    private ArrayList<Pedido> pedidos;

    public Cliente(String cpf, String nome, double limiteCred) {
        super(cpf, nome);
        this.limiteCred = limiteCred;
        this.limiteDisp = limiteCred;
        this.pedidos = new ArrayList<Pedido>();
    }

    public void setLimiteCred(double limiteCred) {
        this.limiteCred = limiteCred;
    }

    public void setLimiteDisp(double limiteDisp) {
        this.limiteDisp = limiteDisp;
    }

    public double getLimiteCred() {
        return limiteCred;
    }

    public double getLimiteDisp() {
        return limiteDisp;
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.setCliente(this);
    }
    
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
