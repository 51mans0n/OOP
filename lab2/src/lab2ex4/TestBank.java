package lab2ex4;

public class TestBank {
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount sa = new SavingsAccount(1, 5);
        CheckingAccount ca = new CheckingAccount(1);

        bank.addAccount(sa);
        bank.addAccount(ca);

        sa.deposit(1000);
        ca.withdraw(100);

        for (Account acc : bank.getAccounts()) {
            acc.print();
        }

        sa.addInterest();

        for (Account acc : bank.getAccounts()) {
            acc.print();
        }

        bank.update();

        for (Account acc : bank.getAccounts()) {
            acc.print();
        }
        bank.openAccount(ca);
    }
}

