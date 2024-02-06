import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {
    private String reportId;
    private String title;
    private Date creationDate;
    private String content;

    public Report(String reportId, String title, String content) {
        this.reportId = reportId;
        this.title = title;
        this.content = content;
        this.creationDate = new Date(); // Установка текущей даты в качестве даты создания отчета
    }


    // Dependency injection
    public String getReportId() {
        return reportId;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
