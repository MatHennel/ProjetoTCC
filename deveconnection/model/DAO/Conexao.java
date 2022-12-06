package deveconnection.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final int MAX_CONEXOES=5;

    private static Conexao instance;

    private Connection[] conexoes;

    private Conexao(){
        conexoes = new Connection[MAX_CONEXOES];
    }

    public static Conexao getInstance(){
        if(instance == null){
            instance = new Conexao();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException{


        for(int i=0;i<conexoes.length;i++){
            if(conexoes[i]==null || conexoes[i].isClosed()){
                conexoes[i] = DriverManager.getConnection("jdbc:mysql://wagnerweinert.com.br/tads21_matheushennel",
                "tads21_matheushennel",
                "tads21_matheushennel");
                return conexoes[i];
            }
        }
        throw new SQLException("Não há conexões disponíveis! Esqueceu de fechar?");
    }

       
}
