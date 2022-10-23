package repositories;
import java.util.List;

import entities.Classe;
public interface IClasseRepository {
    public Classe ajouterUneClasse(Classe classe);
    public List<Classe> listerClasses();
    public Classe filtrerUneClasseParId(int id);
}
