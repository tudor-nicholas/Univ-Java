package OOP.lab6;

public class Town extends Locality{
    private int nrOfUniversities;

    public Town(String nameL, int popL, String countyL, int univ) {
        super(nameL, popL, countyL);
        setNrOfUniversities(univ);
    }
    public void setNrOfUniversities(int univ) {
        nrOfUniversities = univ;
    }
    public int getNrOfUniversities() {
        return nrOfUniversities;
    }
    @Override
    public String toString(){
        return String.format("Town: %s number of universities: %d",super.toString(), nrOfUniversities);
    }
}
