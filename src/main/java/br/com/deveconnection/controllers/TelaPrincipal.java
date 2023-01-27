package br.com.deveconnection.controllers;



import br.com.deveconnection.App;
import br.com.deveconnection.utils.Navigator.BorderPaneRegion;
import javafx.fxml.FXML;

public class TelaPrincipal extends BaseController {
    

    @FXML
    private void carregarClientes(){
        App.changeScreenRegion("CLIENTES", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregarProdutos(){
        App.changeScreenRegion("PRODUTOS", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregarVendas(){
        App.changeScreenRegion("VENDAS", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregarNovaVenda(){
        App.changeScreenRegion("NOVAVENDA", BorderPaneRegion.CENTER);
    }



}
