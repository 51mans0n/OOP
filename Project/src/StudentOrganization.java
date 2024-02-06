import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class StudentOrganization implements Serializable {
    private String name;
    private String description;
    private List<Student> members;

    public StudentOrganization(String name, String description) {
        this.name = name;
        this.description = description;
        this.members = new ArrayList<>();
    }

    public void addMember(Student student) {
        if (!members.contains(student)) {
            members.add(student);
        }
    }

    public void removeMember(Student student) {
        members.remove(student);
    }

    // Dependency injection
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getMembers() {
        return new ArrayList<>(members);
    }

    // Другие методы...
}
