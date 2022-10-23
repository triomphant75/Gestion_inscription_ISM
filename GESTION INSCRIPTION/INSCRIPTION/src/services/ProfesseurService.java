package services;

import java.util.List;

import entities.Classe;
import entities.User;
import repositories.IProfesseurRepository;


public class ProfesseurService implements IProfesseurService{
    
    IProfesseurRepository professeurRepository;
   
    public ProfesseurService(IProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    @Override
    public User insertProfesseur(User professeur) {
        return professeurRepository.ajouterProfesseur(professeur);
    }

    @Override
    public List<User> selectAllProfesseurs() {
        
        return professeurRepository.listerProfesseur();
    }

    @Override
    public User selectProfesseurByID(int id) {
        return professeurRepository.filterUnProfesseurParId(id);
    }

    @Override
    public void affecterClasseProfesseur(User professeur, Classe classe) {
        professeurRepository.affecterClasseProfesseur(professeur, classe);
        
    }
    
}
