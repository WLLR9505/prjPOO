package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Vendedor;

public class DaoVendedor {
    private Connection conn;

    public DaoVendedor(Connection conn) {
         this.conn = conn;
    }

    public void inserir(Vendedor v) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO Vendedor (cpf, nome, endereco, cidade, uf, cep, ddd, telefone, taxaComissao, salarioBase) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, v.getCpf());
            ps.setString(2, v.getNome());
            ps.setString(3, v.getEndereco());
            ps.setString(4, v.getCidade());
            ps.setString(5, v.getUf());
            ps.setString(6, v.getCep());
            ps.setString(7, v.getDdd());
            ps.setString(8, v.getTelefone());
            ps.setDouble(9, v.getTaxaComissao());
            ps.setDouble(10, v.getSalarioBase());

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
    }

    public void alterar(Vendedor v) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Vendedor SET "+
                "nome = ?,"+
                "endereco = ?,"+
                "cidade = ?,"+
                "uf = ?,"+
                "cep = ?,"+
                "ddd = ?,"+
                "telefone = ?,"+
                "taxaComissao = ?,"+
                "salarioBase = ? WHERE cpf = ?"
            );

            ps.setString(1, v.getNome());
            ps.setString(2, v.getEndereco());
            ps.setString(3, v.getCidade());
            ps.setString(4, v.getUf());
            ps.setString(5, v.getCep());
            ps.setString(6, v.getDdd());
            ps.setString(7, v.getTelefone());
            ps.setDouble(8, v.getTaxaComissao());
            ps.setDouble(9, v.getSalarioBase());
            ps.setString(10, v.getCpf());

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
    }

    public Vendedor consultar (String cpf) {
        Vendedor v = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Vendedor WHERE cpf = ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                v = new Vendedor (cpf, rs.getString("nome"), rs.getDouble("salarioBase"));
                v.setEndereco(rs.getString("endereco"));
                v.setCidade(rs.getString("cidade"));
                v.setUf(rs.getString("uf"));
                v.setCep(rs.getString("cep"));
                v.setDdd(rs.getString("ddd"));
                v.setTelefone(rs.getString("telefone"));
                v.setSalarioBase(rs.getDouble("salarioBase"));
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return v;
    }

    public void excluir(Vendedor v) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM Cliente WHERE cpf = ?");
            ps.setString(1, v.getCpf());
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
    }
}
