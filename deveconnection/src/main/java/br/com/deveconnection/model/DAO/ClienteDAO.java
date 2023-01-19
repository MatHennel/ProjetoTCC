package br.com.deveconnection.model.DAO;

import java.util.List;

import br.com.deveconnection.model.Entities.Cliente;
import br.com.deveconnection.model.Entities.Dev;



public interface ClienteDAO {
    public Boolean cadastrarCliente(Cliente cliente); 

    public List<Dev> visualizarDevsDisponiveisParaTrabalho();
}
