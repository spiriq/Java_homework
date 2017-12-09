import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args)  throws IOException {
        System.out.println("Enter a character to find: ");
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);

        Long counter = Files
                .lines(Paths.get("C:/Users/Spiriq/IdeaProjects/Java_intro/Task_6/Text.txt"))
                .flatMapToInt(CharSequence::chars)
                .filter(a -> a == c)
                .count();

        System.out.println("Character " + c + "appeared " + counter + " times in given text");
    }
}
