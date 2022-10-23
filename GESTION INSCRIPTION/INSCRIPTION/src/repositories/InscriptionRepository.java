package repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.Mysql;
import entities.Inscription;

public class InscriptionRepository extends Mysql implements IinscriptionRepository{

    private final String  SQL_INSERT_INS="insert into inscription(DateInscription,classe_id,user_id) values(?,?,?)";
   

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
        
        }catch (SQLException e) {
            
                e.printStackTrace();
            }
       
       this.fermetureConnexion();
        return inscription;
    }
    
}
