package classes.task14;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/*
 * Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
 * счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
 * всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

public class Bank {

    private BankAccount[] bankAccounts;

    public void lockAccount(BankAccount bankAccount) {
        bankAccount.setLock(true);
    }

    public void unlockAccount(BankAccount bankAccount) {
        bankAccount.setLock(false);
    }

    private BankAccount searchAccount(Client client) {
        for (BankAccount account : bankAccounts) {
            if (account.getOwner().getName().equals(client.getName())) {
                return account;
            }
        }
        return null;
    }

    public BankAccount searchAccountNum(int number) {
        for (BankAccount account : bankAccounts) {
            if (account.getNumber() == number) {
                return account;
            }
        }
        return null;
    }

    public void sortToNumbers() {
        Arrays.sort(bankAccounts, Comparator.comparingInt(BankAccount::getNumber));
    }

    public void sortToBalance() {
        Arrays.sort(bankAccounts, Comparator.comparing(BankAccount::getBalance));
    }

    public void sortAlphabetOwner() {
        Arrays.sort(bankAccounts,  Comparator.comparing(o -> o.getOwner().getName()));
    }

    public BigDecimal sumTotal() {
        BigDecimal sum = BigDecimal.valueOf(0);

        for (BankAccount account : bankAccounts) {
            sum = sum.add(account.getBalance());
        }
        return sum;
    }

    public BigDecimal sumTotalPositive() {
        BigDecimal sum = BigDecimal.valueOf(0);

        for (BankAccount account : bankAccounts) {
            if (account.getBalance().compareTo(BigDecimal.valueOf(0)) > 0) {
                sum = sum.add(account.getBalance());
            }
        }
        return sum;
    }

    public BigDecimal sumTotalNegative() {
        BigDecimal sum = BigDecimal.valueOf(0);

        for (BankAccount account : bankAccounts) {
            if (account.getBalance().compareTo(BigDecimal.valueOf(0)) < 0) {
                sum = sum.add(account.getBalance());
            }
        }
        return sum;
    }
}
