package oop.task4.resource;

import oop.task4.game.TreasureCave;

import java.io.*;
import java.util.ArrayList;

public class DragonCave {
    private ArrayList<Treasure> treasures;

    public DragonCave() throws IOException {
        this.treasures = addTreasuresToCave();
    }
    public DragonCave(String directory) throws IOException {
        this.treasures = loadTreasureListFromFile(directory);
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    private ArrayList<Treasure> addTreasuresToCave() throws IOException {
        ArrayList<Treasure> listTreasure = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            listTreasure.add(new Treasure());
        }
        return listTreasure;
    }

    private ArrayList<Treasure> loadTreasureListFromFile(String directory) throws IOException {
        String temp;
        String treasureName = "";
        String treasureCost = "";
        ArrayList<Treasure> listTreasure = new ArrayList<>();
        ArrayList<String> listName = new ArrayList<>();
        ArrayList<Integer> listCost = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(directory));
            while ((temp = bufferedReader.readLine()) != null) {
                char[] symbol = temp.toCharArray();

                for (char c : symbol) {
                    if (Character.isLetter(c)) {
                        if (!treasureCost.equals("")) {
                            listCost.add(Integer.parseInt(treasureCost));
                            treasureCost = "";
                        }
                        treasureName = treasureName.concat(Character.toString(c));
                    } else {
                        if (!treasureName.equals("")) {
                            listName.add(treasureName);
                            treasureName = "";
                        }
                        treasureCost = treasureCost.concat(Character.toString(c));
                    }
                }
                listCost.add(Integer.parseInt(treasureCost));

                for (int i = 0; i < 100; i++) {
                    listTreasure.add(new Treasure(listName.get(i) , listCost.get(i)));
                }
                return listTreasure;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Не удается найти указанный файл");
        }
        return listTreasure;
    }

    public void saveDragonCaveToFile(String directory)  {
        String text = "";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(directory));

            for (Treasure current : treasures) {
                text = text.concat(current.getName() + (int)current.getCost());
            }
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл на найден!");
        } catch (IOException a) {
            System.out.println("Что-то ввели не так!");
        }
    }

    public void getMostExpensiveTreasure() {
        Treasure theMostExpensive = treasures.get(0);

        for (Treasure current : treasures) {
            if (current.getCost() > theMostExpensive.getCost()) {
                theMostExpensive = current;
            }
        }
        System.out.println(theMostExpensive.getName() + ", " + theMostExpensive.getCost());
    }

    public void browseAllTreasures() {
        int temp = 0;

        for (Treasure current : treasures) {
            System.out.print(current.getName() + "," + current.getCost() + "\t");
            temp++;

            if (temp == 10){
                System.out.println();
                temp = 0;
            }
        }
    }
}