import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Walker {
    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        private static final String FIRST = "transient";
        private static final String SECOND = "volatile";

        public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
            if (path.getFileName().toString().contains(".java"))
                try {
                    String content = new String(Files.readAllBytes(path));

                    boolean containsFirst = false;
                    if (content.contains(FIRST))
                        containsFirst = true;

                    boolean containsSecond = false;
                    if (content.contains(SECOND))
                        containsSecond = true;

                    if (containsFirst && containsSecond)
                        System.out.println(path);

                } catch (IOException e) {
                    System.out.println(e);
                }

            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args){
        Path path = Paths.get("C:/Program Files/Java/jdk1.8.0_144/src");

        try {
            Files.walkFileTree(path, new MyFileVisitor());
            System.out.println("Visited");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}