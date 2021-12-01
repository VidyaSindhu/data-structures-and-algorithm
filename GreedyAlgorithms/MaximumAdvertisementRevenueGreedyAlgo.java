package GreedyAlgorithms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MaximumAdvertisementRevenueGreedyAlgo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> pricePerClickArray = new ArrayList<Long>();
        ArrayList<Long> averageClicks = new ArrayList<Long>();

        for (int i = 0; i < n; i++) {
            pricePerClickArray.add(sc.nextLong());
        }
        for (int i = 0; i < n; i++) {
            averageClicks.add(sc.nextLong());
        }
        Collections.sort(pricePerClickArray);
        Collections.sort(averageClicks);

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += pricePerClickArray.get(i) * averageClicks.get(i);
        }
        
        System.out.println(result);
        sc.close();

    }
}