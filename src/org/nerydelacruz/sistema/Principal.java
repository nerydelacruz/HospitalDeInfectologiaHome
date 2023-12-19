package org.nerydelacruz.sistema;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.nerydelacruz.controller.MedicoController;
import org.nerydelacruz.controller.MenuPrincipalController;

import java.io.InputStream;

public class Principal extends Application {
    private  final String PAQUETE_VISTA = "/org/nerydelacruz/view/";

    public Stage getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    private Stage escenarioPrincipal;
    private Scene escena;
    public void start(Stage escenarioPrincipal){
        this.escenarioPrincipal = escenarioPrincipal;
        escenarioPrincipal.setTitle("Hospital de Infectologia");
        escenarioPrincipal.initStyle(StageStyle.UNDECORATED);
        menuPrincipal();
        escenarioPrincipal.show();
    }

    public void menuPrincipal(){
        try{
            MenuPrincipalController menuPrincipal = (MenuPrincipalController) cambiarEscena("MenuPrincipalView.fxml",600,412);
            menuPrincipal.setEscenarioPrincipal(this);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void ventanaMedicos(){
        try{
            MedicoController medicoController = (MedicoController)cambiarEscena("MedicoView.fxml",776,502);
            medicoController.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Initializable cambiarEscena(String fxml,int ancho,int alto) throws Exception{
        Initializable resultado = null;
        FXMLLoader cargadorFXML = new FXMLLoader();
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VISTA+fxml);
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VISTA+fxml));
        escena = new Scene((AnchorPane)cargadorFXML.load(archivo),ancho,alto);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        resultado = (Initializable) cargadorFXML.getController();
        return resultado;
    }
    public static void main(String[]args){
        launch(args);
    }

}
