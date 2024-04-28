package OOP.Project;

public abstract class Teacher {
    private String name;
    private int experience;
    public Teacher(String nameT, int exp) {
        name = nameT;
        experience = exp;
    }
    public String getName() {
        return name;
    }
    public int getExperience() {
        return experience;
    }
    public String toString(){
        return String.format("Teacher Name: %s Years of experience: %d", name, experience);
    }
}
