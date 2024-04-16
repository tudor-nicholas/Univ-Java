package OOP.lab6;

public abstract class Locality {
    private String name;
    private int population;
    private String county;
    public Locality(String nameL, int popL, String countyL) {
        setName(nameL);
        setPopulation(popL);
        setCounty(countyL);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public void setCounty(String county) {
        this.county = county;
    }
    public String getName() {
        return name;
    }
    public int getPopulation() {
        return population;
    }
    public String getCounty() {
        return  county;
    }
    public String toString(){
        return String.format("Locality: name: %s population: %d county: %s", name, population, county);
    }
}
