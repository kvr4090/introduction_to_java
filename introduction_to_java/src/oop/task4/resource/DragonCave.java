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

        try (FileReader fileReader = new FileReader(directory);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
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
            }
        }

        for (int i = 0; i < 100; i++) {
            listTreasure.add(new Treasure(listName.get(i), listCost.get(i)));
        }
        return listTreasure;
    }

    public void saveDragonCaveToFile(String directory) throws IOException  {
        String text = "";

        try (FileWriter fileWriter = new FileWriter(directory);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Treasure current : treasures) {
                text = text.concat(current.getName() + (int)current.getCost());
            }
            bufferedWriter.write(text);
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

            if (temp == 10) {
                System.out.println();
                temp = 0;
            }
        }
    }
}
