package br.com.deveconnection.model.daos;

import br.com.deveconnection.model.FabricaConexoes;
import br.com.deveconnection.model.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LoginDAO {
    private FabricaConexoes fabricaConexoes;

    public LoginDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    public Boolean login(Usuario usuario){
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("");
            return true;

        }catch (Exception e){
            return false;
        }

    }
}
