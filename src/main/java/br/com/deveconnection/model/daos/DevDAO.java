package br.com.deveconnection.model.daos;

import br.com.deveconnection.model.entities.Dev;

public interface DevDAO {
    public Boolean cadastrarCliente(Dev dev); 

    public Boolean login(String email,String senha);
    
}
