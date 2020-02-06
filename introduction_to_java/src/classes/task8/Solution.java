package classes.task8;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Найти и вывести:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */

public class Solution {
    Customer[] customers;

    public Solution(Customer[] customers) {
        this.customers = customers;
    }

    public void listSortAlphabet() {
        Comparator<Customer> comparatorMiddleName = Comparator.comparing(Customer::getMiddleName);
        Comparator<Customer> comparatorName = Comparator.comparing(Customer::getName);
        Comparator<Customer> comparatorSurname = Comparator.comparing(Customer::getSurname);
        Arrays.sort(customers, comparatorMiddleName);
        Arrays.sort(customers, comparatorName);
        Arrays.sort(customers, comparatorSurname);

        customersToScreen();
    }

    private void customersToScreen(){
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    public void listOnRange(int minValue, int maxValue) {
        for (Customer customer : customers) {
            int temp = customer.getNumberCreditCard();

            if ((temp > minValue) && (temp < maxValue)) {
                System.out.println(customer.toString());
            }
        }
    }
}
