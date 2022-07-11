import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

//        Scanner sc = new Scanner(System.in);

//        System.out.println("Hello!");
//        System.out.println(Math.random());
//        System.out.println("there");

        File file = new File("C:\\Users\\anurag.pandey\\Documents\\file.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

        sc.close();
    }
}