package oop.task4.game;

import oop.task4.resource.DragonCave;
import oop.task4.resource.Treasure;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 * Приложение должно быть объектно-, а не процедурно-ориентированным.
 * Каждый класс должен иметь отражающее смысл название и информативный состав.
 * Наследование должно применяться только тогда, когда это имеет смысл.
 * При кодировании должны быть использованы соглашения об оформлении кода java code convention.
 * Классы должны быть грамотно разложены по пакетам.
 * Консольное меню должно быть минимальным.
 * Для хранения данных можно использовать файлы.
 * Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
 * дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
 * выбора сокровищ на заданную сумму.
 */

public class TreasureCave {
    private ArrayList<Integer> playerList;
    private ArrayList<Treasure> gameList;

    public void run() throws IOException {
        DragonCave dragonCave;
        System.out.println("Заполните пещеру сокровищами. Для заполнения вручную введите 1\n" +
                "Для загрузки готовой пещеры из файла, введите 2 и введите директорию файла.");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String choice = reader.readLine();

            if (choice.equals("")) {
                System.out.println("Введена пустая строка!");
                run();
            } else {
                Pattern patternCost = Pattern.compile("[1-2]");
                Matcher matcher = patternCost.matcher(choice);

                if (matcher.find()) {
                    int temp = Integer.parseInt(choice);

                    if (temp == 1) {
                        dragonCave = new DragonCave();
                        setGameList(dragonCave.getTreasures());
                        valueMenu(dragonCave);
                    }

                    if (temp == 2) {
                        dragonCave = new DragonCave(reader.readLine());
                        setGameList(dragonCave.getTreasures());
                        valueMenu(dragonCave);
                    }
                } else {
                    System.out.println("Вводите что-то не то.");
                    run();
                }
            }
        }
    }

    private void valueMenu(DragonCave dragonCave) throws IOException {
        int value = 0;
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("\nДля просмотра сокровищ введите 1\n" +
                    "Для получения самого дорогого по стоимости сокровища введите 2\n" +
                    "Для выбора сокровищ на заданную сумму, введите 3 и введите сумму.\n" +
                    "Для сохранения списка сокровищ введите 4, и введите директорию файла для сохранения.\n" +
                    "Для выхода нажмите 5.");
            String temp = reader.readLine();

            if (temp.equals("")) {
                System.out.println("Введена пустая строка!");
                valueMenu(dragonCave);
            } else {
                Pattern patternCost = Pattern.compile("[1-5]");
                Matcher matcher = patternCost.matcher(temp);

                if (matcher.find()) {
                    value = Integer.parseInt(temp);
                } else {
                    System.out.println("Вводите что-то не то.");
                    valueMenu(dragonCave);
                }
            }

            if (value == 1) {
                dragonCave.browseAllTreasures();
                valueMenu(dragonCave);
            }

            if (value == 2) {
                dragonCave.getMostExpensiveTreasure();
                valueMenu(dragonCave);
            }

            if (value == 3) {
                String sum = reader.readLine();

                if (sum.equals("")) {
                    System.out.println("Введена пустая строка!");
                } else {
                    Pattern patternSum = Pattern.compile("[0-9]");
                    Matcher matcher = patternSum.matcher(sum);

                    if (matcher.find()) {
                        if (Integer.parseInt(sum) > sumTreasures()) {
                            System.out.println("Слишком большая сумма.");
                        } else {
                            selectTreasuresToSum(Integer.parseInt(sum));
                        }
                    } else {
                        System.out.println("Сумма содержит недопустимые символы!");
                    }
                }
                valueMenu(dragonCave);
            }

            if (value == 4) {
                dragonCave.saveDragonCaveToFile(reader.readLine());
                valueMenu(dragonCave);
            }

            if (value == 5) {
                System.out.println("До свидания!");
            }
        }
    }

    private int sumTreasures() {
        int sum = 0;

        for (Treasure current : gameList) {
            sum += current.getCost();
        }
        return sum;
    }

    private void setGameList(ArrayList<Treasure> gameList) {
        this.gameList = gameList;
    }

    private void selectTreasuresToSum(int selectedSum) throws IOException {
        int currentSum = 0;
        int temp;
        playerList = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (selectedSum > currentSum) {
                System.out.print("Введите номер сокровища от 1 до 100: ");
                String numberTreasure = reader.readLine();

                if (numberTreasure.equals("")) {
                    System.out.println("Введена пустая строка!");
                } else {
                    Pattern patternCost = Pattern.compile("[0-9]");
                    Matcher matcher = patternCost.matcher(numberTreasure);

                    if (matcher.find()) {
                        temp = Integer.parseInt(numberTreasure);

                        if ((temp > 0) && (temp <= 100)) {
                            if (isContains(temp)) {
                                System.out.println("Вы уже выбирали это сокровище!");
                            } else {
                                if ((currentSum + gameList.get(temp - 1).getCost()) > selectedSum) {
                                    System.out.println("Будет превышена заданная сумма сокровищ. Выберите другое сокровище. " +
                                            "Остаток: " + (selectedSum-currentSum));
                                } else {
                                    playerList.add(temp);
                                    currentSum += gameList.get(temp - 1).getCost();
                                }

                                if (selectedSum == currentSum) {
                                    System.out.println("Вы набрали сокровищ на заданную сумму.");

                                    for (int number : playerList) {
                                        System.out.print(gameList.get(number).getName() + ", " + gameList.get(number).getCost() + " ");
                                    }
                                    System.out.println();
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Номер вне диапазона!");
                        }
                    } else {
                        System.out.println("Введены недопустимые символы!");
                    }
                }
            }
        }
    }

    private boolean isContains(int i) {
        boolean result = false;

        for (int current : playerList) {
            if (current == i) {
                result = true;
                break;
            }
        }
        return result;
    }
}
