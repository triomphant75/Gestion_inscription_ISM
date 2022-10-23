package design_inscription.services;
import java.util.List;
import design_inscription.entities.Classe;

public interface IClasseService {

    public Classe insertClasse(Classe classe);
    public List<Classe> selectAllClasses();
    public Classe selectClasseByID(int id);
    

    
}
