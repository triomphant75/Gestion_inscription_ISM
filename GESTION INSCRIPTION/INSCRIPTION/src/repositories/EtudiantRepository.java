package repositories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.Mysql;
import core.Roles;
import entities.Etudiant;
import entities.User;
public class EtudiantRepository extends Mysql implements IEtudiantRepository{
    private static final String SQL_INSERT="insert into user (nom_complet,tuteur,matricule,role) values(?,?,?,?)";
    private static final String SQL_SELECT_ALL="select * from user where role like ?";
    private static final String SQL_SELECT_BY_ID="select * from user where id=? and role like ? ";

    List <User>listerEtudiant=new ArrayList<>();
    @Override
    public User ajouterEtudiant(User etudiant) {

        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,etudiant.getNomComplet());
            ps.setString(2,((Etudiant) etudiant).getTuteur());
            ps.setString(3,((Etudiant) etudiant).getMatricule());
            ps.setString(4,(etudiant.getRole().name()));
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                etudiant.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

       this.fermetureConnexion();
        return etudiant;
    }

    @Override
    public List<User> listerEtudiant() {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_ALL);
            ps.setString(1,core.Roles.PROFESSEUR.name());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Etudiant user=new Etudiant(
                    rs.getInt("id"),
                    rs.getString("nom_complet"),
                    rs.getString("tuteur"),
                    rs.getString("matricule"));
                    listerEtudiant.add(user);
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return listerEtudiant;
    }

    @Override
    public Etudiant filterUnEtudiantParId(int id) {
        Etudiant user=null;
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1,id);
            ps.setString(2,Roles.ETUDIANT.name());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                 user=new Etudiant(
                    rs.getInt("id"),
                    rs.getString("nom_complet"),
                    rs.getString("tuteur"),
                    rs.getString("matricule"));
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return user;
    }

   
}
