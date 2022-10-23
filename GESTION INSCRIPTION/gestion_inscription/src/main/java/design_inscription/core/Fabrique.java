package design_inscription.core;

import design_inscription.entities.User;
import design_inscription.repositories.ClasseRepository;
import design_inscription.repositories.EtudiantRepository;
import design_inscription.repositories.IClasseRepository;
import design_inscription.repositories.IEtudiantRepository;
import design_inscription.repositories.IProfesseurRepository;
import design_inscription.repositories.IUserRepository;
import design_inscription.repositories.IinscriptionRepository;
import design_inscription.repositories.InscriptionRepository;
import design_inscription.repositories.ProfesseurRepository;
import design_inscription.repositories.UserRepository;
import design_inscription.services.ClasseService;
import design_inscription.services.EtudiantService;
import design_inscription.services.IClasseService;
import design_inscription.services.IEtudiantService;
import design_inscription.services.IProfesseurService;
import design_inscription.services.IUserService;
import design_inscription.services.ProfesseurService;
import design_inscription.services.UserService;

public class Fabrique {

    
    public static IProfesseurService getProfesseurService(){
        IProfesseurRepository professeurRepository=new ProfesseurRepository();
        return new ProfesseurService(professeurRepository);
    }
    public static IClasseService getClasseService(){
        IProfesseurRepository professeurRepository=new ProfesseurRepository();
        IClasseRepository classeRepository=new ClasseRepository(professeurRepository);
        return new ClasseService(classeRepository);
    }
    public static IUserService getUserService(){
        IUserRepository userRepository=new UserRepository();
        return new UserService(userRepository);
    }
    public static IEtudiantService getEtudiantService(){
        IEtudiantRepository etudiantRepository=new EtudiantRepository();
        IinscriptionRepository iinscriptionRepository=new InscriptionRepository();
        return new EtudiantService(etudiantRepository, iinscriptionRepository);
    }
  
}
