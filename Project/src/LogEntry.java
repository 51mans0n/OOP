import java.io.Serializable;
import java.time.LocalDateTime;

public class LogEntry implements Serializable {
    private String adminEmail;
    private String action;
    private LocalDateTime timestamp;

    public LogEntry(String adminEmail, String action) {
        this.adminEmail = adminEmail;
        this.action = action;
        this.timestamp = LocalDateTime.now(); // Сохраняем время создания записи
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "adminEmail='" + adminEmail + '\'' +
                ", action='" + action + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
