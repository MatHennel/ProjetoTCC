package br.com.deveconnection.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.deveconnection.model.Entities.Dev;

public class JDBCDevDAO implements DevDAO {

    private Conexao conexao;

    public JDBCDevDAO(Conexao conexao) {
        this.conexao = conexao;
    }

    @Override
    public Boolean cadastrarCliente(Dev dev) {

        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm = con.prepareStatement(
                    "insert into dev_DevEConnection(nome,telefone,email,senha,cidade,data_nascimento,competencias_dev,status_dev) values (?,?,?,?,?,?,?,?)");
            pstm.setString(1, dev.getNome());
            pstm.setString(2, dev.getTelefone());
            pstm.setString(3, dev.getEmail());
            pstm.setString(4, dev.getSenha());
            pstm.setString(5, dev.getCidade());
            pstm.setDouble(6, dev.getDataDeNascimento().toEpochDay());
            pstm.setString(7, dev.getCompetenciasDev());
            pstm.setBoolean(8, true);

            pstm.executeUpdate();

            pstm.close();
            con.close();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
