import java.util.*;

class BinarySearch {

    public static int binarySearch(ArrayList<Long>arrayElements, int left, int right, long checkELement) {
        int mid = (left+right)/2;
        if(right < left) return -1;
        if(arrayElements.get(mid) == checkELement) return mid;
        else if (checkELement > arrayElements.get(mid)) 
            return binarySearch(arrayElements, mid+1, right, checkELement);
        else
            return binarySearch(arrayElements, left, mid-1, checkELement);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        ArrayList<Long> arrayElements = new ArrayList<Long>();
        for (int i = 0; i < arraySize; i++) {
            arrayElements.add(sc.nextLong());
        }
        int checkSize = sc.nextInt();
        ArrayList<Long> arrayCheckElements = new ArrayList<Long>();
        for (int i = 0; i < checkSize; i++) {
            arrayCheckElements.add(sc.nextLong());
        }
        for (int i = 0; i < checkSize; i++) {
            System.out.println(binarySearch(arrayElements, 0, arrayElements.size()-1, arrayCheckElements.get(i)));
        }
        sc.close();
    }
}