package br.com.deveconnection.model.repositories;

import java.util.List;

import br.com.deveconnection.model.daos.ClienteDAO;
import br.com.deveconnection.model.entities.Cliente;
import br.com.deveconnection.model.entities.Dev;

public class ClienteRepository {
    private ClienteDAO dao;

    public ClienteRepository(ClienteDAO dao) {
        this.dao = dao;
    }

    public Boolean cadastrarCliente(Cliente cliente){
        return dao.cadastrarCliente(cliente);
    }

    public List<Dev> visualizarDevsDisponiveisParaTrabalho(){
        return dao.visualizarDevsDisponiveisParaTrabalho();
    }


}