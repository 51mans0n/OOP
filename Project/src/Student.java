import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Researcher{
    private List<Course> enrolledCourses;
    private Transcript transcript;
    private List<ResearchPaper> publishedPapers;
    private List<ResearchProject> researchProjects;
    private List<StudentOrganization> studentOrganizations;
    private final int MAX_CREDITS = 21;
    private Schools school;

    public Student(String name, String email, String password, Schools school, Language language) {
        super(name, email, password, language);
        this.publishedPapers = new ArrayList<>();
        this.researchProjects = new ArrayList<>();
        this.enrolledCourses = new ArrayList<>();
        this.transcript = new Transcript(this);
        this.school = school;
    }
    public int getAvailableCredits() {
        int currentCredits = enrolledCourses.stream().mapToInt(Course::getCredits).sum();
        return MAX_CREDITS - currentCredits;
    }

    public void joinStudentOrganization(StudentOrganization organization) {
        if (!studentOrganizations.contains(organization)) {
            studentOrganizations.add(organization);
            organization.addMember(this);
        }
    }
    public void leaveStudentOrganization(StudentOrganization organization) {
        if (studentOrganizations.contains(organization)) {
            studentOrganizations.remove(organization);
            organization.removeMember(this);
        }
    }
    public void applyForCourse(Course course, Manager manager) {
        CourseApplication application = new CourseApplication(this, course);
        manager.receiveCourseApplication(application);
    }
    public boolean canEnrollInCourse(Course course) {
        int currentCredits = enrolledCourses.stream().mapToInt(Course::getCredits).sum();
        return currentCredits + course.getCredits() <= MAX_CREDITS;
    }
    public List<Course> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses);
    }
    public void rateTeacher(Teacher teacher, Rating rating) {
        // Реализация оценки преподавателя
    }
    public Transcript getTranscript() {
        return transcript;
    }
    public Schools getSchool() {
        return school;
    }
    public void setSchool(Schools school) {
        this.school = school;
    }
    public void viewTeacherInfo(Teacher teacher) {
        // Просмотр информации о преподавателе
    }
    public List<Mark> viewGradesForCourse(Course course) {
        // Вернуть оценки для конкретного курса
        return transcript.getMarksForCourse(course);
    }
    @Override
    public void publishResearch(ResearchPaper paper) {
        publishedPapers.add(paper);
    }

    @Override
    public void participateInProject(ResearchProject project) {
        researchProjects.add(project);
        project.addParticipant(this);
    }

    @Override
    public List<ResearchPaper> getPublishedPapers() {
        return new ArrayList<>(publishedPapers);
    }

    @Override
    public void addPublishedPaper(ResearchPaper paper) {
        publishedPapers.add(paper);
    }

    @Override
    public List<ResearchProject> getResearchProjects() {
        return new ArrayList<>(researchProjects);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", school=" + getSchool() +
                '}';
    }
}


