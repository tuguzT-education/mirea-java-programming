package rtu.lab11;

public class Lab11 {
    public static void main(String[] args) {
        try {
            Exercise4.saveCatalog("C:/");
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
