import java.util.ArrayList;
import java.util.List;

public class DAY4 {
    public int diagonalSum(int[][] mat) {
        // tc=O(N) & SC = O(1)
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            if (i != mat.length - i - 1) {
                sum += mat[i][mat.length - i - 1];
            }
        }
        return sum;
    }
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        //tc = O(m*n) & sc = O(m*n) 
        int m = mat.length;
        int n = mat[0].length;
        if(m*n!=r*c) return mat;
        int[][] ans = new int[r][c];
        int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[k/c][k%c] = mat[i][j];
                k++;
            }
        }
        return ans;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        //tc = O(m*n) & sc = O(m*n)
        List<Integer> l = new ArrayList<>();
        int sr =0;
        int sc =0;
        int er = matrix.length-1;
        int ec = matrix[0].length-1;
        while(sr<=er && sc<=ec){
            for(int i=sc;i<=ec;i++){
                int n = matrix[sr][i];
                l.add(n);
            }
            sr++;
            for(int i=sr;i<=er;i++){
                int n = matrix[i][ec];
                l.add(n);
            }
            ec--;
            if(sr<=er){
            for(int i=ec;i>=sc;i--){
                int n = matrix[er][i];
                l.add(n);
            }
            er--;
            }
            if(sc<=ec){
            for(int i=er;i>=sr;i--){
                int n = matrix[i][sc];
                l.add(n);
            }
            sc++;
            }
        }
        return l;
    }
}