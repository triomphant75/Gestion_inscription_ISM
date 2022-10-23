package services;
import java.util.List;

import entities.Classe;
import entities.User;


public interface IProfesseurService {
    public User insertProfesseur(User professeur);
    public List<User> selectAllProfesseurs();
    public User selectProfesseurByID(int id);
    public void affecterClasseProfesseur(User professeur, Classe classe );
    
}
