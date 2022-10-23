package design_inscription.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import design_inscription.App;
import design_inscription.core.Fabrique;
import design_inscription.entities.Classe;
import design_inscription.entities.Professeur;
import design_inscription.entities.User;
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
import javafx.scene.layout.Pane;

public class ProfesseurController implements Initializable{

    public void buttonreturn() throws IOException{App.setRoot("Accueil");}
    

   
    

    @FXML
    TableView<User> tb_view=new TableView<>();
    @FXML
    TableView<Classe> tb_vu=new TableView<>();
    
    @FXML 
    TableColumn<User,Integer> id_list=new TableColumn<>();
    
    @FXML
    TableColumn<User,String> id_nomcomplet=new TableColumn<>();
    @FXML
    TableColumn<Classe,Integer> id_cp=new TableColumn<>();

    @FXML
    TableColumn<Classe,String> id_lib=new TableColumn<>();

    @FXML
    TableColumn<User,String> id_grad=new TableColumn<>();

    @FXML
    TextField id_nom, id_grade ;
    @FXML
    TextField affectclasse_recup,affectprof_recup,affectclasse_id,affectprof_id;

    @FXML
    Pane pane_prof,pane_classe;

    // tableview ne prend pas d'objet de types listes===>mais de type ObservableList
    private  ObservableList obClasses=FXCollections.observableList(Fabrique.getProfesseurService().selectAllProfesseurs());


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id_list.setCellValueFactory(new PropertyValueFactory<>("id"));
        id_nomcomplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        id_grad.setCellValueFactory(new PropertyValueFactory<>("grade"));
        tb_view.setItems(obClasses);
        
    }
    public void insert(){
        String nomcomplet=id_nom.getText().trim();
        String grade=id_grade.getText().trim();
        User professeur = Fabrique.getProfesseurService().insertProfesseur(new Professeur(nomcomplet,grade));
        
        
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion ISM(Professeur)");
        alert.setContentText("le professeur  a ete ajoute avec succes");
        alert.show();
        obClasses.add(professeur);
        id_nom.clear();
        id_grade.clear();
    }
    public void rechercherClasse(){
        // convertion id
    String classe_id=affectclasse_id.getText().trim();
    int resultatclasseid = Integer.parseInt(classe_id);
    Classe cl =Fabrique.getClasseService().selectClasseByID(resultatclasseid);

   if(cl!=null){
      pane_classe.setDisable(true);
      affectclasse_recup.setText(cl.getLibelle());
   }else{
    pane_classe.setDisable(false);
      Alert alert=new Alert(AlertType.INFORMATION);
      alert.setTitle("Gestion Professeur(java connect )");
      alert.setContentText("secretaire tu cherches quel id comme ça c'est invalide");
      alert.show();
   }

    }
    public void rechercherProf(){
        
   // convertion id
   String id=affectprof_id.getText().trim();
   int resultatid = Integer.parseInt(id);
   User prof =Fabrique.getProfesseurService().selectProfesseurByID(resultatid);

   if(prof!=null){
     filtrerclasseProf(resultatid);
     pane_prof.setDisable(true);
     affectprof_recup.setText(prof.getNomComplet());
   }else{
     pane_prof.setDisable(false);
     Alert alert=new Alert(AlertType.INFORMATION);
     alert.setTitle("Gestion Professeur(javaConnect)");
     alert.setContentText("secretaire tu cherches quel id comme ça c'est invalide");
     alert.show();
   }

    }
    public void affecterprofClasse(){
        String classe_id =affectclasse_id.getText().trim();
        String prof_id =affectprof_id.getText().trim();
    
        // convertion id
        int resultatclasseid = Integer.parseInt(classe_id);
        // convertion id
        int resultatprofid = Integer.parseInt(prof_id);
        User prof=Fabrique.getProfesseurService().selectProfesseurByID(resultatprofid);
        Classe classe=Fabrique.getClasseService().selectClasseByID(resultatclasseid);
        Fabrique.getProfesseurService().affecterClasseProfesseur(prof,classe);
    
    
         Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion Baila(Prince de gloire javaConnect)");
        alert.setContentText("la classe "+classe_id+" a ete affecte au prof "+prof_id);
        alert.show();
        
        affectclasse_id.clear();
        affectprof_id.clear();

}

    public void filtrerclasseProf(int id){
        ObservableList obClasses=FXCollections.observableList(Fabrique.getClasseService().selectAllClasses());
        id_cp.setCellValueFactory(new PropertyValueFactory<>("id"));
        id_lib.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tb_vu.setItems(obClasses);
    }
}


    

