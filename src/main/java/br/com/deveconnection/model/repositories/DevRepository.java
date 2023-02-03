package br.com.deveconnection.model.repositories;

import br.com.deveconnection.model.daos.DevDAO;
import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.results.Result;

public class DevRepository {
    private DevDAO dao;

    public DevRepository(DevDAO dao) {
        this.dao = dao;
    }

    public Result cadastrarDev(Dev dev) {
        return dao.cadastrarCliente(dev);

    }

    public Dev loginDev(String email,String senha){
        return dao.login(email,senha);
    }

}
