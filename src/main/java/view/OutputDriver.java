package view;

import java.sql.SQLOutput;
import java.util.List;

//A class that prints objects
public class OutputDriver implements Output {

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public void print(List<String> strings) {
        for (String string : strings) {
            splitAndPrint(string);
        }
    }

    public void splitAndPrint(String string) {
        System.out.println();
        String stringSplit[] = string.split("-");
        for (String stringIndex:stringSplit) {
            System.out.printf("%-50s", stringIndex);
        }
    }

    @Override
    public void printHorizontalLine(int number) {
        System.out.print("\n");
        for (int i = 0; i <number ; i++) {
            System.out.print("-");
        }

    }
}
