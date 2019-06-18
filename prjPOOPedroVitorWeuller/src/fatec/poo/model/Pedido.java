package fatec.poo.model;
import java.util.ArrayList;

public class Pedido {
    private String numero;
    private String dataEmissao;
    private String dataPagto;
    private boolean formaPagto; /* TRUE: a prazo */
    private boolean situacao;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<ItemPedido> itens;

    public Pedido(String numero, String dataEmissao) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        itens = new ArrayList<ItemPedido>();
    }

    public void addItem(ItemPedido item) {
        itens.add(item);
        item.setPedido(this);

        if (formaPagto) {
            cliente.setLimiteDisp(cliente.getLimiteDisp() - item.getProduto().getPreco() * item.getQtdeVendida());
        }
    }
    
    public void removeItem(int indice) {
        ItemPedido item = itens.get(indice);
        itens.remove(item);

        
    }
    
    public ArrayList<ItemPedido> getItens() {
        return itens;
    }
    
    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public void setFormaPagto(boolean formaPagto) {
        this.formaPagto = formaPagto;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public String getNumero() {
        return numero;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public String getDataPagto() {
        return dataPagto;
    }

    public boolean getFormaPagto() {
        return formaPagto;
    }

    public boolean getSituacao() {
        return situacao;
    }
    
    public double calcTotal(){
        double total = 0;
        int i;

        for (i=0; i<itens.size(); i++) {
            total += itens.get(i).getQtdeVendida() * itens.get(i).getProduto().getPreco();
        }

        return total;
    }
    
    public int calcQtdeItens() {
        int total = 0;
        int i;

        for (i=0; i<itens.size(); i++) {
            total += itens.get(i).getQtdeVendida();
        }

        return total;
    }
}
