import java.util.*;

public class QuickSort {
    
    public static int partition(ArrayList<Integer> arr, int left, int right) {
        int pivot = arr.get(left);
        int i = left, j = right;
        while(i < j){
        while(arr.get(i) <= pivot) 
            i++;
        while(arr.get(j) > pivot)
            j--;
        if(i < j)
            Collections.swap(arr, i, j);
        }
        Collections.swap(arr, left, j);
        return j;
    }

    public static void quickSort(ArrayList<Integer> arr, int left, int right) {
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            arr.add(sc.nextInt());
        }
        quickSort(arr, 0, arr.size()-1);
        sc.close();
    }
}
