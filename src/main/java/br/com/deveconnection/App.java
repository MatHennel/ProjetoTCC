package br.com.deveconnection;


import br.com.deveconnection.controllers.TelaLogin;
import br.com.deveconnection.controllers.TelaPC;
import br.com.deveconnection.controllers.CadastroCliente;
import br.com.deveconnection.controllers.CadastroDev;
import br.com.deveconnection.controllers.PerfilCliente;
import br.com.deveconnection.controllers.TelaListaDev;
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
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "DEVECONNECTION";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(getClass(), "fxml/telaprincipal.fxml", (o)->new TelaPrincipal()));
        registraTela("CLIENTE", new ScreenRegistryFXML(getClass(), "fxml/cadastrocliente.fxml", (o)->new CadastroCliente(clienteRepository)));
        registraTela("DEV", new ScreenRegistryFXML(getClass(), "fxml/cadastrodev.fxml", (o->new CadastroDev(devRepository))));
        registraTela("LOGIN", new ScreenRegistryFXML(getClass(), "fxml/login.fxml", (o->new TelaLogin(clienteRepository,devRepository))));
        registraTela("LOGINCLIENTE", new ScreenRegistryFXML(getClass(), "fxml/telaListaDev.fxml", o->new TelaListaDev(clienteRepository)));
        registraTela("TELAPC", new ScreenRegistryFXML(getClass(), "fxml/telaPC.fxml", o->new TelaPC()));
        registraTela("PC", new ScreenRegistryFXML(getClass(), "fxml/perfilCliente.fxml", o->new PerfilCliente()));


        

        
        //REGISTRAR AS OUTRAS TELAS

    }


}