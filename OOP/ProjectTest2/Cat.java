package OOP.ProjectTest2;

public class Cat extends Pet {
    private String colour;
    private int weight;

    public Cat(String name, int age, String colour, int weight) {
        super(name, age);
        this.colour = colour;
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Cat: " + super.toString() + ", Colour: " + colour + ", Weight: " + weight + " kg";
    }

    @Override
    public String toFileString() {
        return "cat  " + getName() + "  " + getAge() + "  " + colour + "  " + weight;
    }
}
