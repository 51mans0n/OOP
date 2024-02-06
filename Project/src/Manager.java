import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Manager extends Employee {
    private List<CourseApplication> courseApplications;
    private List<Course> availableCourses;
    public Manager(String name, String email, String password, String employeeId, DepartmentType department, Language language) {
        super(name, email, password, employeeId, department, language);
        this.courseApplications = new ArrayList<>();
    }

    public void approveCourseApplication(CourseApplication application) {
        if (applicationMeetsCriteria(application)) {
            application.setStatus(RequestStatus.ACCEPTED);
            application.getApplicant().getEnrolledCourses().add(application.getCourse());
        } else {
            application.setStatus(RequestStatus.REJECTED);
        }
    }
    private boolean isApplicationApproved(Student student, Course course) {
        // Логика для проверки, что заявка студента на курс одобрена
        return true;
    }

    public void addCourseForRegistration(Course course) {
        if (!availableCourses.contains(course)) {
            availableCourses.add(course);
        }
    }
    public void receiveCourseApplication(CourseApplication application) {
        courseApplications.add(application);
    }
    public void reviewCourseApplication(CourseApplication application) {
        if (applicationMeetsCriteria(application)) {
            application.setStatus(RequestStatus.ACCEPTED);
            // Дописать
        }
        else {
            application.setStatus(RequestStatus.REJECTED);
        }
    }
    private boolean applicationMeetsCriteria(CourseApplication application) {
        // Логика проверки заявки (например, проверка на количество кредитов)
        return true;
    }

    public void assignTeacherToCourse(Teacher teacher, Course course) {
        teacher.addCourse(course);
    }
    private boolean canStudentEnroll(Student student, Course course) {
        // Логика для проверки, может ли студент быть записан на курс
        return true;
    }
    public List<CourseApplication> getAllCourseApplications() {
        return new ArrayList<>(courseApplications);
    }

    public Report generatePerformanceReport() {
        String reportId = generateReportId(); // Генерация идентификатора отчета
        String title = "Student Progress Report";
        String content = createReportContent(); // Генерация содержимого отчета

        return new Report(reportId, title, content);
    }
    private String generateReportId() {
        // Логика для генерации уникального ID отчета
        return "report_" + System.currentTimeMillis();
    }
    private String createReportContent() {
        // Логика для создания содержимого отчета
        return "Report Contents...";
    }
    public void cancelCourseApplication(Student student, Course course) { // Iterator Design Pattern
        Iterator<CourseApplication> iterator = courseApplications.iterator();
        while (iterator.hasNext()) {
            CourseApplication application = iterator.next();
            if (application.getApplicant().equals(student) && application.getCourse().equals(course)) {
                iterator.remove();
                application.setStatus(RequestStatus.REJECTED);
                break;
            }
        }
    }
    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", department=" + department +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
