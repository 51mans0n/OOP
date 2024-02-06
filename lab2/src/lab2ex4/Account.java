package lab2ex4;

public class Account {
    private double balance;
    private int accNumber;

    public Account(int a) {
        balance = 0.0;
        accNumber = a;
    }

    public void deposit(double sum) {
        balance += sum;
    }

    public void withdraw(double sum) {
        balance -= sum;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accNumber;
    }

    @Override
    public String toString() {
        return "Account number: " + accNumber + ", Balance: " + balance;
    }

    public final void print() {
        System.out.println(this.toString());
    }
}
