import java.util.*;
class FibonacciNumbers{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long modulo = sc.nextLong();

        long curr = 1, prev = 0, pissanoPeriod = 0;
        // long modulo = 10;

        for (int i = 0; i < modulo * modulo; i++) {
            long temp = curr;
            curr = (prev + curr) % modulo;
            prev = temp;

            if (curr == 1 && prev == 0) {
                pissanoPeriod = i + 1;
            }
        }
        
        n = n % pissanoPeriod;
        long x1 = 0;
        long x2 = 1;
        long sum = x1;
        for(long i = 2; i < n+2; i++) {
            long temp = x1 % modulo;
            x1 = x1 + x2;
            x2 = temp;
            
            x1 = x1 % modulo;

            // temp = x1 % 10;
            sum += x1;
            // System.out.println(sum);
            sum = sum % modulo;
        }
        if(n == 1) System.out.println(1);
        else System.out.println(x1);
        sc.close();
    }
}