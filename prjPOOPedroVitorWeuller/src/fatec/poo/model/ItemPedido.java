package fatec.poo.model;


public class ItemPedido {
    private int sequencia;
    private double qtdeVendida;
    private Pedido pedido;
    private Produto produto;

    public ItemPedido(int sequencia, double qtdeVendida, Produto produto) {
        this.sequencia = sequencia;
        this.qtdeVendida = qtdeVendida;
        produto.setQtdeEstoque(produto.getQtdeEstoque() - qtdeVendida);
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public Produto getProduto(){
        return produto;
    }

    public void setQtdeVendida(double qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public int getSequencia() {
        return sequencia;
    }

    public double getQtdeVendida() {
        return qtdeVendida;
    }
}

