package OOP.Project;

public class HighSchoolTeacher extends Teacher {
    private String grade;
    private int nrOfHours;
    public HighSchoolTeacher(String name, int exp, String gradeT, int hours) {
        super(name, exp);
        grade = gradeT;
        nrOfHours = hours;
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
}
