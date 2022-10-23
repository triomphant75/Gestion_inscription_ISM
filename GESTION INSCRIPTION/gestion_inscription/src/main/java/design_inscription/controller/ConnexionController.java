package design_inscription.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import design_inscription.App;
import design_inscription.core.Fabrique;
import design_inscription.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConnexionController implements Initializable{

    @FXML
    Text id_error;

    @FXML
    TextField id_login;
    
    @FXML
    PasswordField id_password;

    public static User useradmins;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id_error.setVisible(false);
    }

    public void boutonConnexion() throws IOException{
        String login =id_login.getText().trim(); 
        String password =id_password.getText().trim();
        // lblError.setVisible(true);

        useradmins=Fabrique.getUserService().Connexion_user_admin(login, password);

        if(useradmins==null){
            id_error.setVisible(true);  
        }else{
            id_error.setVisible(false);
            App.setRoot("Accueil");

        
        }
        

    }
}
