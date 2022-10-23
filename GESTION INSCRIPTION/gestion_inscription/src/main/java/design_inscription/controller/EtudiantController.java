package design_inscription.controller;

import design_inscription.entities.User;
import design_inscription.core.Fabrique;
import design_inscription.entities.Classe;
import design_inscription.entities.Etudiant;
import design_inscription.entities.Inscription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class EtudiantController {

    @FXML
     TextField txtaffect;

    @FXML
     TextField txtclasse;

    @FXML
     TextField txtdateinscription;

    @FXML
    TextField txtidetudiantIns;

    // @FXML
    // TextField txtmatricule;

    @FXML
    TextField txtnomcomplet;

    @FXML
    TextField txttuteur;


    // Partie de l'inscription lister
    @FXML
    TableView<User> tbinsAn;

 

    @FXML
    private TableColumn<User, Integer> tcidAn;

    @FXML
    private TableColumn<User, String> tcmatricule;

    @FXML
    private TableColumn<User, String> tcnomAn;

    @FXML
    private TableColumn<User, String> tctuteur;  


    public void insertEtudiant(){
        String nometud=txtnomcomplet.getText().trim();
        String nomtuteur=txttuteur.getText().trim();
        // String matricule=txtmatricule.getText().trim();
        User etudiant= Fabrique.getEtudiantService().ajouterEtudiant(new Etudiant(nometud,nomtuteur));

        buttoninscription();
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion ISM(etudiant)");
        alert.setContentText("etudiant  a ete inscrit avec succes");
        alert.show();
        // obprof.add(professeur);
        txtnomcomplet.clear();
        txttuteur.clear();
        // txtmatricule.clear();
    }



    // Inscription ajout
    public void buttoninscription(){
        String date=txtdateinscription.getText().trim();
        String classe_id =txtclasse.getText().trim();
        String nometud=txtnomcomplet.getText().trim();

        User et =Fabrique.getEtudiantService().filterUnEtudiantParNom(nometud);
        if(et!=null){
           int recup=et.getId();
           User etudiant=Fabrique.getEtudiantService().filterUnEtudiantParId(recup);
        //    String etud_id =txtidetudiantIns.getText().trim();
        // convertion id
        int resultatclasseid = Integer.parseInt(classe_id);
        // plus besoin
        // int resultatetudiantid = Integer.parseInt(etud_id);
        Classe classe=Fabrique.getClasseService().selectClasseByID(resultatclasseid);
        Inscription inscriptions=new Inscription(date,classe,etudiant);
        // Inscription  inscriptionsAvecId=Fabrique.getInscriptionService().InsertEtudiant(inscriptions);
        }
    }






    @FXML
    TextField anText;

    
   ObservableList obsListInscrit;

    public void test(){
    String recupan=anText.getText().trim();

        
    //Conversion List-> ObservableList
    //    obsListInscrit=FXCollections.observableList(Fabrique.getEtudiantService().filtreAn(recupan));
       
       tcidAn.setCellValueFactory(new PropertyValueFactory<>("id"));
       tcmatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));

       tcnomAn.setCellValueFactory(new PropertyValueFactory<>("nomcomplet"));
       tctuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));

    
    // tcnomAn.setCellValueFactory(new PropertyValueFactory<>("classe_id"));

    //    tcClasseAn.setCellValueFactory(new PropertyValueFactory<>("user_id"));

       tbinsAn.setItems(obsListInscrit);

    }


    @FXML
    TextField anText1,txtclasse1;
    @FXML
    private TableColumn<User, Integer> t1;

    @FXML
    private TableColumn<User,String> t2;

    @FXML
    private TableColumn<User,String> t3;

    @FXML
    private TableColumn<User,String> t4;

    @FXML
    private TableView<User> tb1;

    public void classeAn(){

        // String recupan=anText1.getText().trim();

        
        String recup1=txtclasse1.getText().trim();

        int idclasse=Integer.parseInt(recup1);


        String recup2=anText1.getText().trim();
        


        
        //Conversion List-> ObservableList
        //    obsListInscrit=FXCollections.observableList(Fabrique.getEtudiantService().filtreAnClasse(recup2,idclasse));
           
        //    t1.setCellValueFactory(new PropertyValueFactory<>("id"));
        //    t2.setCellValueFactory(new PropertyValueFactory<>("matricule"));
    
        //    t4.setCellValueFactory(new PropertyValueFactory<>("nomcomplet"));
        //    t3.setCellValueFactory(new PropertyValueFactory<>("tuteur"));

        //    tb1.setItems(obsListInscrit);

        
    }



    
}
