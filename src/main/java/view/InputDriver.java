package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputDriver implements Input {
    @Override
    public String read() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String value = null;
        try {
            value = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
