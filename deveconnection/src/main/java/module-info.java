module br.com.deveconnection {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.deveconnection to javafx.fxml;
    exports br.com.deveconnection;
}
