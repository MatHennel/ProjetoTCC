package br.com.deveconnection.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

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
                    "insert into dev_DevEConnection(nome,telefone,email,senha,cidade,data_nascimento,competencias_dev,especialidades_dev,status_dev) values (?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, dev.getNome());
            pstm.setString(2, dev.getTelefone());
            pstm.setString(3, dev.getEmail());
            pstm.setString(4, dev.getSenha());
            pstm.setString(5, dev.getCidade());
            pstm.setDouble(6, dev.getDataDeNascimento().toEpochDay());
            pstm.setString(8, dev.getCompetenciasDev());
            pstm.setString(7, dev.getEspecialidades());
            pstm.setBoolean(9, true);

            PreparedStatement pstm2 = con
                    .prepareStatement(
                            "select email from cliente_DevEConnection where email=? UNION SELECT email from dev_DevEConnection where email=?");

            pstm2.setString(1, dev.getEmail());
            pstm2.setString(2, dev.getEmail());

            PreparedStatement pstm3 = con.prepareStatement(
                    "select senha from cliente_DevEConnection where senha=? UNION SELECT senha from dev_DevEConnection where senha = ?");

            pstm3.setString(1, dev.getSenha());
            pstm3.setString(2, dev.getSenha());

            ResultSet rs = pstm2.executeQuery();
            ResultSet rs2 = pstm3.executeQuery();

            int email;
            int senha;

            for ( email = 0; rs.next(); email++) {
               
            }

            for ( senha = 0; rs2.next(); senha++) {
               
            }

            if (email == 0 && senha == 0) {

                
                pstm.executeUpdate();

                rs.close();
                rs2.close();
                pstm.close();
                pstm2.close();
                pstm3.close();
                con.close();
           

            return Result.success("Cadastro Realizado");
        } else if (email != 0 && senha != 0) {

            rs.close();
            rs2.close();
            pstm.close();
            pstm2.close();
            pstm3.close();
            con.close();

            return Result.fail("Email e senha já existente");
        } else if (email != 0) {

            rs.close();
            rs2.close();
            pstm.close();
            pstm2.close();
            pstm3.close();
            con.close();

            return Result.fail("Email já existente");

        }else if(senha != 0){

            rs.close();
            rs2.close();
            pstm.close();
            pstm2.close();
            pstm3.close();
            con.close();

            return Result.fail("Senha já existente");

        }else{
            return Result.fail("Nao foi possivel cadastrar");
        }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return Result.fail("Erro ao cadastrar");
        }

    }

    @Override
    public Dev login(String email, String senha) {
        try {
            Dev dev;
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con
                    .prepareStatement("SELECT * from dev_DevEConnection where email = ? and senha = ?");

            pstm.setString(1, email);
            pstm.setString(2, senha);

            ResultSet rs = pstm.executeQuery();
            



           
            

            if (rs.next() == false) {
                rs.close();
                pstm.close();
                con.close();
                return null;
            } else {
                
                dev = new Dev(rs.getString(2), rs.getString(3), email, senha, rs.getString(6), rs.getInt(1),
                        rs.getString(8), LocalDate.ofEpochDay(rs.getInt(7)), rs.getString(9),rs.getBoolean(10));

            }

            rs.close();
            pstm.close();
            con.close();

            return dev;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void inativar(Boolean inativar, int codigo) {
        try {   
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("UPDATE  dev_DevEConnection SET status_dev = ? where idDev = ?");
            System.out.println("\nInativo: " + inativar);
            System.out.println("\nId: " + codigo);

            pstm.setBoolean(1, inativar);
            pstm.setInt(2, codigo);
            pstm.executeUpdate();

            pstm.close();
            con.close();


            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

   

}
