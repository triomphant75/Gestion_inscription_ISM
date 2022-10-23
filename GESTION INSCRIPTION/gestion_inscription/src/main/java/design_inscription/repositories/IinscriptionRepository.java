package design_inscription.repositories;

import java.util.List;

import design_inscription.entities.Inscription;
import design_inscription.entities.User;

public interface IinscriptionRepository {
    public Inscription inscrireEtudiant(Inscription inscription);

    // public List<Inscription> listerEtudiantInscrit(String annee);

    public List<User> listerEtudiantInscrit(String annee);

    public List<User> listerEtudiantInscritAN_Classe(String annee,int id);





}