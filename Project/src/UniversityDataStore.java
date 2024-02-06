import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class UniversityDataStore implements Serializable {
    private List<User> users;
    private List<LogEntry> logs;
    private List<ResearchProject> researchProjects;
    private List<ResearchPaper> researchPapers;
    private List<Complaint> complaints;
    private List<Inquiry> inquiries;
    private List<StudentOrganization> studentOrganizations;
    private List<Manager> managers;
    private List<Course> allCourses;

    public UniversityDataStore() {
        this.users = new ArrayList<>();
        this.logs = new ArrayList<>();
        this.researchProjects = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.inquiries = new ArrayList<>();
        this.studentOrganizations = new ArrayList<>();
        this.researchPapers = new ArrayList<>();
        this.managers = new ArrayList<>();
        this.allCourses = new ArrayList<>();
    }
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void replaceUser(String email, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equalsIgnoreCase(email)) {
                users.set(i, updatedUser); // Заменяем пользователя
                return;
            }
        }
        // Если пользователь с таким email не найден, можно добавить нового пользователя
        users.add(updatedUser);
    }
    public void deleteUser(User user) {
        users.remove(user);
    }
    public List<LogEntry> getLogs() {
        return new ArrayList<>(logs); // Возвращаем копию списка для безопасности
    }
    public void addLogEntry(String adminEmail, String action) {
        LogEntry logEntry = new LogEntry(adminEmail, action);
        logs.add(logEntry);
    }
    public void addStudentOrganization(StudentOrganization organization) {
        studentOrganizations.add(organization);
    }
    public List<StudentOrganization> getStudentOrganizations() {
        return studentOrganizations;
    }

    // Dependency injection
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<ResearchProject> getResearchProjects() {
        return new ArrayList<>(researchProjects);
    }
    public ResearchProject getProjectById(String projectId) {
        for (ResearchProject project : researchProjects) {
            if (project.getProjectId().equals(projectId)) {
                return project;
            }
        }
        return null;
    }
    public ResearchProject getProjectByTitle(String title) {
        for (ResearchProject project : researchProjects) {
            if (project.getTitle().equalsIgnoreCase(title)) {
                return project;
            }
        }
        return null;
    }


    public void addResearchProject(ResearchProject project) {
        if (!researchProjects.contains(project)) {
            researchProjects.add(project);
        }
    }
    public void addResearchPaper(ResearchPaper paper) {
        if (!researchPapers.contains(paper)) {
            researchPapers.add(paper);
        }
    }
    public void updateResearchProject(ResearchProject project) {
        for (int i = 0; i < researchProjects.size(); i++) {
            if (researchProjects.get(i).getProjectId().equals(project.getProjectId())) {
                researchProjects.set(i, project);
                return;
            }
        }
    }
    public List<Course> getAllCourses() {
        return new ArrayList<>(allCourses);
    }
    public Course getCourseByTitle(String title) {
        for (Course course : allCourses) {
            if (course.getTitle().equalsIgnoreCase(title)) {
                return course;
            }
        }
        return null;
    }
    public void addCourse(Course course) {
        if (!allCourses.contains(course)) {
            allCourses.add(course);
        }
    }

    public void addManager(Manager manager) {
        managers.add(manager);
    }
    public List<Manager> getManagers() {
        return new ArrayList<>(managers);
    }
}
