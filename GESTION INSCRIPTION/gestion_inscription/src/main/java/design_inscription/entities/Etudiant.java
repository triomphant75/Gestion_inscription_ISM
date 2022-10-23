package design_inscription.entities;

import design_inscription.core.Roles;

public class Etudiant extends User{



    private String tuteur;
    private String matricule;
    

    public Etudiant(int id, String nomComplet, String tuteur, String matricule) {
        super(id, nomComplet);
        this.tuteur = tuteur;
        this.matricule = matricule;
        role=Roles.ETUDIANT;
    }

    public Etudiant(String nomComplet,String tuteur) {
        super(nomComplet);
        this.tuteur = tuteur;
        role=Roles.ETUDIANT;
        
    }
    
    public Etudiant(String nomComplet, String tuteur, String matricule) {
        super(nomComplet);
        this.tuteur = tuteur;
        this.matricule = matricule;
        role=Roles.ETUDIANT;
    }


    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }




    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }


    @Override
    public String toString() {
        return super.toString()+ "tuteur=" + tuteur + "matricule="+matricule+"]";
    }

   
}
