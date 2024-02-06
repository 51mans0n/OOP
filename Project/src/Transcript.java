import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Transcript implements Serializable{
    private Student student;
    private List<Mark> marks;

    public Transcript(Student student) {
        this.student = student;
        this.marks = new ArrayList<>();
    }

    public void addMark(Mark mark) {
        marks.add(mark);
    }

    public List<Mark> getMarksForCourse(Course course) {
        List<Mark> marksForCourse = new ArrayList<>();
        for (Mark mark : marks) {
            if (mark.getCourse().equals(course)) {
                marksForCourse.add(mark);
            }
        }
        return marksForCourse;
    }

    public double calculateGPA() {
        if (marks.isEmpty()) {
            return 0.0;
        }
        double totalGradePoints = 0.0;
        int totalCredits = 0;
        for (Mark mark : marks) {
            totalGradePoints += mark.getGradePoint() * mark.getCourse().getCredits();
            totalCredits += mark.getCourse().getCredits();
        }
        return totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
    }

    public Student getStudent() {
        return student;
    }
}
