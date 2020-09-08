package rtu.pract2;

public class Pract2 {
    public static void main(String[] args) {
        Author author = new Author("Timur Tugushev", "timurka.tugushev@gmail.com", 'M');
        System.out.println(author);
        System.out.println("Lower case name is: " + author.getName().toLowerCase());
    }
}
