package classes.task8;

/*
 * Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 * Найти и вывести:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */

public class Customer {
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private int numberCreditCard;
    private int numberBankAccount;

    public Customer(int id, String surname, String name, String middleName, int numberCreditCard, int numberBankAccount) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.numberCreditCard = numberCreditCard;
        this.numberBankAccount = numberBankAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getNumberCreditCard() {
        return numberCreditCard;
    }

    public void setNumberCreditCard(int numberCreditCard) {
        this.numberCreditCard = numberCreditCard;
    }

    public int getNumberBankAccount() {
        return numberBankAccount;
    }

    public void setNumberBankAccount(int numberBankAccount) {
        this.numberBankAccount = numberBankAccount;
    }

    @Override
    public String toString() {
        return "Customer {" +
                "id= " + id +
                ", surname= '" + surname + '\'' +
                ", name= '" + name + '\'' +
                ", middle_name= '" + middleName + '\'' +
                ", number_credit_card= " + numberCreditCard +
                ", number_bank_account= " + numberBankAccount +
                '}';
    }
}
