package br.com.deveconnection.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.model.repositories.ClienteRepository;
import br.com.deveconnection.utils.Navigator.BaseAppNavigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaListaDev implements Initializable{

    ClienteRepository cRepository;

    public TelaListaDev(ClienteRepository cRepository) {
        this.cRepository = cRepository;
    }

    @FXML
    private TableColumn<Dev, String> TvCidade;

    @FXML
    private TableColumn<Dev,String> TvCompetencias;

    @FXML
    private TableColumn<Dev,String> TvNome;

    @FXML
    private TableColumn<Dev, String> TvTelefone;

    @FXML
    private TableView tv;

    private List<Dev> lista = new ArrayList<>();

    private ObservableList<Dev> listaObservavel;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        carregaTableView();


        
    }

    public void carregaTableView(){
        lista = cRepository.visualizarDevsDisponiveisParaTrabalho();
        TvCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        TvCompetencias.setCellValueFactory(new PropertyValueFactory<>("competenciasDev"));
        TvNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TvTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        listaObservavel = FXCollections.observableArrayList(lista);

        tv.setItems(listaObservavel);

        

    }

    public void voltar(){
        BaseAppNavigator.popScreen();
    }


}

