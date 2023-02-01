package br.com.deveconnection.controllers;

import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.repositories.DevRepository;
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

        Boolean erro;

        Alert a = new Alert(Alert.AlertType.NONE);




        

        Dev dev = new Dev(tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), tfSenha.getText(), tfCidade.getText(), tfCompetencias.getText(), datePicker.getValue(), tfEspecialidades.getText());

        erro = devRepository.cadastrarDev(dev);

        if(!erro){
            a.setAlertType(AlertType.ERROR);
            a.setHeaderText("Erro ao cadastrar");
            a.show();
        }else{
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setHeaderText("Sucesso ao cadastrar");
            a.showAndWait();
            
            BaseAppNavigator.popScreen();
        }

        

    
        
    }

    public void voltar() {
        BaseAppNavigator.popScreen();
    }
}