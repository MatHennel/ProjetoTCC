package br.com.deveconnection;

import java.io.IOException;

import br.com.deveconnection.model.DAO.ClienteDAO;
import br.com.deveconnection.model.DAO.Conexao;
import br.com.deveconnection.model.DAO.DevDAO;
import br.com.deveconnection.model.DAO.JDBCClienteDAO;
import br.com.deveconnection.model.DAO.JDBCDevDAO;
import br.com.deveconnection.model.Entities.Dev;
import br.com.deveconnection.model.Repository.ClienteRepository;
import br.com.deveconnection.model.Repository.DevRepository;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class SecondaryController {

    Conexao conexao = Conexao.getInstance();
    

    private DevDAO devDAO = new JDBCDevDAO(conexao);
    private DevRepository devRepository = new DevRepository(devDAO);

    

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

        

        Dev dev = new Dev(tfNome.getText(), tfTelefone.getText(), tfEmail.getText(), tfSenha.getText(), tfCidade.getText(), tfCompetencias.getText(), null, tfEspecialidades.getText());

        devRepository.cadastrarDev(dev);

        

        

    
        
    }
}