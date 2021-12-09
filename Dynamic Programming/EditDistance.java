import java.util.*;

public class EditDistance {
    public static int editDistance(String s1, String s2, int[][] lcs, int i, int j) {
        if(lcs[i][j] != -1) return lcs[i][j];
        if(i <= 0 || j <= 0) return i + j;
        int min = Math.min(editDistance(s1, s2, lcs, i-1, j) + 1, editDistance(s1, s2, lcs, i, j-1) + 1);
        if(s1.charAt(i-1) == s2.charAt(j-1)) {
            lcs[i][j] = Math.min(min, editDistance(s1, s2, lcs, i-1, j-1));
        }
        else{
            lcs[i][j] = Math.min(min, editDistance(s1, s2, lcs, i-1, j-1) + 1);
        }
        return lcs[i][j];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        
        int n = s1.length();
        int m = s2.length();

        int[][] lcs = new int[n+1][m+1];
        for(int i =0; i <= n; i++){
            for(int j = 0; j <=m; j++) {
                lcs[i][j] = -1;
            }
        }
        // for(int i = 0; i <= n; i++){
        //     lcs[i][0] = i;
        // }
        // for(int i = 0; i <= m; i++){
        //     lcs[0][i] = i;
        // }
        System.out.println(editDistance(s1, s2, lcs, n, m));
    
        sc.close();
    }
}
