package design_inscription.repositories;
import java.util.List;

import design_inscription.entities.Classe;
public interface IClasseRepository {
    public Classe ajouterUneClasse(Classe classe);
    public List<Classe> listerClasses();
    public Classe filtrerUneClasseParId(int id);
    public List<Classe>filtrerUneClasseProf(int id);
}
