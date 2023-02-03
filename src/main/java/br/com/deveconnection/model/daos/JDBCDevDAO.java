package br.com.deveconnection.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.deveconnection.model.FabricaConexoes;
import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.results.Result;

public class JDBCDevDAO implements DevDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCDevDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result cadastrarCliente(Dev dev) {

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

            PreparedStatement pstm2 = con
                    .prepareStatement("SELECT email from dev_DevEConnection where email = ?");

            pstm2.setString(1, dev.getEmail());

            PreparedStatement pstm3 = con.prepareStatement("SELECT senha from dev_DevEConnection where senha = ?");

            pstm3.setString(1, dev.getSenha());

            ResultSet rs = pstm2.executeQuery();
            ResultSet rs2 = pstm3.executeQuery();

            if (!rs.next() && !rs2.next()) {

                
                    pstm.executeUpdate();

                    rs.close();
                    rs2.close();
                    pstm.close();
                    pstm2.close();
                    pstm3.close();
                    con.close();
               

                return Result.success("Cadastro Realizado");
            } else if (!rs.next()) {

                rs.close();
                rs2.close();
                pstm.close();
                pstm2.close();
                pstm3.close();
                con.close();

                return Result.fail("Senha já existente");
            } else if (!rs2.next()) {

                rs.close();
                rs2.close();
                pstm.close();
                pstm2.close();
                pstm3.close();
                con.close();

                return Result.fail("Email já existente");

            } else {

                rs.close();
                rs2.close();
                pstm.close();
                pstm2.close();
                pstm3.close();
                con.close();

                return Result.fail("Email e senha já existente");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public Boolean login(String email, String senha) {
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con
                    .prepareStatement("SELECT email , senha from dev_DevEConnection where email = ? and senha = ?");

            pstm.setString(1, email);
            pstm.setString(2, senha);

            ResultSet rs = pstm.executeQuery();

            if (rs == null) {
                return false;
            }
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
