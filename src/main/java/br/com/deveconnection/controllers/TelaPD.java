package br.com.deveconnection.controllers;

import br.com.deveconnection.model.entities.Dev;
import br.com.deveconnection.utils.Navigator.BaseAppNavigator;

public class TelaPD {
    static private Dev dev;


    

    
    
    

    public static void setDev(Dev dev) {
        TelaPD.dev = dev;
    }

    public void login() {
        PerfilDev.setDev(dev);
        BaseAppNavigator.pushScreen("PD");
        

    }

   
}
