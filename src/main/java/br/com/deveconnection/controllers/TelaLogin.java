package br.com.deveconnection.controllers;

import br.com.deveconnection.model.entities.Cliente;
import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.entities.Usuario;
import br.com.deveconnection.model.repositories.ClienteRepository;
import br.com.deveconnection.model.repositories.DevRepository;
import br.com.deveconnection.utils.Navigator.BaseAppNavigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class TelaLogin {

    private ClienteRepository cliente;
    private DevRepository dev;
    private Cliente clienteR;
    private Dev devR;

  

    

    @FXML
    private TextField tfEmail;

   

    @FXML
    private PasswordField pfSenha;

    
    


    public TelaLogin(ClienteRepository cliente, DevRepository dev) {
        this.cliente = cliente;
        this.dev = dev;
    }

    public void entrar() {

        
       

        Alert a = new Alert(Alert.AlertType.NONE);

        clienteR = cliente.loginCliente(tfEmail.getText(),pfSenha.getText());

        devR = dev.loginDev(tfEmail.getText(), pfSenha.getText());

        

        if(clienteR != null){
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setHeaderText("LOGADO");
            a.showAndWait();
            BaseAppNavigator.popScreen();
            BaseAppNavigator.pushScreen("TELAPC");
            TelaPC.setCliente(clienteR);
            
        }else if(devR != null){
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setHeaderText("LOGADO");
            a.showAndWait();
            BaseAppNavigator.popScreen();
            BaseAppNavigator.pushScreen("TELAPD");
            TelaPD.setDev(devR);


            
        }
        else{
            a.setAlertType(Alert.AlertType.ERROR);
            a.setHeaderText("ERRO AO LOGAR");
            a.showAndWait();
        }

    }

    public void voltar() {
        BaseAppNavigator.popScreen();
    }

    

    

    

    
}
