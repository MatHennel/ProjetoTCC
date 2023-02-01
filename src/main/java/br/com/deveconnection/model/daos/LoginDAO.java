package br.com.deveconnection.model.daos;

import br.com.deveconnection.model.FabricaConexoes;
import br.com.deveconnection.model.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    private FabricaConexoes fabricaConexoes;

    public LoginDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    public Usuario login(Usuario usuario){
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT email , senha from dev_DevEConnection where email = ? and senha = ?");
            PreparedStatement pstm2 = con.prepareStatement("SELECT email , senha from cliente_DevEConnection where email = ? and senha = ?");
            
            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, usuario.getSenha());
            pstm2.setString(1, usuario.getEmail());
            pstm2.setString(2, usuario.getSenha());

            
            ResultSet rs = pstm.executeQuery();
            ResultSet rs2 = pstm2.executeQuery();

            

            if(rs == null && rs2 == null){
                return null;
            }else{
                return usuario;
            }
            



        }catch (Exception e){
            return null;
        }

    }
}
