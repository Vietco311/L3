public class FabriqueVehiculeEssence implements FabriqueVehicule {

    @Override
    public void fabriqueAutomobile(){
        AutomobileEssence jean_claude = new AutomobileEssence("Porsche", 300, "Blanche", 2);
    };

    @Override
    public void fabriqueScooter(){
        ScooterEssence jean_paul = new ScooterEssence("MBK", 500, "Jaune", 2);
    }
}
