import java.util.stream.Stream;

public class MyInfRand {
    public static class Randomizer {
        private  long a;
        private  long c;
        private  long m;

        public Randomizer(long a,long c, long m){
            this.a = a;
            this.c = c;
            this.m = m;
        }

        public long getNext(long prev) {
            return (this.a * prev + this.c) % this.m;
        }
    }

    public static void main(String[] args){
        final long l2pow48 = 281474976710656L;
        final Randomizer rand = new Randomizer(25214903917l, 11l, l2pow48);
        Stream<Long>stream = Stream.iterate(31l, rand::getNext).limit(10);
        stream.forEach(System.out::println);
    }
}
