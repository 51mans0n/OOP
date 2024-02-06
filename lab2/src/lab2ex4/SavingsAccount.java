package lab2ex4;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int a, double interestRate) {
        super(a);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        deposit(getBalance() * interestRate / 100);
    }
}
