import java.util.*;

public class LongestCommonSequenceOfTwoSequence {

    public static int longestCommonSequenceOfTwoSequence(int[] array1, int[] array2, int[][] lcs, int i, int j) {
        if(lcs[i][j] != -1) return lcs[i][j];
        if(i <= 0 || j <= 0) return 0;
        if(array1[i-1] == array2[j-1]) {
            lcs[i][j] = 1 + longestCommonSequenceOfTwoSequence(array1, array2, lcs, i-1, j-1);
            return lcs[i][j];
        }
        else{
            lcs[i][j] = Math.max(longestCommonSequenceOfTwoSequence(array1, array2, lcs, i-1, j), longestCommonSequenceOfTwoSequence(array1, array2, lcs, i, j-1));
            return lcs[i][j];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array1 = new int[n];
        for(int i = 0; i < n; i++) {
            array1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] array2 = new int[m];
        for(int i = 0; i < array2.length; i++){
            array2[i] = sc.nextInt();
        }
        int[][] lcs = new int[n+1][m+1];
        for(int i =0; i <= n; i++){
            for(int j = 0; j <=m; j++) {
                lcs[i][j] = -1;
            }
        }
        System.out.println(longestCommonSequenceOfTwoSequence(array1, array2, lcs, n, m));
    
        sc.close();
    }
}
