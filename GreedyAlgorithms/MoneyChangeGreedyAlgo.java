package GreedyAlgorithms;
import java.util.Scanner;

public class MoneyChangeGreedyAlgo {
    public static void main(String[] args) {
        final int deno10 = 10, deno5= 5;

        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long result = 0;
        if(num / deno10 > 0) {
            result = num / deno10;
            num = num % deno10;
        }
        if(num / deno5 > 0) {
            result += num / deno5;
            num = num % deno5;
        }
        result += num;
        System.out.println(result);
        sc.close();
    }
}
