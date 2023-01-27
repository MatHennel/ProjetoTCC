package br.com.deveconnection.model.daos;

import java.util.List;

import br.com.deveconnection.model.entities.Cliente;
import br.com.deveconnection.model.entities.Dev;



public interface ClienteDAO {
    public Boolean cadastrarCliente(Cliente cliente); 

    public List<Dev> visualizarDevsDisponiveisParaTrabalho();
}
