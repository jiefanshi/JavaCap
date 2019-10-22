package AmazonOA.com;

public class PathWithMaximumScoreDP {//DP method

    public static void main(String[] args) {
        PathWithMaximumScoreDP main = new PathWithMaximumScoreDP();
        System.out.println(main.dp(new int[][]{{3,4,6,3,4},{0,2,1,1,7},{8,8,3,2,7},{3,2,4,9,8},{4,1,2,0,0},{4,6,5,4,3}}));
        System.out.println(main.dp(new int[][]{{-1,-2,-3},{-2,-1,-1}}));

    }
    public int dp(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int [m][n];
        dp[0][0] = matrix[0][0];
        if (m > 1){
            for (int i = 1; i < m; i++){
                dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]);
            }
        }
        if (n > 1){
            for (int j = 1; j < n; j++){
                dp[0][j] = Math.min(dp[0][j - 1], matrix[0][j]);
            }
        }
        if (m > 1 && n > 1){
            for (int i = 1; i < m; i++){
                for (int j = 1; j < n; j++){
                    dp[i][j] = Math.max(Math.min(dp[i - 1][j], matrix[i][j]), Math.min(dp[i][j - 1], matrix[i][j]));
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
