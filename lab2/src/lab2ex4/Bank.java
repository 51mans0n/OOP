package lab2ex4;

import java.util.Vector;
public class Bank {
    private Vector<Account> accounts;

    public Bank() {
        accounts = new Vector<>();
    }
    public void openAccount(Account account) {
        account.print();
    }

    public void closeAccount(Account account) {
        accounts.remove(account);
    }
    public void addAccount(Account acc) {
        accounts.add(acc);
    }
    public Vector<Account> getAccounts() {
        return accounts;
    }

    public void update() {
        for (Account account : accounts) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).addInterest();
            }
            else if (account instanceof CheckingAccount) {

            }
        }
    }
}
