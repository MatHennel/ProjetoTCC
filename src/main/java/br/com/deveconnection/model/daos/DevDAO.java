package br.com.deveconnection.model.daos;

import java.util.List;

import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.results.Result;

public interface DevDAO {
    public Result cadastrarCliente(Dev dev); 

    public Dev login(String email,String senha);

    public void inativar(Boolean inativar,int codigo);

    
    
}
