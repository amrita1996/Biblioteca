package view;

//A class that prints objects
public class OutputDriver implements Output {

    @Override
    public void print(Object object) {
        System.out.println(object);
    }
}
