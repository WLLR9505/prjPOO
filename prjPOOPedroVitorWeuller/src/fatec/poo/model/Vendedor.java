
package fatec.poo.model;

import java.util.ArrayList;


public class Vendedor extends Pessoa {
    private double salarioBase;
    private double taxaComissao;
    private ArrayList<Pedido> pedidos;

    public Vendedor(String cpf, String nome, Double salarioBase) {
        super(cpf, nome);
        this.salarioBase = salarioBase;
        pedidos = new ArrayList<Pedido>();
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setTaxaComissao(double setTaxaComissao) {
        this.taxaComissao = setTaxaComissao;
    }

    public double getSalarioBase(){
        return salarioBase;
    }

    public double getTaxaComissao(){
        return taxaComissao;
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.setVendedor(this);
    }
}

