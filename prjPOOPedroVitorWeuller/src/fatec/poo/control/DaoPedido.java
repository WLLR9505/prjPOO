package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Produto;
import fatec.poo.model.Pedido;
import fatec.poo.model.Cliente;

public class DaoPedido {
    private Connection conn;
    private DaoCliente daoCliente;
    private DaoProduto daoProduto;
    private DaoVendedor daoVendedor;
    private DaoItemPedido daoItemPedido;
    private Produto produto;

    public DaoPedido(Connection conn) {
         this.conn = conn;
    }

    public void inserir(Pedido p) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO Pedido (numero, dataEmissao, dataPagto, formaPagto, cliente, vendedor) VALUES(?,?,?,?,?,?)");
            ps.setString(1, p.getNumero());
            ps.setString(2, p.getDataEmissao());
            ps.setString(3, p.getDataPagto());
            
            if (p.getFormaPagto()) ps.setString(4, "P");
            else ps.setString(4, "V");
            
            ps.setString(5, p.getCliente().getCpf());
            ps.setString(6, p.getVendedor().getCpf());

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
    }

    public Pedido consultar (String numero) {
        Pedido p = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Pedido WHERE numero = ?");

            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                p = new Pedido (numero, rs.getString("dataEmissao"));
                p.setDataPagto(rs.getString("dataPagto"));
                if ("P".equals(rs.getString("formaPagto"))) p.setFormaPagto(true);
                else p.setFormaPagto(false);

                daoCliente = new DaoCliente(conn);
                p.setCliente(daoCliente.consultar(rs.getString("cliente")));
                
                daoVendedor = new DaoVendedor(conn);
                p.setVendedor(daoVendedor.consultar(rs.getString("vendedor")));
                
                daoItemPedido = new DaoItemPedido(conn);
                p.setItens(daoItemPedido.buscarItens(numero, p));
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return p;
    }

    public void excluir(Pedido p) {
        PreparedStatement ps = null;

        try {
            if (p.getFormaPagto()) {
                p.getCliente().setLimiteDisp(p.getCliente().getLimiteDisp() + p.calcTotal());
                daoCliente = new DaoCliente(conn);
                daoCliente.alterar(p.getCliente());
            }

            daoProduto = new DaoProduto(conn);
            for (int i=0; i<p.getItens().size(); i++) {
                produto = p.getItens().get(i).getProduto();
                produto.setQtdeEstoque(produto.getQtdeEstoque() + p.getItens().get(i).getQtdeVendida());
                daoProduto.alterar(produto);
            }
            
            ps = conn.prepareStatement("DELETE FROM ItemPedido WHERE pedido = ?");
            ps.setString(1, p.getNumero());
            ps.execute();
            
            ps = conn.prepareStatement("DELETE FROM Pedido WHERE numero = ?");
            ps.setString(1, p.getNumero());
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
    }
}
