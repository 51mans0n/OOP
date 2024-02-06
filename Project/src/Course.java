import java.io.Serializable;

public class Course implements Serializable {
    private String title;
    private String description;
    private int credits;
    private CourseType courseType;
    private Course prerequisite;
    private Teacher teacher;

    public Course(String title, String description, int credits, CourseType courseType, Course prerequisite, Teacher teacher) {
        this.title = title;
        this.description = description;
        this.credits = credits;
        this.courseType = courseType;
        this.prerequisite = prerequisite;
        this.teacher = teacher;
    }

    // Dependency injection
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCredits() {
        return credits;
    }

    public CourseType getCourseType() {
        return courseType;
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public Course getPrerequisite() {
        return prerequisite;
    }

}

