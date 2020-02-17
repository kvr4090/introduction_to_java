package oop.task4.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Treasure {

    private String name;
    private int cost;

    public Treasure() throws IOException {
        this.name = addTreasureName();
        this.cost = addTreasurePrice();
    }

    public Treasure(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    private String addTreasureName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите наименование сокровища: ");
        String  name = reader.readLine();
        reader.close();

        if (name.equals("")) {
            System.out.println("Введена пустая строка!");
            addTreasureName();
        } else {
            Pattern patternName = Pattern.compile("[^А-я\\s]");
            Matcher matcher = patternName.matcher(name);

            if (!matcher.find()) {
                return name;
            } else {
                System.out.println("Имя содержит недопустимые символы!");
                addTreasureName();
            }
        }
        return name;
    }

    private int addTreasurePrice() throws IOException {
        System.out.print("Введите стоимость сокровища: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp = reader.readLine();
        reader.close();

        if (temp.equals("")) {
            System.out.println("Введена пустая строка!");
            addTreasurePrice();
        } else {
            Pattern patternCost = Pattern.compile("[0-9]");
            Matcher matcher = patternCost.matcher(temp);

            if (matcher.find()) {
                return Integer.parseInt(temp);
            } else {
                System.out.println("Стоимость содержит недопустимые символы!");
                addTreasurePrice();
            }
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
