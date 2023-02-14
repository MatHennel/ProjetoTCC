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
                    .prepareStatement("select email from cliente_DevEConnection where email=? UNION SELECT email from dev_DevEConnection where email=?");

            pstm2.setString(1, cliente.getEmail());
            pstm2.setString(2, cliente.getEmail());


            PreparedStatement pstm3 = con.prepareStatement("select senha from cliente_DevEConnection where senha=? UNION SELECT senha from dev_DevEConnection where senha=?");

            pstm3.setString(1, cliente.getSenha());
            pstm3.setString(2, cliente.getSenha());


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
    public List<Dev> visualizarDevsDisponiveisParaTrabalho() {
        List<Dev> listaDevs = new ArrayList<>();
        try {

            Connection con = fabricaConexoes.getConnection();
            String query = "SELECT nome, telefone, cidade, competencias_dev, status_dev FROM dev_DevEConnection where status_dev = 1";
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                Dev dev = new Dev(rs.getString("nome"), rs.getString("telefone"), rs.getString("cidade"),
                        rs.getString("competencias_dev"));
                listaDevs.add(dev);
            }

            rs.close();
            pstm.close();
            con.close();

            return listaDevs;

        } catch (Exception e) {
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


            

            
            

            if (rs.next() == false) {
                rs.close();
                pstm.close();
                con.close();
                return null;
            } else {
                
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
