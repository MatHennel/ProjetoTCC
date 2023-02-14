package br.com.deveconnection.controllers;

import br.com.deveconnection.utils.Navigator.BaseAppNavigator;
import javafx.fxml.FXML;

public class PerfilCliente {
    @FXML
    public void sair(){
        BaseAppNavigator.popScreen();
        BaseAppNavigator.popScreen();

    }

    @FXML
    public void voltar(){
        BaseAppNavigator.popScreen();

    }
}
