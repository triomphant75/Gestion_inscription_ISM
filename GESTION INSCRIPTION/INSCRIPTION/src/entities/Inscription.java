package entities;
public class Inscription {

   private String DateInscription;

    // Many to one
    private Classe classe;
    private User etudiant;

    public Inscription() {
    }
    
    public Inscription(String dateinscription, Classe classe, User etudiant) {
        this.DateInscription = dateinscription;
        this.classe = classe;
        this.etudiant = etudiant;
    }


    public  User getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(User etudiant) {
        this.etudiant = etudiant;
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getDateinscription() {
        return DateInscription;
    }
    public void setDateinscription(String dateinscription) {
        this.DateInscription = dateinscription;
    }

    @Override
    public String toString() {
        return "Inscription [ dateinscription=" + DateInscription + ", classe=" + classe + ", etudiant="
                + etudiant + "]";
    }
    
}
