import java.io.Serializable;
import java.util.List;

public class Admin extends Employee implements Serializable {
    private UniversityDataStore dataStore;

    public Admin(String name, String email, String password, String employeeId, DepartmentType department, UniversityDataStore dataStore, Language language) {
        super(name, email, password, employeeId, department, language);
        this.dataStore = dataStore;
    }

    public void createUser(UserType userType, String name, String email, String password, String employeeId, DepartmentType department, Schools school, DegreeType degreeType, Language language, UniversityDataStore dataStore) {
        User newUser = ConcreteUserFactory.getInstance().createUser(userType, name, email, password, employeeId, department, school, degreeType, language, dataStore);
        dataStore.addUser(newUser);
        dataStore.addLogEntry(this.getEmail(), "Created user: " + name + " with role " + userType);
    }

    public void deleteUser(String userEmail) {
        User user = dataStore.getUserByEmail(userEmail);
        if (user != null) {
            dataStore.deleteUser(user);
            dataStore.addLogEntry(this.getEmail(), "Deleted user: " + userEmail);
        }
    }
    public void viewAllUsers() {
        List<User> users = dataStore.getUsers();
        if (users.isEmpty()) {
            if (this.getLanguage() == Language.EN) {
                System.out.println("There are no users in the system.");
            }
            else if (this.getLanguage() == Language.RU) {
                System.out.println("В системе нет пользователей.");
            }
            else {
                System.out.println("Жүйеде пайдаланушылар жоқ.");
            }
            return;
        }

        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public List<LogEntry> viewLogs() {
        return dataStore.getLogs();
    }
    @Override
    public String toString() {
        return "Admin{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", department=" + department +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
