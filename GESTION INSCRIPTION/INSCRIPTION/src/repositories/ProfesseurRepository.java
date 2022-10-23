package repositories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.Mysql;
import core.Roles;
import entities.Classe;
import entities.Professeur;
import entities.User;
public class ProfesseurRepository extends Mysql implements IProfesseurRepository{
    private static final String SQL_INSERT="insert into user (nom_complet,grade,role) values(?,?,?)";
    private static final String SQL_SELECT_ALL="select * from user where role like ?";
    private static final String SQL_SELECT_BY_ID="select * from user where id=? and role like ? ";
    private static final String SQL_INSERT_AFFECTER="insert into professeur_classe (professeur_id,classe_id) values(?,?)";

    List <User>listerProfesseur=new ArrayList<>();
    @Override
    public User ajouterProfesseur(User professeur) {

        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,professeur.getNomComplet());
            ps.setString(2,((Professeur) professeur).getGrade());
            ps.setString(3,(professeur.getRole().name()));
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                professeur.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

       this.fermetureConnexion();
        return professeur;
    }

    @Override
    public List<User> listerProfesseur() {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_ALL);
            ps.setString(1,core.Roles.PROFESSEUR.name());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Professeur user=new Professeur(rs.getInt("id"),
                    rs.getString("nom_complet"),
                    rs.getString("grade"));
                    listerProfesseur.add(user);
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return listerProfesseur;
    }

    @Override
    public Professeur filterUnProfesseurParId(int id) {
        Professeur user=null;
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1,id);
            ps.setString(2,Roles.PROFESSEUR.name());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                 user=new Professeur(
                    rs.getInt("id"),
                    rs.getString("nom_complet"),
                    rs.getString("grade"));
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.fermetureConnexion();
        return user;
    }

    @Override
    public void affecterClasseProfesseur(User professeur, Classe classe) {
        this.ouvertureConnexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT_AFFECTER,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,professeur.getId());
            ps.setInt(2,classe.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

       this.fermetureConnexion();
    }

        
    }

   

