import java.util.List;

public interface Researcher { // Interface Segregation Principle, Strategy Pattern
    void publishResearch(ResearchPaper paper);
    void participateInProject(ResearchProject project);
    List<ResearchPaper> getPublishedPapers();
    void addPublishedPaper(ResearchPaper paper);
    List<ResearchProject> getResearchProjects();
}
