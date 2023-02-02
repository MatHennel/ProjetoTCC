package br.com.deveconnection.model.daos;

import java.util.List;

import br.com.deveconnection.model.entities.Cliente;
import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.results.Result;



public interface ClienteDAO {
    public Result cadastrarCliente(Cliente cliente); 

    public List<Dev> visualizarDevsDisponiveisParaTrabalho();

    public Cliente login(String email,String senha);
}


