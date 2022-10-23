package design_inscription.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import design_inscription.core.Mysql;
import design_inscription.core.Roles;
import design_inscription.entities.User;

public class UserRepository extends Mysql implements IUserRepository {
    private final String SQL_CONNECT="SELECT * FROM  user  WHERE login LIKE ? AND password LIKE ?";
    
    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        User admin=null;
        

        this.ouvertureConnexion();
        
        try {
              ps= conn.prepareStatement(SQL_CONNECT) ;
              ps.setString(1, login); 
              ps.setString(2, password); 
              ResultSet rs=ps.executeQuery();
            if(rs.next()){
                admin=new User(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password") ,
                    rs.getString("nom_complet"),
                    rs.getString("role").compareTo("RP")==0? Roles.RP:Roles.AC);
}

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.fermetureConnexion();
        return admin;
    
    }
    
}
