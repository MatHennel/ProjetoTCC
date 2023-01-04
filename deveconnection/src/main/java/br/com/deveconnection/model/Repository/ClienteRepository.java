package br.com.deveconnection.model.Repository;

import java.util.List;

import br.com.deveconnection.model.DAO.ClienteDAO;
import br.com.deveconnection.model.Entities.Cliente;
import br.com.deveconnection.model.Entities.Dev;

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