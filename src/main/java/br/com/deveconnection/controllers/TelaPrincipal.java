package br.com.deveconnection.controllers;



import br.com.deveconnection.App;
import br.com.deveconnection.utils.Navigator.BaseAppNavigator;
import br.com.deveconnection.utils.Navigator.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaPrincipal{


    public void cadastroCliente() {
        BaseAppNavigator.pushScreen("CLIENTE");
    }

    public void cadastroDev() {
        BaseAppNavigator.pushScreen("DEV");
    }

    public void login() {
        BaseAppNavigator.pushScreen("LOGIN");
    }
}
