package design_inscription.services;
import java.util.List;

import design_inscription.entities.Classe;
import design_inscription.entities.User;


public interface IProfesseurService {
    public User insertProfesseur(User professeur);
    public List<User> selectAllProfesseurs();
    public User selectProfesseurByID(int id);
    public void affecterClasseProfesseur(User professeur, Classe classe );
    
}
