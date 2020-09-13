package rtu.lab8;

import java.io.FileReader;

public class Lab8 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("C:/Users/mi/Documents/" +
                    "IntelliJ Projects/RTU Java/src/rtu/lab8/file.txt");
            int ch;
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
