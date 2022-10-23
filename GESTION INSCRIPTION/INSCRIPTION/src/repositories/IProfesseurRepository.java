package repositories;

import java.util.List;

import entities.Classe;
import entities.User;

public interface IProfesseurRepository {
    public User ajouterProfesseur(User professeur);
    public List<User> listerProfesseur();
    public User filterUnProfesseurParId(int id);  
    public void affecterClasseProfesseur(User professeur, Classe classe); 
}
