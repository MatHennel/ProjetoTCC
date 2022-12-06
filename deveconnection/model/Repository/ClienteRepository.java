package deveconnection.model.Repository;

import deveconnection.model.DAO.ClienteDAO;
import deveconnection.model.Entities.Cliente;

public class ClienteRepository {
    private ClienteDAO dao;

    public ClienteRepository(ClienteDAO dao) {
        this.dao = dao;
    }

    public Boolean cadastrarCliente(Cliente cliente){
        return dao.cadastrarCliente(cliente);
    }
}