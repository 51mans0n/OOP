import java.io.Serializable;
public abstract class User implements Serializable{
    protected String name;
    protected String email;
    protected String password;
    protected Language language;
    private static final long serialVersionUID = 1L;

    public User(String name, String email, String password, Language language) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.language = Language.EN; // По умолчанию язык системы - английский
    }

    public boolean login(String password) {
        return this.password.equals(password);
    }

    public void logout() {
        // Так и должно быть пустым, вся логика в UniversitySystemApp
    }

    // Dependency injection
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Language getLanguage() {
        return language;
    }
    public void setLanguage(Language language) {
        this.language = language;
    }
    public void changeLanguage(Language newLanguage) {
        this.language = newLanguage;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}

