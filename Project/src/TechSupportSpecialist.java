import java.util.List;
import java.util.ArrayList;

public class TechSupportSpecialist extends Employee {
    private List<Complaint> assignedComplaints;

    public TechSupportSpecialist(String name, String email, String password, String employeeId, DepartmentType department, Language language) {
        super(name, email, password, employeeId, department, language);
        this.assignedComplaints = new ArrayList<>();
    }

    public void assignComplaint(Complaint complaint) {
        assignedComplaints.add(complaint);
    }

    public void resolveComplaint(Complaint complaint) {
        complaint.setStatus(ComplaintStatus.CLOSED);
        // Дополнительная логика по обработке жалобы...
    }

    public List<Complaint> getAssignedComplaints() {
        return assignedComplaints;
    }
}
