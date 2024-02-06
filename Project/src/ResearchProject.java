import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class ResearchProject implements Serializable{
    private String projectId;
    private String title;
    private String theme;
    private List<Researcher> participants;
    private List<ResearchPaper> publishedPapers;

    public ResearchProject(String projectId, String title, String theme) {
        this.projectId = projectId;
        this.title = title;
        this.theme = theme;
        this.participants = new ArrayList<>();
        this.publishedPapers = new ArrayList<>();
    }

    public void addParticipant(Researcher researcher) {
        if (!participants.contains(researcher)) {
            participants.add(researcher);
        }
    }

    public void addPaper(ResearchPaper paper) {
        publishedPapers.add(paper);
    }

    // Dependency injection
    public String getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    public String getTheme() {
        return theme;
    }

    public List<Researcher> getParticipants() {
        return new ArrayList<>(participants);
    }


    public List<ResearchPaper> getPublishedPapers() {
        return new ArrayList<>(publishedPapers);
    }
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setParticipants(List<Researcher> participants) {
        this.participants = new ArrayList<>(participants);
    }

    public void setPublishedPapers(List<ResearchPaper> publishedPapers) {
        this.publishedPapers = new ArrayList<>(publishedPapers);
    }
}
