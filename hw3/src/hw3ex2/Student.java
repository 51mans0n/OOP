package hw3ex2;

public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee){
        super(name,address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }
    public void setProgram(String program) {
        this.program = program;
    }
    public String getProgram() {
        return program;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }
    public double getFee() {
        return fee;
    }
    @Override
    public String toString() {
        return "Student - " + super.toString() + ", program = " + program + ", year = " + year + ", fee = " + fee ;
    }
}