import java.io.Serializable;
public class Mark implements Serializable {
    private Course course;
    private double firstAttestationScore;
    private double secondAttestationScore;
    private double finalExamScore;

    public Mark(Course course, double firstAttestationScore, double secondAttestationScore, double finalExamScore) {
        this.course = course;
        this.firstAttestationScore = firstAttestationScore;
        this.secondAttestationScore = secondAttestationScore;
        this.finalExamScore = finalExamScore;
    }

    // Dependency injection
    public double getTotalScore() {
        return firstAttestationScore + secondAttestationScore + finalExamScore;
    }

    public Course getCourse() {
        return course;
    }
    public double getGradePoint() {
        return (firstAttestationScore + secondAttestationScore + finalExamScore) / 100;
    }

    public double getFirstAttestationScore() {
        return firstAttestationScore;
    }

    public double getSecondAttestationScore() {
        return secondAttestationScore;
    }

    public double getFinalExamScore() {
        return finalExamScore;
    }
}
