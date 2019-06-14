package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Produto;
import fatec.poo.model.Pedido;

public class DaoPedido {
    private Connection conn;

    public DaoPedido(Connection conn) {
         this.conn = conn;
    }

    public void inserir(Pedido p) {
        PreparedStatement ps = null;
        /*
        try {
            ps = conn.prepareStatement("INSERT INTO Produto (codigo, descricao, qtdeEstoque, unidadeMedida, preco, estoqueMinimo) VALUES(?,?,?,?,?,?)");
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getDescricao());
            ps.setDouble(3, p.getQtdeEstoque());
            ps.setString(4, p.getUnidadeMedida());
            ps.setDouble(5, p.getPreco());
            ps.setDouble(6, p.getEstoqueMinimo());

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
        */
    }

    public void alterar(Produto p) {
        PreparedStatement ps = null;
        /*
        try {
            ps = conn.prepareStatement("UPDATE Produto SET "+
                "descricao = ?,"+
                "qtdeEstoque = ?,"+
                "unidadeMedida = ?,"+
                "preco = ?,"+
                "estoqueMinimo = ? WHERE codigo = ?"
            );

            ps.setString(1, p.getDescricao());
            ps.setDouble(2, p.getQtdeEstoque());
            ps.setString(3, p.getUnidadeMedida());
            ps.setDouble(4, p.getPreco());
            ps.setDouble(5, p.getEstoqueMinimo());
            ps.setString(6, p.getCodigo());

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
        */
    }

    public Pedido consultar (String numero) {
        Pedido p = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Pedido WHERE numero = ?");

            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                /*
                p = new Produto (codigo, rs.getString("descricao"));
                p.setQtdeEstoque(rs.getDouble("qtdeEstoque"));
                p.setUnidadeMedida(rs.getString("unidadeMedida"));
                p.setPreco(rs.getDouble("preco"));
                p.setEstoqueMinimo(rs.getDouble("estoqueMinimo"));
                */
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return p;
    }

    public void excluir(Pedido p) {
        PreparedStatement ps = null;
        /* TODO: antes de excluir o pedido, é preciso excluir todos os itens
           referentes a ele na tabela itemPedido
        try {
            ps = conn.prepareStatement("DELETE FROM Produto WHERE codigo = ?");
            ps.setString(1, p.getCodigo());
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
        */
    }
}
