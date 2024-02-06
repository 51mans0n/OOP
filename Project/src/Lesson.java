import java.io.Serializable;
import java.util.Date;

public class Lesson implements Serializable {
    private String lessonId;
    private String title;
    private Date date;
    private String description;
    private LessonType lessonType;

    public Lesson(String lessonId, String title, Date date, String description, LessonType lessonType) {
        this.lessonId = lessonId;
        this.title = title;
        this.date = date;
        this.description = description;
        this.lessonType = lessonType;
    }

    // Dependency injection
    public String getLessonId() {
        return lessonId;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
