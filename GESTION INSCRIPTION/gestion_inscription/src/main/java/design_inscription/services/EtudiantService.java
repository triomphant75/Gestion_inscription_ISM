package design_inscription.services;

import java.util.List;

import design_inscription.entities.Inscription;
import design_inscription.entities.User;
import design_inscription.repositories.EtudiantRepository;
import design_inscription.repositories.IEtudiantRepository;
import design_inscription.repositories.IinscriptionRepository;

public class EtudiantService implements IEtudiantService {

    IEtudiantRepository etudiantRepository;
    IinscriptionRepository inscriptionRepository;
    public EtudiantService(IEtudiantRepository etudiantRepository,
    IinscriptionRepository inscriptionRepository) {

        this.etudiantRepository = etudiantRepository;

        this.inscriptionRepository = inscriptionRepository;
    }
    

    @Override
    public User ajouterEtudiant(User etudiant) {
        
        return etudiantRepository.ajouterEtudiant(etudiant);
    }

    @Override
    public List<User> listerEtudiant() {
       
        return etudiantRepository.listerEtudiant();
    }

    @Override
    public User filterUnEtudiantParId(int id) {
       
        return etudiantRepository.filterUnEtudiantParId(id);
    }

    @Override
    public Inscription inscrireEtudiant(Inscription inscription) {
        return inscriptionRepository.inscrireEtudiant(inscription);
    }


    @Override
    public User filterUnEtudiantParNom(String nom) {
        return null;
    }


    @Override
    public User filtreAn() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public User filtreAnClasse() {
        // TODO Auto-generated method stub
        return null;
    }

}
