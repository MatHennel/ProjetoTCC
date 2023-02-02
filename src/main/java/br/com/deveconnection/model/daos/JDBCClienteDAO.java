package br.com.deveconnection.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.ResultStreamer;

import br.com.deveconnection.model.FabricaConexoes;
import br.com.deveconnection.model.entities.Cliente;
import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.results.Result;

public class JDBCClienteDAO implements ClienteDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCClienteDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result cadastrarCliente(Cliente cliente) {
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement(
                    "insert into cliente_DevEConnection(nome,telefone,email,senha,cidade,cnpj,status) values (?,?,?,?,?,?,?)");
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getTelefone());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getSenha());
            pstm.setString(5, cliente.getCidade());
            pstm.setString(6, cliente.getCnpj());
            pstm.setBoolean(7, true);

            

            PreparedStatement pstm2 = con
                    .prepareStatement("SELECT email from cliente_DevEConnection where email = ?");

            pstm2.setString(1, cliente.getSenha());
            pstm2.setString(2, cliente.getEmail());

            PreparedStatement pstm3 = con.prepareStatement("SELECT senha from cliente_DevEConnection where senha = ?");

            

            ResultSet rs = pstm2.executeQuery();
            ResultSet rs2 = pstm3.executeQuery();
            
            

            if (!rs.next() && !rs2.next()) {

                
                pstm.executeUpdate();
                
                return Result.success("Cadastro Realizado");
            } else if (!rs.getString("senha").isEmpty()) {
                
                
                return Result.fail("Senha já existente");
            } else if (!rs2.getString("email").isEmpty()) {
                
                return Result.fail("Email já existente");

            } else {
                
               
                return Result.fail("Email e senha já existente");

            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return Result.fail("Erro ao cadastrar");

        }
    }

    @Override
    public List<Dev> visualizarDevsDisponiveisParaTrabalho() {
        try {
            List<Dev> devs = new ArrayList<>();
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("select * from dev_DevEConnection");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String telefone = rs.getString(3);
                String email = rs.getString(4);
                int senha = rs.getInt(5);

                String cidade = rs.getString(6);
                Double dataNasciD = rs.getDouble(7);
                LocalDate dataNascimento = LocalDate.ofEpochDay(dataNasciD.intValue());
                String competenciasdDev = rs.getString(8);
                Boolean status = rs.getBoolean(9);

                Dev dev = new Dev(nome, telefone, email, Integer.toString(senha), cidade, id, competenciasdDev,
                        dataNascimento, competenciasdDev);
                dev.alternarStatusPerfil(status);

                devs.add(dev);

                rs.close();
                pstm.close();
                con.close();

            }

            return devs;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public Cliente login(String email, String senha) {
        try {
            Cliente cliente;
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con
                    .prepareStatement("SELECT * from cliente_DevEConnection where email = ? and senha = ?");

            pstm.setString(1, email);
            pstm.setString(2, senha);

            ResultSet rs = pstm.executeQuery();

            if (rs == null) {
                return null;
            } else {
                rs.next();
                cliente = new Cliente(rs.getString(2), rs.getString(3), email, senha, rs.getString(6), rs.getInt(1),
                        rs.getString(7));

            }

            rs.close();
            pstm.close();
            con.close();
            return cliente;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

}
