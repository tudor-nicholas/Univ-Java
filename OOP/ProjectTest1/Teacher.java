package OOP.ProjectTest1;

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
    public void setName(String name) {
        this.name = name;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public String toString(){
        return String.format("Teacher Name: %s Years of experience: %d", name, experience);
    }
    public abstract String toFileString();
    public abstract String getType();
}
