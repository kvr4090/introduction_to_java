package classes.task14;

import java.math.BigDecimal;

public class BankAccount {
    private Client owner;
    private int number;
    private BigDecimal balance;
    private boolean lock;

    public BankAccount(Client owner, int number, BigDecimal balance, boolean lock) {
        this.owner = owner;
        this.number = number;
        this.balance = balance;
        this.lock = lock;
    }

    public void setBalance(BigDecimal balance) {
        if (!lock) {
            this.balance = balance;
        } else {
            System.out.println("Счёт заблокирован!");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public Client getOwner() {
        return owner;
    }

    public int getNumber() {
        return number;
    }
}
