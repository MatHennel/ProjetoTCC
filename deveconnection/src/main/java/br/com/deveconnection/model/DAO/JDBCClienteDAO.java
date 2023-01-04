package br.com.deveconnection.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.deveconnection.model.Entities.Cliente;

public class JDBCClienteDAO implements ClienteDAO{

    private Conexao conexao;

    
    public JDBCClienteDAO(Conexao conexao) {
        this.conexao = conexao;
    }


    

    @Override
    public Boolean cadastrarCliente(Cliente cliente) {
        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm = con.prepareStatement("insert into cliente_DevEConnection(nome,telefone,email,senha,cidade,cnpj,status) values (?,?,?,?,?,?,?)");
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getTelefone());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getSenha());
            pstm.setString(5, cliente.getCidade());
            pstm.setString(6, cliente.getCnpj());
            pstm.setBoolean(7, true);


            pstm.executeUpdate();

            pstm.close();
            con.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return false;
        }
    }

    
    
}
