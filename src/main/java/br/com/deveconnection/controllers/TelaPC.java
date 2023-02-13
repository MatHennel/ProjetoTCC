package br.com.deveconnection.controllers;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.deveconnection.model.entities.Cliente;
import br.com.deveconnection.utils.Navigator.BaseAppNavigator;



public class TelaPC {

    static private Cliente cliente;

    

    public static void setCliente(Cliente cliente) {
        TelaPC.cliente = cliente;
    }

    public void login() {
        BaseAppNavigator.pushScreen("PC");
        

    }

    public void listarDev(){
        BaseAppNavigator.pushScreen("LOGINCLIENTE");
    }

    
}
