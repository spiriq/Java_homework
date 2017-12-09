public class Rot13 {
    public static String rot13 (String s) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            output.append(c);
        }
        return output.toString();
    }

    public static void main (String[] args){
        String a = args[0];
        System.out.println("Given string: " + a);
        System.out.println("Encoded string: " + rot13(a));
        System.out.println("Decoded string: " + rot13(rot13(a)));
    }
}