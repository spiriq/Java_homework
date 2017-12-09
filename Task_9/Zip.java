import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javafx.util.Pair;

public class Zip {
    private static <A, B> Stream<Pair<A,B>> zip (Stream<A> first, Stream<B> second){
        Iterator<A> i = first.iterator();
        return second.filter(x -> i.hasNext()).map(b -> new Pair<>(i.next(), b));
    }

    public static void main(String[] args){
        Stream<Integer> odd = IntStream.iterate(1, x -> x + 2).limit(3).boxed();
        Stream<Integer> even = IntStream.iterate(2, x -> x + 2).limit(15).boxed();

        Stream res = zip(odd, even);
        res.forEach(i -> System.out.println(i));
    }
}
