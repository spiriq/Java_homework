import java.util.Scanner;

public class Hex{
    public static int hex2Dec(String s) {
        int output = 0;
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            output = 16*output + d;
        }
        return output;
    }

    public static void main(String[] args){
        // 3e8 -> 1000
        System.out.println("Enter desired HEX: ");
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        System.out.println("Given HEX to DEC: " + hex2Dec(a));
    }
}