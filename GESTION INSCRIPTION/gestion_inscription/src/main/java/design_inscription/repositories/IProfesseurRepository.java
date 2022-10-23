package design_inscription.repositories;

import java.util.List;

import design_inscription.entities.Classe;
import design_inscription.entities.User;

public interface IProfesseurRepository {
    public User ajouterProfesseur(User professeur);
    public List<User> listerProfesseur();
    public User filterUnProfesseurParId(int id);  
    public void affecterClasseProfesseur(User professeur, Classe classe); 
}
