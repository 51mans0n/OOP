package lab3ex4;

import java.util.Date;

public class Employee extends Person implements Comparable<Object> {
    private double salary;
    private Date hireDate;
    private String insuranceNumber;
    public Employee (String name, double salary, Date hireDate, String insuranceNumber) {
        super(name);
        this.salary = salary;
        this.hireDate = hireDate;
        this.insuranceNumber = insuranceNumber;
    }
    public double getSalary() {
        return salary;
    }
    public String getInsuranceNumber() {
        return insuranceNumber;
    }
    public Date getHireDate() {
        return hireDate;
    }
    public void setSalary (double salary) {
        this.salary = salary;
    }
    public void setHireDate (Date hireDate) {
        this.hireDate = hireDate;
    }
    public void setInsuranceNumber (String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
    @Override
    public String toString() {
        return super.toString() + " Salary: " + getSalary() + " Hire date: " + getHireDate() + " and Insurance number: " + getInsuranceNumber();
    }
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;
        Employee e = (Employee)o;
        return e.hireDate == hireDate && e.insuranceNumber.equals(insuranceNumber) && e.salary == salary;
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e = (Employee) o;
            return Double.compare(this.getSalary(), e.getSalary());
        }
        return 0;
    }
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}
