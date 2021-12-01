package GreedyAlgorithms;

import java.util.Scanner;

public class MaximumNumberOfPrizes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long i = 0;
        while ((double) (i + 1) / 2 <= (double) n / i) {
            i++;
        }
        i--;
        System.out.println(i);
        int j;
        long sum = 0;
        for (j = 1; j < i && sum < n; j++) {
            sum = sum + j;
            System.out.println(j);
        }
        System.out.println(n - sum);
        sc.close();
    }

}
