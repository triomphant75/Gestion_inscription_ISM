package services;

import java.util.List;

import entities.Inscription;
import entities.User;

public interface IEtudiantService {
    public User insertEtudiant(User etudiant );
    public List<User > selectAllEtudiant();
    public User  selectEtudiantByID(int id);
    public Inscription InsertEtudiantInscrit(Inscription inscription);

}
