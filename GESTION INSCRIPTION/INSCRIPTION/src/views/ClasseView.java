package views;

import java.util.Scanner;

import entities.Classe;
import services.IClasseService;

public class ClasseView {

    Scanner clavier = new Scanner(System.in);
    IClasseService service;
    int choix;
    String niveau, filiere, libelle;

    public ClasseView(IClasseService service) {
        this.service = service;
    }

    public void affiche() {
        do {
            System.out.println("1-- creer une classe");
            System.out.println("2--lister les classes");
            System.out.println("3--filitre une classe par id");
            System.out.println("6--quitter");
            System.out.println("faite votre choix");
            choix = clavier.nextInt();
            clavier.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("votre niveau");
                    niveau = clavier.nextLine();
                    System.out.println("votre filiere");
                    filiere = clavier.nextLine();
                    System.out.println("libelle");
                    libelle = clavier.nextLine();
                    Classe classe = new Classe(niveau, filiere, libelle);
                    Classe classeAvecID = service.insertClasse(classe);
                    System.out.println(classeAvecID);
                    break;
                case 2:
                    service.selectAllClasses().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("donner un id");
                    int id=clavier.nextInt();
                    classe=service.selectClasseByID(id);
                    System.out.println(classe);
                    break;

                default:
                    break;
            }
        } while (choix != 6);
    }

}
