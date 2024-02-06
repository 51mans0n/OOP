package lab1ex4;

public class Course {
    private String name;
    private String description;
    private int numberOfCredits;
    private String prerequisite;
    public Course(String name, String description, int numberOfCredits, String prerequisite) {
        this.name = name;
        this.description = description;
        this.numberOfCredits = numberOfCredits;
        this.prerequisite = prerequisite;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getNumberOfCredits() {
        return numberOfCredits;
    }
    public String getPrerequisite() {
        return prerequisite;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }
}