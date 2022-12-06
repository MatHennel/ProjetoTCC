package br.com.deveconnection.model.Repository;

import br.com.deveconnection.model.DAO.ClienteDAO;
import br.com.deveconnection.model.Entities.Cliente;

public class ClienteRepository {
    private ClienteDAO dao;

    public ClienteRepository(ClienteDAO dao) {
        this.dao = dao;
    }

    public Boolean cadastrarCliente(Cliente cliente){
        return dao.cadastrarCliente(cliente);
    }
}