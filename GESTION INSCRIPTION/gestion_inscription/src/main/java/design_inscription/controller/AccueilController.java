package design_inscription.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import design_inscription.App;
import design_inscription.core.Roles;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AccueilController implements Initializable{

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            if(ConnexionController.useradmins.getRole()==Roles.RP) {
                isRP();
          }else{
            isAC();
          }

        } catch (Exception e) {
            // TODO: handle exception
        }
        
        
    }
    

    public void boutonClasse() throws IOException{
        App.setRoot("Classe");
    }
    public void buttonInscription() throws IOException{
        App.setRoot("Etudiant");
    }
    
    public void button_professeur() throws IOException{
        App.setRoot("Professeur");
    }
    public void deconnect() throws IOException{
        App.setRoot("Connexion");
    }


    @FXML
    private Button ac_boutton;

    @FXML
    private Button deconnexion;

    @FXML
    private Button rp_boutton1;

    @FXML
    private Button rp_boutton2;


    ///Autorisation 

    public void isRP(){
        rp_boutton1.setDisable(false);
        rp_boutton2.setDisable(false);
       
    }
    public void isAC(){
        ac_boutton.setDisable(false);
       
        


    }
   
    
}