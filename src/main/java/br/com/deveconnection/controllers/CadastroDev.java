package br.com.deveconnection.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.repositories.DevRepository;
import br.com.deveconnection.model.results.Result;
import br.com.deveconnection.utils.Navigator.BaseAppNavigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroDev {

    private DevRepository devRepository;
    

    public CadastroDev(DevRepository devRepository) {
        this.devRepository = devRepository;
    }


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
    private TextField tfEspecialidades;

    @FXML
    private TextField tfCompetencias;

    @FXML
    private DatePicker datePicker;


    @FXML
    private void cadastrar(){

        String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  

        Pattern pattern = Pattern.compile(regx);

        Alert a = new Alert(Alert.AlertType.NONE);

        Result erro = Result.fail(null);

        String email = tfEmail.getText();

        Matcher matcher = pattern.matcher(email);

        if(matcher.matches() && email.indexOf('.') > 0){
            Dev dev = new Dev(tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), tfSenha.getText(), tfCidade.getText(), tfCompetencias.getText(), datePicker.getValue(), tfEspecialidades.getText());

            erro = devRepository.cadastrarDev(dev);
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