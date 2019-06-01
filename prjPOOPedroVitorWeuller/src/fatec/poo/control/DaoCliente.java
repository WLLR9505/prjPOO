package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Cliente;

public class DaoCliente {
    private Connection conn;
    
    public DaoCliente(Connection conn) {
         this.conn = conn;
    }

    public void inserir(Cliente c) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO Cliente (cpf, nome, endereco, cidade, uf, cep, ddd, telefone, limiteCred, limiteDisp) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, c.getCpf());
            ps.setString(2, c.getNome());
            ps.setString(3, c.getEndereco());
            ps.setString(4, c.getCidade());
            ps.setString(5, c.getUf());
            ps.setString(6, c.getCep());
            ps.setString(7, c.getDdd());
            ps.setString(8, c.getTelefone());
            ps.setDouble(9, c.getLimiteCred());
            ps.setDouble(10, c.getLimiteDisp());

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Cliente c) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Cliente SET "+
                "nome = ?,"+
                "endereco = ?,"+
                "cidade = ?,"+
                "uf = ?,"+
                "cep = ?,"+
                "ddd = ?,"+
                "telefone = ?,"+
                "limiteCred = ?,"+
                "limiteDisp = ? WHERE cpf = ?"
            );

            ps.setString(1, c.getNome());
            ps.setString(2, c.getEndereco());
            ps.setString(3, c.getCidade());
            ps.setString(4, c.getUf());
            ps.setString(5, c.getCep());
            ps.setString(6, c.getDdd());
            ps.setString(7, c.getTelefone());
            ps.setDouble(8, c.getLimiteCred());
            ps.setDouble(9, c.getLimiteDisp());
            ps.setString(10, c.getCpf());

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
    }

    public Cliente consultar (String cpf) {
        Cliente c = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Cliente WHERE cpf = ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                c = new Cliente (cpf, rs.getString("nome"), rs.getDouble("limiteCred"));
                c.setEndereco(rs.getString("endereco"));
                c.setCidade(rs.getString("cidade"));
                c.setUf(rs.getString("uf"));
                c.setCep(rs.getString("cep"));
                c.setDdd(rs.getString("ddd"));
                c.setTelefone(rs.getString("telefone"));
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return c;
    }

    public void excluir(Cliente c) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM Cliente WHERE cpf = ?");
            ps.setString(1, c.getCpf());
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());
        }
    }
}
