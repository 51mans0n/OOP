public class ConcreteUserFactory implements UserFactory {
    private UniversityDataStore dataStore;
    private static ConcreteUserFactory instance;
    // Singleton
    private ConcreteUserFactory() {
        // Закрытый конструктор предотвращает прямое создание объекта
    }
    public ConcreteUserFactory(UniversityDataStore dataStore) {
        this.dataStore = dataStore;
    }
    public static ConcreteUserFactory getInstance() { // Возвращает единственный экземпляр ConcreteUserFactory
        if (instance == null) {
            instance = new ConcreteUserFactory();
        }
        return instance;
    }
    // Factory Design Pattern
    @Override
    public User createUser(UserType userType, String name, String email, String password, String employeeId, DepartmentType department, Schools school, DegreeType degreeType, Language language, UniversityDataStore dataStore) {
        switch (userType) {
            case STUDENT:
                return new Student(name, email, password, school, language);
            case GRADUATE_STUDENT:
                return new GraduateStudent(name, email, password, degreeType, school, language);
            case ADMIN:
                return new Admin(name, email, password, employeeId, DepartmentType.ADMINISTRATION, dataStore, language);
            case TECH_SUPPORT:
                return new TechSupportSpecialist(name, email, password, employeeId, DepartmentType.ADMINISTRATION, language);
            case TEACHER:
                return new Teacher(name, email, password, employeeId, DepartmentType.EDUCATION, language, dataStore);
            case MANAGER:
                return new Manager(name, email, password, employeeId, DepartmentType.DEAN_OFFICE, language);
            default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
        }
    }
}
