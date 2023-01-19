package br.com.deveconnection.model.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import br.com.deveconnection.model.Entities.Cliente;
import br.com.deveconnection.model.Entities.Dev;

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




    @Override
    public List<Dev> visualizarDevsDisponiveisParaTrabalho() {
        try {
            List<Dev> devs = new ArrayList<>();
            Connection con = conexao.getConnection();
            PreparedStatement pstm = con.prepareStatement("select * from dev_DevEConnection");
            ResultSet rs= pstm.executeQuery();

            while(rs.next()){
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
                

                

                
                
                Dev dev = new Dev(nome, telefone, email, Integer.toString(senha), cidade,id, competenciasdDev, dataNascimento, competenciasdDev);
                dev.alternarStatusPerfil(status);

                devs.add(dev);


            }

            return devs;
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    
    
}
