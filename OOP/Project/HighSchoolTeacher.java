package OOP.Project;

public class HighSchoolTeacher extends Teacher {
    private String grade, type="high";
    private int nrOfHours;
    public HighSchoolTeacher(String name, int exp, String gradeT, int hours) {
        super(name, exp);
        grade = gradeT;
        nrOfHours = hours;
    }
    public String getType() {
        return type;
    }
    public void setExperience(int experience) {
        super.setExperience(experience);
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void setNrOfHours(int nrOfHours) {
        this.nrOfHours = nrOfHours;
    }
    public String getGrade() {
        return grade;
    }
    public int getNrOfHours() {
        return nrOfHours;
    }
    @Override
    public String toString(){
        return String.format("High School %s Grade: %s Number of hours: %d", super.toString(), grade, nrOfHours);
    }
    public String toFileString(){
        return String.format("high %s %d %s %d", super.getName(), super.getExperience(), grade, nrOfHours);
    }
}
