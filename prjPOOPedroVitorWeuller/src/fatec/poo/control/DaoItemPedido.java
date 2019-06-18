package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.ItemPedido;
import fatec.poo.model.Produto;
import fatec.poo.model.Pedido;
import java.util.ArrayList;

public class DaoItemPedido {
    private Connection conn;
    private DaoProduto daoProduto;
    
    public DaoItemPedido(Connection conn) {
        this.conn = conn;
    }

    public void inserir(ItemPedido ip) {
        System.out.println("INSERIR ITEMPEDIDO");
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO ItemPedido VALUES(?,?,?,?)");
            ps.setString(1, ip.getPedido().getNumero());
            ps.setString(2, ip.getProduto().getCodigo());
            ps.setDouble(3, ip.getSequencia());
            ps.setDouble(4, ip.getQtdeVendida());

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
    }
    
    public void alterar(ItemPedido ip) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE ItemPedido SET "+
                "sequencia = ?,"+
                "qtdeVendida = ? WHERE pedido = ? AND produto = ?"
            );

            ps.setDouble(1, ip.getSequencia());
            ps.setDouble(2, ip.getQtdeVendida());
            ps.setString(3, ip.getPedido().getNumero());
            ps.setString(4, ip.getProduto().getCodigo());

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
    }
    
    public ArrayList<ItemPedido> buscarItens(String numPedido, Pedido pedido) {
        ArrayList<ItemPedido> itens = new ArrayList<ItemPedido>();
        ItemPedido ip;
        Produto produto;
        PreparedStatement ps = null;
        daoProduto = new DaoProduto(conn);

        try {
            ps = conn.prepareStatement("SELECT * FROM ItemPedido WHERE pedido = ?");

            ps.setString(1, numPedido);
            ResultSet rs = ps.executeQuery();

            while (rs.next() == true) {
                produto = daoProduto.consultar(rs.getString("produto"));
                
                ip = new ItemPedido (rs.getInt("sequencia"), rs.getDouble("qtdeVendida"), produto);
                ip.setPedido(pedido);
                itens.add(ip);
            }
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
        
        return itens;
    }
}
