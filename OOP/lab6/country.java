package OOP.lab6;

public class country {
    public static void main(String[] args) {
        System.out.println("3.There is the following hierarchy:");
        System.out.println("Locality (abstract): name (String), population(int), county(String)");
        System.out.println("-Town: nrOfUniversities (int)");
        System.out.println("-Town: nrOfUniversities (int)");
        Locality[] localities = {
                new Town("Springfield", 57382, "Orange County", 4),
                new Commune("Oakville", 52442, "Franklin County", 2),
                new Commune("Maplewood", 7643, "Jackson County", 12),
                new Town("Riverside", 6533, "Madison County", 9),
                new Town("Greenville", 9729, "Monroe County", 1)
        };
        countryStatic.readLocalities(localities);
    }
}
