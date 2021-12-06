import java.util.HashMap;
import java.util.Scanner;

public class MoneyAgainChange2 {
    public static int minCoinsTopDown(int money, int coins[], HashMap<Integer, Integer> minCoins) {
        if(minCoins.get(money) != null) return minCoins.get(money);
        if(money == 0) return 0;
        else {
            int leastCoins = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++) {
                if(leastCoins > minCoinsTopDown(money-coins[i], coins, minCoins) + 1){
                    leastCoins = minCoinsTopDown(money-coins[i], coins, minCoins) + 1;
                }
            }
            minCoins.put(money, leastCoins);
        }
        return minCoins.get(money);
    
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        HashMap<Integer, Integer> minCoinsMap = new HashMap<Integer, Integer>();
        int[] coins = new int[] {
            1, 3 ,4
        };
        minCoinsMap.put(1, 1);
        minCoinsMap.put(2, 2);
        minCoinsMap.put(3, 1);
        minCoinsMap.put(4, 1);
        System.out.println(minCoinsTopDown(money, coins, minCoinsMap));
        sc.close();
    }
}
