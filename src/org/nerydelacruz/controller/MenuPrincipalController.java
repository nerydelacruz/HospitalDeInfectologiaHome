package org.nerydelacruz.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import org.nerydelacruz.sistema.Principal;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuPrincipalController implements Initializable {
    private Principal escenarioPrincipal;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public void ventanaMedicos(){
        escenarioPrincipal.ventanaMedicos();
    }

    @FXML
    public void minimizarAplicacion(){
        escenarioPrincipal.getEscenarioPrincipal().setIconified(true);
    }

    @FXML
    public void cerrarAplicacion(MouseEvent event){
        escenarioPrincipal.getEscenarioPrincipal().close();
    }
    @FXML
    public void maximizarAplicacion(){
        if(escenarioPrincipal.getEscenarioPrincipal().isMaximized()){
            escenarioPrincipal.getEscenarioPrincipal().setMaximized(false);
        }else{
            escenarioPrincipal.getEscenarioPrincipal().setMaximized(true);
        }
    }
}
