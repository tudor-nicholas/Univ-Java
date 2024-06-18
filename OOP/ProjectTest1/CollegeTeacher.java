package OOP.ProjectTest1;

public class CollegeTeacher extends Teacher {
    private String title, type="college";
    private int yearsOfEmployment;
    public CollegeTeacher(String name, int exp, String titleT, int employment) {
        super(name, exp);
        title = titleT;
        yearsOfEmployment = employment;
    }
    public String getType() {
        return type;
    }
    public String getTitle() {
        return title;
    }
    public int getYearsOfEmployment() {
        return yearsOfEmployment;
    }
    public void setName(String name) {
        super.setName(name);
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setYearsOfEmployment(int yearsOfEmployment) {
        this.yearsOfEmployment = yearsOfEmployment;
    }
    public void setExperience(int experience) {
        super.setExperience(experience);
    }
    @Override
    public String toString(){
        return String.format("College %s Title: %s Years as College Teacher: %d", super.toString(), title, yearsOfEmployment);
    }
    public String toFileString(){
        return String.format("college  %s  %d  %s  %d", super.getName(), super.getExperience(), title, yearsOfEmployment);
    }
}
