public class Banque {
    private int solde;

    public Banque(int nSolde){
        this.solde = nSolde;
    }
    public void retrait(int somme) throws RetraitException{
        try {
            if (solde - somme < 0){
                throw new RetraitException(somme);
            }
            this.solde -= somme;
        } finally{

        }
        
    }
}
