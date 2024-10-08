package OOP.ProjectTest2;

public class Dog extends Pet {
    private String race;
    private int lifetime;

    public Dog(String name, int age, String race, int lifetime) {
        super(name, age);
        this.race = race;
        this.lifetime = lifetime;
    }

    public String getRace() {
        return race;
    }

    public int getLifetime() {
        return lifetime;
    }

    @Override
    public String toString() {
        return "Dog: " + super.toString() + ", Race: " + race + ", Lifetime: " + lifetime + " years";
    }

    @Override
    public String toFileString() {
        return "dog  " + getName() + "  " + getAge() + "  " + race + "  " + lifetime;
    }
}
