import java.util.*;

//Bottom-Up Approach

class MoneyChangeAgain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> coins = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
                add(4);
            }
        };
        int money = sc.nextInt();
        HashMap<Integer, Integer> minCoinsMap = new HashMap<Integer, Integer>();

        minCoinsMap.put(1, 1);
        minCoinsMap.put(2, 2);
        minCoinsMap.put(3, 1);
        minCoinsMap.put(4, 1);
        for(int j = 4; j < money; j++) {
            int leastCoins = Integer.MAX_VALUE;
            for(int i = 0; i < coins.size(); i++){
                if(leastCoins > (minCoinsMap.get(j - coins.get(i) + 1) + 1)){
                    leastCoins = minCoinsMap.get(j - coins.get(i) + 1) + 1;
                }
            }
            minCoinsMap.put(j+1, leastCoins);
        }
        System.out.println(minCoinsMap.get(money));

        sc.close();
    }
}