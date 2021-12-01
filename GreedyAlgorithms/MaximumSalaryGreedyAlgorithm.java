import java.util.*;

public class MaximumSalaryGreedyAlgorithm {

    public static boolean leftGreaterConcatenate(String left, String right) {
        return (Integer.parseInt(left+right) > Integer.parseInt(right+left))? true: false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<String> stringArray = new ArrayList<String>();

        for (int i = 0; i < size; i++) {
            stringArray.add(sc.next());
        }

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if(leftGreaterConcatenate(stringArray.get(i), stringArray.get(j))) Collections.swap(stringArray, i, j);
                // else Collections.swap(stringArray, j, i);
            }
        }

        for (int i = 0; i < size; i++) 
            System.out.print(stringArray.get(i));

        sc.close();
    }
}
