package design_inscription.services;

import java.util.List;

import design_inscription.entities.Inscription;
import design_inscription.entities.User;

public interface IEtudiantService {
    public User ajouterEtudiant(User etudiant);
    public List<User> listerEtudiant();
    public User filterUnEtudiantParId(int id); 
    public Inscription inscrireEtudiant(Inscription inscription);
    public User filterUnEtudiantParNom(String nom); 
    public User filtreAn();
    public User filtreAnClasse();
}
