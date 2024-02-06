public class CourseApplication {
    private Student applicant;
    private Course course;
    private RequestStatus status;

    public CourseApplication(Student applicant, Course course) {
        this.applicant = applicant;
        this.course = course;
        this.status = RequestStatus.PENDING;
    }

    // Dependency injection
    public Student getApplicant() {
        return applicant;
    }

    public Course getCourse() {
        return course;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
