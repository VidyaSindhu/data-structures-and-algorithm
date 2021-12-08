import java.util.*;

public class PrimitiveCalculator2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        HashMap<Integer, Integer> minOperations = new HashMap<Integer, Integer>();
        minOperations.put(1,0);
        minOperations.put(0,0);
        for (int i = 2; i < n+1; i++) {
            int leastOperations = Integer.MAX_VALUE;
            if(i%3 == 0) leastOperations = minOperations.get(i/3) + 1;
            if(i%2 == 0) leastOperations = Math.min(leastOperations, minOperations.get(i/2) + 1);
            leastOperations = Math.min(leastOperations, minOperations.get(i-1) + 1);
            minOperations.put(i, leastOperations);
        }   
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        // sequence.add(1);
        int i = n;
        while(i > 2) {
            if(i%3 == 0) {
                if(minOperations.get((i)/3) + 1 == minOperations.get(i)){
                    sequence.add(i/3);
                    i = i / 3;
                }
            }
            if(i%2 == 0){
                if(minOperations.get(i/2) + 1 == minOperations.get(i)) {
                    sequence.add(i/2);
                    i = i / 2;
                }
            }
            if(minOperations.get(i-1) + 1 == minOperations.get(i)){
                sequence.add(i-1);
                i--;
            }
        }
        sequence.add(n);
        System.out.println(minOperations.get(n));
        Collections.sort(sequence);
        for(int j = 0; j < sequence.size(); j++){
            System.out.println(sequence.get(j));
        }   
    
        sc.close();
    }
}
