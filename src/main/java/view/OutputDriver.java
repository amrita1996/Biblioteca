package view;

//A class that prints objects
public class OutputDriver implements Output {

    @Override
    public void print(Object object) {
        System.out.println(object);
    }

    @Override
    public void print(Object first, Object second, Object third) {
        System.out.printf("%-50s%-50s%-50s", first, second, third);


    }

    @Override
    public void printHorizontalLine(int number) {
        System.out.print("\n");
        for (int i = 0; i <number ; i++) {
            System.out.print("-");
        }

    }
}
