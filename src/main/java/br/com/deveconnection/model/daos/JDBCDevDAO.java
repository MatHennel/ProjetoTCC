package br.com.deveconnection.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.deveconnection.model.FabricaConexoes;
import br.com.deveconnection.model.entities.Dev;

public class JDBCDevDAO implements DevDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCDevDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Boolean cadastrarCliente(Dev dev) {

        try {
            Connection con = fabricaConexoes.getConnection();
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
