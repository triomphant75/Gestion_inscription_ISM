package design_inscription.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import design_inscription.App;
import design_inscription.core.Fabrique;
import design_inscription.entities.Classe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClasseController implements Initializable{
    public void boutonRetour() throws IOException{App.setRoot("Accueil");}
    @FXML
    TableView<Classe> tb_view=new TableView<>();
   
   
    @FXML 
    TableColumn<Classe,Integer> tb_id=new TableColumn<>();
    
    @FXML
    TableColumn<Classe,String> tb_libelle=new TableColumn<>();

    @FXML
    TextField id_niveau, id_filiere ;

    // tableview ne prend pas d'objet de types listes===>mais de type ObservableList
    private  ObservableList obClasses=FXCollections.observableList(Fabrique.getClasseService().selectAllClasses());


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tb_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tb_libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
 
        tb_view.setItems(obClasses);
        
    }
    public void insert(){
        String niveau=id_niveau.getText().trim();
        String filiere=id_filiere.getText().trim();
        Classe classe = Fabrique.getClasseService().insertClasse(new Classe(niveau,filiere));
        
        
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion ISM(inscription)");
        alert.setContentText("la classe a ete cree avec succes");
        alert.show();
        obClasses.add(classe);
        id_niveau.clear();
        id_filiere.clear();
    }
    
}

    
