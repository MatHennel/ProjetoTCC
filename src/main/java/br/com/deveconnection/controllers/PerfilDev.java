package br.com.deveconnection.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.repositories.DevRepository;
import br.com.deveconnection.utils.Navigator.BaseAppNavigator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PerfilDev implements Initializable{

    private DevRepository devR;

    static private Dev dev;

    @FXML
    private Button inativarButton;

    
    public static void setDev(Dev dev) {
        PerfilDev.dev = dev;
    }

    private Boolean inativar;

    

    
    

    public PerfilDev(DevRepository devR) {
        this.devR = devR;
    }

    

    @FXML
    public void sair(){
        BaseAppNavigator.popScreen();
        BaseAppNavigator.popScreen();

    }

    @FXML
    public void inativar(){
        
        if(inativar == true){
            devR.inativar(false,dev.getIdDev());
            inativar = false;
            dev.alternarStatusPerfil(false);
            inativarButton.setText("ATIVAR");
        }else{
            devR.inativar(true,dev.getIdDev());
            inativar = true;

            dev.alternarStatusPerfil(true);

            inativarButton.setText("DESATIVAR");

        }
    }

    @FXML
    public void voltar(){
        BaseAppNavigator.popScreen();

    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        inativar = dev.getStatus();
       
        if(inativar){
           
            inativarButton.setText("DESATIVAR");
        }else{
            
            inativarButton.setText("ATIVAR");

        }
        
    }



    
}
