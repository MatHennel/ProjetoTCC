package br.com.deveconnection.controllers;

import br.com.deveconnection.model.entities.Dev;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TelaListaDev {



    @FXML
    private TableColumn<Dev, String> TvCidade;

    @FXML
    private TableColumn<Dev,String> TvCompetencias;

    @FXML
    private TableColumn<Dev,String> TvNome;

    @FXML
    private TableColumn<Dev, String> TvTelefone;

    

}

