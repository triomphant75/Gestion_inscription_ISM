package design_inscription.entities;

import design_inscription.core.Roles;

public class Professeur extends User{

    private String grade;


    public Professeur(int id, String nomComplet, String grade) {
        super(id, nomComplet);
        this.grade = grade;
        role=Roles.PROFESSEUR;
    }
    public Professeur(String nomComplet, String grade) {
        super(nomComplet);
        this.grade = grade;
        role=Roles.PROFESSEUR;
    }


    //ManyToOne avec classe 
    protected Classe classe;


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString()+ "grade=" + grade + "]";
    }   
 
}
