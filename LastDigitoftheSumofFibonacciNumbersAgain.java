import java.util.Scanner;

public class LastDigitoftheSumofFibonacciNumbersAgain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long n = sc.nextLong();

        long modulo = 10;
        long prev = 0, curr = 1;
        long sumPrev = 0;
        long sumNext = 0;
        for (int i = 2; i < n+2; i++) {
            long temp = curr % modulo;
            curr = prev + curr;
            prev = temp;

            curr = curr % modulo;
            sumNext += curr;
            sumNext = sumNext % modulo;
            if(i == m + 1) sumPrev = sumNext;
        }

        sumPrev = m==1? 1 : sumPrev;
        sumNext = n == 1? 1: sumNext - sumPrev;
        if(n == 1)System.out.println(1);
        else System.out.println((sumNext) % 10);

        sc.close();
    }
    
}
