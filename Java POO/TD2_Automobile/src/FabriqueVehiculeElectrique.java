public class FabriqueVehiculeElectrique implements FabriqueVehicule{
    
    @Override
    public void fabriqueAutomobile(){
        AutomobileElectricite jean_jacques = new AutomobileElectricite("Honda", 300, "Blanche", 2);
    };

    @Override
    public void fabriqueScooter(){
        ScooterElectricite jean_pierre = new ScooterElectricite("Malagutti", 500, "Jaune", 2);
    }
}
