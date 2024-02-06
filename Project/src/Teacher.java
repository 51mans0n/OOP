import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Teacher extends Employee implements Researcher, Serializable {
    private List<Course> courses;
    private List<ResearchPaper> publishedPapers;
    private List<ResearchProject> researchProjects;
    private UniversityDataStore dataStore;

    public Teacher(String name, String email, String password, String employeeId, DepartmentType department, Language language, UniversityDataStore dataStore) {
        super(name, email, password, employeeId, department, language);
        this.courses = new ArrayList<>();
        this.publishedPapers = new ArrayList<>();
        this.researchProjects = new ArrayList<>();
        this.dataStore = dataStore;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }
    public void addCourseToUniversity(Course course) {
        addCourse(course); // Добавляем курс в личный список учителя
        dataStore.addCourse(course); // Добавляем курс в общий список курсов
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public void setMark(Student student, Course course, double mark) {
        // Логика установления оценки студенту за курс
    }

    public void fileComplaintAboutStudent(Student student, String complaintText) {
        // Логика отправки жалобы на студента
    }

    public List<Student> getStudentsFromCourse(Course course) {
        // Возвращает список студентов, записанных на данный курс
        return null; // Реализация метода
    }

    public void addLessonToCourse(Course course, Lesson lesson) {
        // Добавление урока к курсу
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
        return "Teacher{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", department=" + department +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }

}
