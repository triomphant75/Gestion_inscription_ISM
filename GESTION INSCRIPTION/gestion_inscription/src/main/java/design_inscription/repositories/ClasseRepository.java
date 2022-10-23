package design_inscription.repositories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import design_inscription.core.Mysql;
import design_inscription.entities.Classe;

public class ClasseRepository extends Mysql implements IClasseRepository{

    //creer une classe
    //1--sql

    private static final String SQL_INSERT="insert into classe(niveau,filiere,libelle) values(?,?,?)";  
    private static final String SQL_SELECT="select * from classe";
    private static final String SQL_SELECT_BY_ID="select * from classe where id=? ";
    private static final String SQL_FILTERPROFCLASSE="select c.* from classe c,professeur_classe cp  where c.id=cp.classe_id and cp.professeur_id=?";

    @Override
    public Classe ajouterUneClasse(Classe classe) {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,classe.getNiveau());
            ps.setString(2,classe.getFiliere());
            ps.setString(3,classe.getLibelle());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                classe.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

       this.fermetureConnexion();
        return classe;
    }
    //la select

    List<Classe> listeClasse=new ArrayList<>();
    @Override
    public List<Classe> listerClasses() {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Classe classe=new Classe(rs.getInt("id"), 
                rs.getString("niveau"),
                rs.getString("filiere"),
                rs.getString("libelle"));
                listeClasse.add(classe);
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return listeClasse;
    }
    @Override
    public Classe filtrerUneClasseParId(int id) {
        Classe classe=null;
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                classe=new Classe(rs.getInt("id"), 
                rs.getString("niveau"),
                rs.getString("filiere"),
                rs.getString("libelle"));
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return classe;
    }


    @Override
    public List<Classe> filtrerUneClasseProf(int id) {
        List<Classe>  listclasse=new ArrayList<>();
            this.ouvertureConnexion();
        try {
              ps= conn.prepareStatement(SQL_FILTERPROFCLASSE) ;
              ps.setInt(1, id); 
              
              
              ResultSet rs=ps.executeQuery();
              Classe classe;
              while(rs.next()){

                
                    classe=new Classe(rs.getInt("id"),rs.getString("niveau"),rs.getString("filiere"),rs.getString("libelle"));

                    listclasse.add(classe);
                       
                }


       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }

       this.fermetureConnexion();
       return listclasse;
       
   }
   IProfesseurRepository professeurRepository;
      //Injection de Dependance
      public ClasseRepository(IProfesseurRepository professeurRepository) {
          this.professeurRepository = professeurRepository;
      }
        
    }

 
    //java.sql.Connection 
