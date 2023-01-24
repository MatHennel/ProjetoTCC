package br.com.deveconnection;

import java.io.IOException;

import br.com.deveconnection.model.DAO.ClienteDAO;
import br.com.deveconnection.model.DAO.Conexao;
import br.com.deveconnection.model.DAO.JDBCClienteDAO;
import br.com.deveconnection.model.Entities.Cliente;
import br.com.deveconnection.model.Repository.ClienteRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

    

    
    Conexao conexao = Conexao.getInstance();
    

    private ClienteDAO clienteDAO = new JDBCClienteDAO(conexao);
    private ClienteRepository clienteRepository = new ClienteRepository(clienteDAO);

    

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;

    @FXML
    private TextField tfCidade;

    @FXML
    private TextField tfCnpj;


    @FXML
    private void cadastrar(){
        Cliente cliente = new Cliente(tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), tfSenha.getText(), tfCidade.getText(), tfCnpj.getText());

        clienteRepository.cadastrarCliente(cliente);

        System.out.println(cliente.getNome());

    
        
    }

    
    
}
