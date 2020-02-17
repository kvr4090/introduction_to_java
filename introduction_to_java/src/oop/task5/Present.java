package oop.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 * Корректно спроектируйте и реализуйте предметную область задачи.
 * Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов
 * проектирования.
 * Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
 * для проверки корректности переданных данных можно применить регулярные выражения.
 * Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
 * Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().
 * Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой
 * подарок). Составляющими целого подарка являются сладости и упаковка.
 */

public class Present {
    private ArrayList<Candy> candies;
    private Packing packing;

    private Present() {
    }

    public static PresentBuilder presentBuild() throws IOException {
        return new Present().new PresentBuilder();
    }

    public class PresentBuilder {

        private PresentBuilder() throws IOException {
            addCandyList();
            addPacking();

            if (!canBeMade()) {
                System.out.println("Эта упаковка не подходит. Слишком маленькая.");
                addPacking();
            }
            showPresent();
        }

        public void addCandyList() throws IOException {
            String name;
            double weight;
            double volume;
            String text = "Введите сладость: наименование, вес, объём. Если сладостей достаточно, введите \"готов\".";
            candies = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println(text);

                while (true) {
                    name = reader.readLine();

                    if (name.equals("готов")) {
                        break;
                    } else if (isText(name)) {
                        String temp = reader.readLine();

                        if (isTrueNumber(temp)) {
                            weight = Double.parseDouble(temp);
                        } else {
                            System.out.println("Неверный вес!");
                            System.out.println(text);
                            continue;
                        }

                        temp = reader.readLine();

                        if (isTrueNumber(temp)) {
                            volume = Double.parseDouble(temp);

                        } else {
                            System.out.println("Неверный объём!");
                            System.out.println(text);
                            continue;
                        }

                        candies.add(new Candy(name, weight, volume));
                        System.out.println("Сладость добавлена.\n"+ text);
                    } else {
                        System.out.println("Ошибка в переданных параметрах. Сладость не добавлена в подарок.");
                        System.out.println(text);
                    }
                }       
            }
        }

        public void addPacking() throws IOException {
            String color;
            String type;
            String material;
            String temp;
            double weight = 0;
            double volume = 0;
            System.out.println("Введите данные об упаковке: цвет, тип, материал, максимальный вес и объём.");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                color = reader.readLine();
                type = reader.readLine();
                material = reader.readLine();
                temp = reader.readLine();

                if (isTrueNumber(temp)) {
                    weight = Double.parseDouble(temp);

                } else {
                    System.out.println("Ошибка в переданных параметрах. Упаковка не принята.");
                    addPacking();
                }

                temp = reader.readLine();

                if (isTrueNumber(temp)) {
                    volume = Double.parseDouble(temp);

                } else {
                    System.out.println("Ошибка в переданных параметрах. Упаковка не принята.");
                    addPacking();
                }

                if (isText(color) && isText(type) && isText(material)) {
                    packing = new Packing(color, type, material, weight, volume);

                } else {
                    System.out.println("Ошибка в переданных параметрах. Упаковка не принята.");
                    addPacking();
                }   
            }
        }

        public boolean canBeMade(){
            double presentWeight = 0;
            double presentVolume = 0;

            for (Candy current : candies) {
                presentVolume += current.getVolume();
                presentWeight += current.getWeight();
            }
            return ((presentVolume <= packing.getMaxVolume()) && (presentWeight <= packing.getMaxWeight()));
        }

        public boolean isText(String name){
            Pattern pattern = Pattern.compile("[А-яA-z\\s]+");
            Matcher matcher = pattern.matcher(name);
            return matcher.matches();
        }

        public boolean isTrueNumber(String string) {
            if (string.equals("")) {
                System.out.println("Введена пустая строка!");
                return false;
            } else {
                Pattern pattern = Pattern.compile("[^\\d.]");
                Matcher matcher = pattern.matcher(string);

                if (!matcher.find()) {
                    return Double.parseDouble(string) > 0;
                } else {
                    System.out.println("Недопустимые символы!");
                    return false;
                }
            }
        }

        public void showPresent(){
            System.out.println("Подарок готов, он состоит из:");

            for (Candy current : candies) {
                System.out.print(current.getName() + " ");
            }
            System.out.println();
            System.out.println("Упакован в " + packing.getMaterial() + " " + packing.getType()+", " + packing.getColor() + " цвет.");
        }

        public Present build() {
            return Present.this;
        }
    }
}
