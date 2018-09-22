package view;

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
            String stringSplit[] = string.split("-");
            System.out.printf("%-50s%-50s%-50s", stringSplit[0], stringSplit[1], stringSplit[2]);
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
