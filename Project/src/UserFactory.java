public interface UserFactory {
    User createUser(UserType userType, String name, String email, String password, String employeeId, DepartmentType department, Schools school, DegreeType degreeType, Language language, UniversityDataStore dataStore);
}
