package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.ItemPedido;

public class DaoItemPedido {
    private Connection conn;
    
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
}
