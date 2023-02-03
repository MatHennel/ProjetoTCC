package br.com.deveconnection.model.daos;

import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.results.Result;

public interface DevDAO {
    public Result cadastrarCliente(Dev dev); 

    public Boolean login(String email,String senha);
    
}
