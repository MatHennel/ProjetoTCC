package br.com.deveconnection.controllers;

import br.com.deveconnection.model.entities.Cliente;
import br.com.deveconnection.model.repositories.ClienteRepository;
import br.com.deveconnection.model.results.Result;
import br.com.deveconnection.utils.Navigator.BaseAppNavigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

        Alert a = new Alert(Alert.AlertType.NONE);

        Boolean erro;

        Cliente cliente = new Cliente(tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), tfSenha.getText(), tfCidade.getText(), tfCnpj.getText());



        erro = clienteRepository.cadastrarCliente(cliente);



        if(!erro){
            a.setAlertType(Alert.AlertType.ERROR);
            a.setHeaderText("Erro ao cadastrar");
            a.show();
        }else{
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setHeaderText("Sucesso ao cadastrar");
            a.showAndWait();
            
            BaseAppNavigator.popScreen();  
            BaseAppNavigator.pushScreen("LOGIN");


        }

    
        
    }


    public void voltar() {
        BaseAppNavigator.popScreen();
    }
}
