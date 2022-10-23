package design_inscription.repositories;

import java.util.List;
import design_inscription.entities.User;

public interface IEtudiantRepository{
    public User ajouterEtudiant(User etudiant);
    public List<User> listerEtudiant();
    public User filterUnEtudiantParId(int id); 
    public User  filtrerEtudiantParNom(String nom);
}
