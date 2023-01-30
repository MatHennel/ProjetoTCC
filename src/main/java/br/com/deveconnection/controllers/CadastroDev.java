package br.com.deveconnection.controllers;

import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.repositories.DevRepository;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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





        

        Dev dev = new Dev(tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), tfSenha.getText(), tfCidade.getText(), tfCompetencias.getText(), datePicker.getValue(), tfEspecialidades.getText());

        devRepository.cadastrarDev(dev);

        

        

    
        
    }
}