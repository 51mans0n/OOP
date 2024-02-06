import java.util.Date;

public class Complaint {
    private String id;
    private String description;
    private ComplaintStatus status;
    private Date creationDate;
    private User reporter; // Пользователь, подавший жалобу

    public Complaint(String id, String description, User reporter) {
        this.id = id;
        this.description = description;
        this.status = ComplaintStatus.OPEN; // Статус по умолчанию
        this.creationDate = new Date();
        this.reporter = reporter;
    }

    // Dependency injection
    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public User getReporter() {
        return reporter;
    }
}
