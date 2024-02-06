import java.util.Date;

public class Inquiry {
    private String id;
    private Employee submitter;
    private String inquiryText;
    private Date submissionDate;
    private RequestStatus status;

    public Inquiry(String id, Employee submitter, String inquiryText) {
        this.id = id;
        this.submitter = submitter;
        this.inquiryText = inquiryText;
        this.submissionDate = new Date();
        this.status = RequestStatus.PENDING; // Статус по умолчанию
    }

    // Dependency injection
    public String getId() {
        return id;
    }

    public Employee getSubmitter() {
        return submitter;
    }

    public String getInquiryText() {
        return inquiryText;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status){
        this.status = status;
    }
}