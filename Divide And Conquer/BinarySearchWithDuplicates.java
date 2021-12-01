import java.util.*;

public class BinarySearchWithDuplicates {

    public static int binarySearch(long arrayElements[], int left, int right, long checkELement) {
        int mid = (left+right)/2;
        if(right < left) return - 1;
        if(arrayElements[mid] == checkELement){
            int j = mid;
            while(j > 0) {
                if(arrayElements[j-1] != checkELement) break;
                j--;
                // System.out.println(j);
            }
            return j;
        }
        else if(checkELement > arrayElements[mid])
            return binarySearch(arrayElements, mid+1, right, checkELement);
        else 
            return binarySearch(arrayElements, left, mid-1, checkELement);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        long[] arrayElements = new long[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arrayElements[i] = sc.nextLong();
        }
        int checkSize = sc.nextInt();
        long[] arrayCheckElements = new long[checkSize];
        for (int i = 0; i < checkSize; i++) {
            arrayCheckElements[i] = sc.nextLong();
        }
        for (int i = 0; i < checkSize; i++) {
            System.out.println(binarySearch(arrayElements, 0, arraySize-1, arrayCheckElements[i]));
        }
        sc.close();
    }
}
