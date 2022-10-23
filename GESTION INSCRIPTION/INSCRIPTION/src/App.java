import java.util.Scanner;

import entities.Classe;
import repositories.ClasseRepository;
import repositories.IClasseRepository;
import repositories.IProfesseurRepository;
import repositories.ProfesseurRepository;
import services.ClasseService;
import services.IClasseService;
import services.IProfesseurService;
import services.ProfesseurService;
import views.ClasseView;
import views.ProfesseurView;

public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner clavier=new Scanner(System.in);
       IClasseRepository classeRepository=new ClasseRepository();
       IClasseService classeService= new ClasseService(classeRepository);
       IProfesseurRepository userRepository=new ProfesseurRepository();
       IProfesseurService professeurService=new ProfesseurService(userRepository);
       ClasseView classeview=new ClasseView(classeService);
       ProfesseurView userview=new ProfesseurView(professeurService,classeService);
       int choix;
      
       do {
        System.out.println("1--page professeur");
        System.out.println("2--page classe");
        System.out.println("3--quitter");
        System.out.println("donner le choix");
        choix=clavier.nextInt();
        clavier.nextLine();
        switch (choix) {
            case 1:
                userview.affiche();
                break;
            case 2:
                classeview.affiche();
                break;
            default:
                break;
        }
        
       } while (choix!=3);
        
    }
}
