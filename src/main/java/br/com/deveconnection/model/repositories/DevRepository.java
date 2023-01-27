package br.com.deveconnection.model.repositories;

import br.com.deveconnection.model.daos.DevDAO;
import br.com.deveconnection.model.entities.Dev;

public class DevRepository {
    private DevDAO dao;

    public DevRepository(DevDAO dao) {
        this.dao = dao;
    }

    public Boolean cadastrarDev(Dev dev) {
        return dao.cadastrarCliente(dev);

    }

}
