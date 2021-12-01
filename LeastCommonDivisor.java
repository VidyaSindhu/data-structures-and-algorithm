import java.util.*;

public class LeastCommonDivisor {

    public static long gcd(Long a, long b) {
        if(b % a == 0) return a;
        return gcd(b%a, a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long gcdab = gcd(a,b);
        System.out.println(a*b/gcdab);
        sc.close();
    }
}
