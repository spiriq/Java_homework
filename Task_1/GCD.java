import java.util.Scanner;

public class GCD {
    // % version
    public static int gcd (int a, int b){
        while (a != 0 && b != 0) {
            if (Math.abs(a) > Math.abs(b)){
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        return a | b;
    }

    // floorMod version
    public static int gcdFloor(int a,int b) {
        while (a != 0 && b!= 0){
            if (Math.abs(a) > Math.abs(b)){
                a = Math.floorMod(a, b);
            }
            else {
                b = Math.floorMod(b, a);
            }
        }
        return a | b;
    }

    // remainder function
    public static int myRem (int a, int b) {
        if (b < 0) {
            return myRem(a, -b);
        }
        if (a < 0) {
            return myRem(-a, b);
        }
        while (a >= b) {
            a = a - b;
        }
        return a;
    }

    // myRem version
    public static int gcdRem(int a, int b) {
        while (a != 0 && b!= 0){
            if (Math.abs(a) > Math.abs(b)){
                a = myRem(a,b);
            }
            else {
                b = myRem(b,a);
            }
        }
        return a | b;
    }

    public static void main(String[] args) {
        System.out.println("Enter two numbers: ");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        System.out.println("% gcd: " + gcd(a, b));
        System.out.println("FloorMod gcd : " + gcdFloor(a, b));
        System.out.println("myRem gcd : " + gcdRem(a, b));
    }
}