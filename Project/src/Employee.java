public abstract class Employee extends User {
    protected String employeeId;
    protected DepartmentType department;

    public Employee(String name, String email, String password, String employeeId, DepartmentType department, Language language) {
        super(name, email, password, language);
        this.employeeId = employeeId;
        this.department = department;
    }

    // Методы, специфичные для сотрудника (не все)
    public void updatePersonalInformation(String newName, String newEmail) {
        setName(newName);
        setEmail(newEmail);
    }
    public void submitInquiry(Inquiry inquiry) {
        // Логика для подачи запроса
    }

    // Dependency injection
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public DepartmentType getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentType department) {
        this.department = department;
    }
}
