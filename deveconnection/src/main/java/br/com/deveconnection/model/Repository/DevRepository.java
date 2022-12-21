package br.com.deveconnection.model.Repository;

import br.com.deveconnection.model.DAO.DevDAO;
import br.com.deveconnection.model.Entities.Dev;

public class DevRepository {
    private DevDAO dao;

    public DevRepository(DevDAO dao) {
        this.dao = dao;
    }

    public Boolean cadastrarDev(Dev dev) {
        return dao.cadastrarCliente(dev);

    }

}
