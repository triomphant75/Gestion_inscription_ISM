package repositories;

import java.util.List;
import entities.User;

public interface IEtudiantRepository{
    public User ajouterEtudiant(User etudiant);
    public List<User> listerEtudiant();
    public User filterUnEtudiantParId(int id);   
}
