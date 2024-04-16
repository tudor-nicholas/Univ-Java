package OOP.lab6;

public class Commune extends Locality{
    private int nrOfVillages;

    public Commune(String nameL, int popL, String countyL, int villages) {
        super(nameL, popL, countyL);
        setNrOfVillages(villages);
    }
    public void setNrOfVillages(int villages) {
        nrOfVillages = villages;
    }
    public int getNrOfVillages() {
        return nrOfVillages;
    }
    @Override
    public String toString(){
        return String.format("Commune: %s number of villages: %d",super.toString(), nrOfVillages);
    }
}
