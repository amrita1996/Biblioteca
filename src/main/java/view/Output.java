package view;

import java.util.List;

public interface Output {
    public void print(String string);

    public void print(List<String> strings);

    void printHorizontalLine(int number);

    public void splitAndPrint(String string);
}
