package services;
import java.util.List;
import entities.Classe;

public interface IClasseService {

    public Classe insertClasse(Classe classe);
    public List<Classe> selectAllClasses();
    public Classe selectClasseByID(int id);
    

    
}
