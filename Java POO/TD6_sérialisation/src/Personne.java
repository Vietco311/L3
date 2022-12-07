import java.io.Serializable;

public class Personne implements Serializable {
    private String nom;
    private String prenom;
    private int age;

    public Personne(String nNom, String  nPrenom, int nAge){
        this.nom = nNom;
        this.prenom = nPrenom;
        this.age = nAge;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        
        return super.toString();
    }
}
