package br.com.deveconnection;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import br.com.deveconnection.controllers.PrimaryController;
import br.com.deveconnection.controllers.SecondaryController;
import br.com.deveconnection.controllers.TelaPrincipal;
import br.com.deveconnection.model.FabricaConexoes;
import br.com.deveconnection.model.daos.ClienteDAO;
import br.com.deveconnection.model.daos.DevDAO;
import br.com.deveconnection.model.daos.JDBCClienteDAO;
import br.com.deveconnection.model.daos.JDBCDevDAO;
import br.com.deveconnection.model.repositories.ClienteRepository;
import br.com.deveconnection.model.repositories.DevRepository;
import br.com.deveconnection.utils.Navigator.BaseAppNavigator;
import br.com.deveconnection.utils.Navigator.ScreenRegistryFXML;





/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {


    //DEFINIR A FABRICA DE CONEXÕES, DAOS e REPOSITÓRIOS

    private FabricaConexoes fabricaConexoes;
    private ClienteDAO clienteDao;
    private ClienteRepository clienteRepository;

    private DevRepository devRepository;
    private DevDAO devDAO;

    @Override
    public void init() throws Exception {
        // TODO Auto-generated method stub
        super.init();
        
        //INSTANCIAR FABRICA, DAOS E REPOSITÓRIOS

        fabricaConexoes = FabricaConexoes.getInstance();

        clienteDao = new JDBCClienteDAO(fabricaConexoes);

        clienteRepository = new ClienteRepository(clienteDao);

        devDAO = new JDBCDevDAO(fabricaConexoes);

        devRepository = new DevRepository(devDAO);
    
    }

    @Override
    public void stop() throws Exception {
        super.stop();

    }



    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "DEV";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "DEVECONNECTION";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(getClass(), "fxml/principal.fxml", (o)->new TelaPrincipal()));
        registraTela("CLIENTE", new ScreenRegistryFXML(getClass(), "fxml/primary.fxml", (o)->new PrimaryController(clienteRepository)));
        registraTela("DEV", new ScreenRegistryFXML(getClass(), "fxml/secondary.fxml", (o->new SecondaryController(devRepository))));
        
        //REGISTRAR AS OUTRAS TELAS

    }


}