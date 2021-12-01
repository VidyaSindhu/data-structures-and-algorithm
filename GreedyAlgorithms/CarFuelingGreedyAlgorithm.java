package GreedyAlgorithms;
import java.util.*;


public class CarFuelingGreedyAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long dis = sc.nextLong();
        int reFuelDis = sc.nextInt();
        int stopsNum = sc.nextInt();
        // ArrayList<Long> stops = new ArrayList<Long>();
        ArrayList<Long> stops = new ArrayList<Long>();
        stops.add((long)0);
        for(int i = 0; i < stopsNum; i++){
            stops.add(sc.nextLong());
        }
        stops.add((long)dis);
	    long result = 0;
        // int L = reFuelDis;
        int currentRefill = 0;
        int lastRefuelPoint = 0;
        stopsNum = stops.size();
        while(currentRefill < stopsNum-1) {
            lastRefuelPoint = currentRefill;

            while(currentRefill < stopsNum-1 && stops.get(currentRefill + 1) - stops.get(lastRefuelPoint) <= reFuelDis) currentRefill++;
            if(currentRefill == lastRefuelPoint) {
                result = -1;
                break;
            }
            if(currentRefill < stopsNum - 1) result++;
        }
        System.out.println(result);

        sc.close();
    }
}
