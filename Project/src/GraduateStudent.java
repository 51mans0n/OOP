import java.util.List;
import java.util.ArrayList;

public class GraduateStudent extends Student implements Researcher {
    private DegreeType degreeType;
    private List<ResearchProject> researchProjects;
    private List<ResearchPaper> publishedPapers;

    public GraduateStudent(String name, String email, String password, DegreeType degreeType, Schools school, Language language) {
        super(name, email, password, school, language);
        this.degreeType = degreeType;
        this.researchProjects = new ArrayList<>();
        this.publishedPapers = new ArrayList<>();
    }

    // Реализация методов интерфейса Researcher
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

    // Dependency injection
    public DegreeType getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(DegreeType degreeType) {
        this.degreeType = degreeType;
    }
    @Override
    public String toString() {
        return "GraduateStudent{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", school=" + getSchool() +
                ", degreeType=" + degreeType +
                '}';
    }

}
