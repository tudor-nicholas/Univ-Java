package OOP.Project;

public class CollegeTeacher extends Teacher {
    private String title;
    private int yearsOfEmployment;
    public CollegeTeacher(String name, int exp, String titleT, int employment) {
        super(name, exp);
        title = titleT;
        yearsOfEmployment = employment;
    }
    public String getTitle() {
        return title;
    }
    public int getYearsOfEmployment() {
        return yearsOfEmployment;
    }
    @Override
    public String toString(){
        return String.format("College %s Title: %s Years of Experience: %d", super.toString(), title, yearsOfEmployment);
    }
}
