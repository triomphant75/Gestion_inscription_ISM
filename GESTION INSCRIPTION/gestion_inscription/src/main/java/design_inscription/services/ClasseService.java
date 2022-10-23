package design_inscription.services;

import java.util.List;

import design_inscription.entities.Classe;
import design_inscription.repositories.IClasseRepository;
public class ClasseService implements IClasseService{

    IClasseRepository classeRepository;
    public ClasseService(IClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public Classe insertClasse(Classe classe) {
        return classeRepository.ajouterUneClasse(classe);
    }

    @Override
    public List<Classe> selectAllClasses() {
        return classeRepository.listerClasses();
    }

    @Override
    public Classe selectClasseByID(int id) {
        return classeRepository.filtrerUneClasseParId(id);
    }
    
}
