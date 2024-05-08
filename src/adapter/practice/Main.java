package adapter.practice;

import adapter.practice.FileIO;
import adapter.practice.FilePropertiesByInheritance;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIO f = new FilePropertiesByDelegation();
//        FileIO f = new FilePropertiesByInheritance();
        try {
            f.readFromFile("file.txt");
            f.setValue("year", "2004");
            f.setValue("month", "4");
            f.setValue("day", "21");
            f.writeToFile("newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
