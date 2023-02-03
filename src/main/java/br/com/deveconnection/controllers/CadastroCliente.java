package br.com.deveconnection.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.deveconnection.model.entities.Cliente;
import br.com.deveconnection.model.repositories.ClienteRepository;
import br.com.deveconnection.model.results.Result;
import br.com.deveconnection.utils.Navigator.BaseAppNavigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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

        String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  

        Pattern pattern = Pattern.compile(regx);

        Alert a = new Alert(Alert.AlertType.NONE);

        Result erro = Result.fail(null);

        String email = tfEmail.getText();

        Matcher matcher = pattern.matcher(email);

        if(matcher.matches() && email.indexOf('.') > 0){
            Cliente cliente = new Cliente(tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), tfSenha.getText(), tfCidade.getText(), tfCnpj.getText());
            erro = clienteRepository.cadastrarCliente(cliente);
        }
        else{
            erro = Result.fail("Email inválido");
            a.setAlertType(AlertType.ERROR);
            a.setHeaderText(erro.getMsg());
            a.show();
        }

        





        

        




        if(erro.getClass().getTypeName().equals("br.com.deveconnection.model.results.FailResult")){
            a.setAlertType(Alert.AlertType.ERROR);
            a.setHeaderText(erro.getMsg());
            a.show();
        }else{
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setHeaderText(erro.getMsg());
            a.showAndWait();
            
            BaseAppNavigator.popScreen();  
            BaseAppNavigator.pushScreen("LOGIN");


        }

    
        
    }


    public void voltar() {
        BaseAppNavigator.popScreen();
    }
}
