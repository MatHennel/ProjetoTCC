package br.com.deveconnection.controllers;

import br.com.deveconnection.model.entities.Cliente;
import br.com.deveconnection.model.repositories.ClienteRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastroCliente {

    private ClienteRepository clienteRepository;


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


    public CadastroCliente(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @FXML
    private void cadastrar(){
        Cliente cliente = new Cliente(tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), tfSenha.getText(), tfCidade.getText(), tfCnpj.getText());

        
        clienteRepository.cadastrarCliente(cliente);

        System.out.println(cliente.getNome());

    
        
    }

    
    
}
