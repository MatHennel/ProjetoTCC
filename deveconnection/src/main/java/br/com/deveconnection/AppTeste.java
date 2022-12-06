
package br.com.deveconnection;

import br.com.deveconnection.model.DAO.Conexao;

public class AppTeste {
    public static void main(String[] args) throws Exception {
        
        Conexao.getInstance().getConnection();

    }
}