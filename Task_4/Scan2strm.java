import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Scan2strm {
    public static Stream wordsStrm(Scanner sc) {
        Spliterator<String> split = Spliterators.spliterator(sc, Long.MAX_VALUE, Spliterator.NONNULL | Spliterator.ORDERED);
        return StreamSupport.stream(split, false);
    }

    public static IntStream intStrm(Scanner sc) {
        Spliterator.OfInt split = Spliterators.spliterator(new PrimitiveIterator.OfInt() {
            @Override
            public int nextInt() {
                return sc.nextInt();
            }

            @Override
            public boolean hasNext() {
                return sc.hasNextInt();
            }
        }, Long.MAX_VALUE, Spliterator.NONNULL | Spliterator.ORDERED);
        return StreamSupport.intStream(split, false);
    }

    public static DoubleStream doublesStrm (Scanner sc){
        Spliterator.OfDouble split = Spliterators.spliterator(new PrimitiveIterator.OfDouble() {

            @Override
            public boolean hasNext() {
                return sc.hasNextDouble();
            }

            @Override
            public double nextDouble() {
                return sc.nextDouble();
            }
        }, Long.MAX_VALUE, Spliterator.NONNULL | Spliterator.ORDERED);
        return StreamSupport.doubleStream(split, false);
    }

    public static void main(String[] args){
        String words = "wow doge splitting scanner 8o8 100";
        String numbers = "240 120 51 123";
        String doubles = "15.123 0.2131 54.1231";

        try (Scanner sc = new Scanner(words).useDelimiter(" ")) {
            Stream strm = wordsStrm(sc);
            strm.forEach(System.out::println);
        }

        System.out.println("__________\n");

        try (Scanner sc = new Scanner(numbers).useDelimiter(" ")) {
            IntStream strm = intStrm(sc);
            strm.forEach(System.out::println);
        }

        System.out.println("__________\n");

        try (Scanner sc = new Scanner(doubles).useDelimiter(" ")) {
            DoubleStream strm = doublesStrm(sc);
            strm.forEach(System.out::println);
        }
    }
}
