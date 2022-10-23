package views;
import java.util.Scanner;

import entities.Classe;
import entities.Professeur;
import entities.User;
import services.IClasseService;
import services.IProfesseurService;

public class ProfesseurView {

    Scanner clavier=new Scanner(System.in);
    IClasseService serv;
    int choix;
    String nom,login,password,grade;
    IProfesseurService professeurService;
    int classeid;
    int professeurid;

    public ProfesseurView(IProfesseurService professeurService,  IClasseService serv) {
        this.professeurService = professeurService;
        this.serv=serv;
    }

    public void affiche(){
        do {
            System.out.println("1-- ajouter un professeur");
            System.out.println("2--lister les professeurs");
            System.out.println("3--filtrer un professeur par id");
            System.out.println("4--affecter une classe a un professeur");
            System.out.println("6--quitter");
            System.out.println("faite votre choix");
            choix = clavier.nextInt();
            clavier.nextLine();

            switch (choix) {
                case 1:
                System.out.println("donner nom ");
                nom=clavier.nextLine();
                System.out.println("donner grade ");
                grade=clavier.nextLine();
                User user=new Professeur(nom,grade);
                User userAvecId=professeurService.insertProfesseur( user);
                System.out.println(userAvecId);
                    
                break;
                case 2:
                    professeurService.selectAllProfesseurs().forEach(System.out::println);
                break;
                case 3:
                    System.out.println("donner un id");
                    int id=clavier.nextInt();
                     user=professeurService.selectProfesseurByID(id);
                     System.out.println(user);
                    
                break;
                case 4:
                System.out.println("donner id professeur");
                    professeurid=clavier.nextInt();
                    clavier.nextLine();
                    User professeur=professeurService.selectProfesseurByID(professeurid);
                    System.out.println(professeur);
                    System.out.println("donner id classe ");
                    classeid=clavier.nextInt();
                    clavier.nextLine();
                    Classe classe=serv.selectClasseByID(classeid);
                    System.out.println(classe);   
                    professeurService.affecterClasseProfesseur(professeur, classe);

                break;
            
            
                default:
                    break;
            }
            
        } while (choix!=6);
    }
    
}
