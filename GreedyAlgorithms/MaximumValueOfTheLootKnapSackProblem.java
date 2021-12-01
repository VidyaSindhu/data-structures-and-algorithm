package GreedyAlgorithms;
import java.util.Scanner;

class MaximumValueOfTheLootKnapSackProblem {

    static void mergeSort(long arr[][], int start, int mid, int end){
        int leftSize = mid - start + 1;
        int rightSize = end - mid;
        long leftArr[][] = new long[2][leftSize];
        long rightArr[][] = new long[2][rightSize];

        for(int i = 0; i < leftSize; i++) {
            leftArr[0][i] = arr[0][start + i];
            leftArr[1][i] = arr[1][start + i];
        }

        for(int i = 0; i < rightSize; i++) {
            rightArr[0][i] = arr[0][mid + 1 + i];
            rightArr[1][i] = arr[1][mid + 1 + i];
        }
        int left = start;
        int i = 0, j = 0;
        while(i < leftSize && j < rightSize) {
            double leftRatio = (double)leftArr[0][i]/(double)leftArr[1][i];
            double rightRatio = (double)rightArr[0][j]/(double)rightArr[1][j];
            if(leftRatio >  rightRatio) {
                arr[0][left] = leftArr[0][i];
                arr[1][left] = leftArr[1][i];
                i++;
            } else {
                arr[0][left] = rightArr[0][j];
                arr[1][left] = rightArr[1][j];
                j++;
            }
            left++;
        }

        while(i < leftSize){
            arr[0][left] = leftArr[0][i];
            arr[1][left] = leftArr[1][i];
            left++;
            i++;
        }
        while(j < rightSize) {
            arr[0][left] = rightArr[0][j];
            arr[1][left] = rightArr[1][j];
            left++;
            j++;
        }
        
    }

    static void mergeSortDivide(long arr[][], int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSortDivide(arr, start, mid);
            mergeSortDivide(arr, mid + 1, end);
            mergeSort(arr, start, mid, end);
        }
    }

    static double knapSackProblem(long arr[][], long capacity, int items) {
        if(capacity <= 0) {
            return 0;
        }
        double value = 0;
        for (int i = 0; i < items; i++) {
            if(capacity == 0) {
                return value;
            }
            float weightToAdd = Math.min(capacity, arr[1][i]);    
            value += weightToAdd * (double)arr[0][i]/(double)arr[1][i];
            capacity -= weightToAdd;
            arr[1][i] -= weightToAdd;
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int items = sc.nextInt();
        long capacity = sc.nextLong();
        long[][] arr = new long[2][items];

        for(int i = 0; i < items; i++){
            arr[0][i] = sc.nextLong();
            arr[1][i] = sc.nextLong();
        }
        if (items > 1) mergeSortDivide(arr, 0, items-1);
        // for(int i = 0; i < 2; i ++){
        //     for (int j = 0; j < items; j++) {
        //         System.out.print(arr[i][j] + "   ");
        //     }
        //     System.out.println();
        // }
        System.out.println(knapSackProblem(arr, capacity, items));



        sc.close();
    }
}