package view;

//A class that prints objects
public class OutputDriver implements Output {

    @Override
    public void print(Object object) {
        System.out.println(object);
    }

    @Override
    public void print(Object first, Object second, Object third) {
        System.out.printf("%-50s%-50s%s", first,second,third);


    }
}
