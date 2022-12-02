package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Entities.Cliente;

public class MySQLClienteDAO implements ClienteDAO{



    @Override
    public Boolean cadastrarCliente(Cliente cliente) {
        try {
            Connection con = new Conexao().conectaBd();
            PreparedStatement pstm = con.prepareStatement("insert into cliente_DevEConnection(nome,telefone,email,senha,cidade,cnpj) values (?,?,?,?,?,?)");
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getTelefone());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getSenha());
            pstm.setString(5, cliente.getCidade());
            pstm.setString(6, cliente.getCnpj());

            pstm.executeUpdate();

            pstm.close();
            con.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro" + e);
            return false;
        }
    }
    
}
