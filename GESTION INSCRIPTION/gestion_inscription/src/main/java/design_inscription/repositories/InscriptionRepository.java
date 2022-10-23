package design_inscription.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import design_inscription.core.Mysql;
import design_inscription.entities.Etudiant;
import design_inscription.entities.Inscription;
import design_inscription.entities.User;



public class InscriptionRepository extends Mysql implements IinscriptionRepository{
    
    private final String  SQL_INSERT_INS="insert into inscription(DateInscription,classe_id,user_id) values(?,?,?)";

    // private final String SQL_INSCR_ANNEE= "SELECT * FROM inscription` WHERE `date_inscription` LIKE ?";

    private final String SQL_INSCR_ANNEE="select e.* from user e,inscription i  where e.id=i.user_id and i.DateInscription=?";


    private final String SQL_INSCR_AN_CLASSE="select e.* from user e,inscription i  where e.id=i.user_id and i.DateInscription=? and i.classe_id=?";


    IEtudiantRepository etudiantRepository=new EtudiantRepository();
    IProfesseurRepository professeurRepository=new ProfesseurRepository();
    IClasseRepository classeRepository=new ClasseRepository(professeurRepository);
   

    @Override
    public Inscription inscrireEtudiant(Inscription inscription) {
       
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT_INS,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,inscription.getDateinscription());
            ps.setInt(2,inscription.getClasse().getId());
            ps.setInt(3, inscription.getEtudiant().getId());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
        //     if(rs.next()){
        //         inscription.setId(rs.getInt(1));
        //     }
        // // System.out.println("ajout top");
        
        }catch (SQLException e) {
            
                e.printStackTrace();
            }
       
       this.fermetureConnexion();
        return inscription;
    }


    @Override
    public List<User> listerEtudiantInscrit(String annee) {
        List<User>  listetudiant=new ArrayList<>();
            this.ouvertureConnexion();
        try {
              ps= conn.prepareStatement(SQL_INSCR_ANNEE) ;
              ps.setString(1, annee); 
              
              
              ResultSet rs=ps.executeQuery();
              
              while(rs.next()){

                
                
                User etudiants  =new Etudiant
                (rs.getInt("id"),
                rs.getString("nom_complet"),
                rs.getString("tuteur"),
                rs.getString("matricule"));


                listetudiant.add(etudiants);
                       
                 }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.fermetureConnexion();
        return listetudiant;
    }


    @Override
    public List<User> listerEtudiantInscritAN_Classe(String annee, int id) {
        List<User>  listetudiantclasse=new ArrayList<>();
            this.ouvertureConnexion();
        try {
              ps= conn.prepareStatement(SQL_INSCR_AN_CLASSE) ;
              ps.setString(1, annee); 

              ps.setInt(2, id); 
              
              
              ResultSet rs=ps.executeQuery();
              
              while(rs.next()){

                
                
                User etudiants  =new Etudiant
                (rs.getInt("id"),
                rs.getString("nom_complet"),
                rs.getString("tuteur"),
                rs.getString("matricule"));


                listetudiantclasse.add(etudiants);
                       
                 }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.fermetureConnexion();
        return listetudiantclasse;
    }

    }


    // @Override
    // public List<Inscription> listerEtudiantInscrit(String a) {

    //     List<Inscription> inscriptionAn = new ArrayList<>();

    //     this.ouvertureConnexion();
    //     try {
            
    //        ps = conn.prepareStatement(SQL_INSCR_ANNEE);
    //        ps.setString(1, a+"%");
    //        ResultSet rs = ps.executeQuery();

    //        while(rs.next()){

    //         Inscription inscription = new Inscription(rs.getInt("id"),
    //         rs.getString("date_inscription"),

    //        classeRepository.rechercherClassebyid(rs.getInt("classe_id")),

    //        etudiantRepository.filterEtudiantParId(rs.getInt("user_id"))
    //        );

    //            inscriptionAn.add(inscription);
    //    }
    //     } catch (SQLException e) {
    //     e.printStackTrace();
    //     }

    //         this.fermetureConnexion();
    //     return inscriptionAn;
        
    // }
    

