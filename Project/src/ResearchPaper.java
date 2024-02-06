import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class ResearchPaper implements Serializable{
    private String paperId;
    private String title;
    private List<String> authors;
    private String abstractText;
    private int pageCount;
    private String doi; // doi - Digital Object Identifier
    private Date publishedDate;

    public ResearchPaper(String paperId, String title, List<String> authors, String abstractText, int pageCount, String doi, Date publishedDate) {
        this.paperId = paperId;
        this.title = title;
        this.authors = new ArrayList<>(authors);
        this.abstractText = abstractText;
        this.pageCount = pageCount;
        this.doi = doi;
        this.publishedDate = publishedDate;
    }

    // Dependency injection
    public String getPaperId() {
        return paperId;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return new ArrayList<>(authors);
    }

    public String getAbstractText() {
        return abstractText;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getDoi() {
        return doi;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<String> authors) {
        this.authors = new ArrayList<>(authors);
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
