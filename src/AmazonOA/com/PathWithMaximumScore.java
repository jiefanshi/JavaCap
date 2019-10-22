package AmazonOA.com;

public class PathWithMaximumScore {//DFS method
    public static void main(String[] args) {
        PathWithMaximumScore main=new PathWithMaximumScore();
        int tc1=main.Maxcore(new int[][]{{5,1},{4,5}});
        System.out.println(tc1);
        int tc2=main.Maxcore(new int[][]{{5,7,6},{3,4,2},{9,8,4}});
        System.out.println(tc2);
        int tc3=main.Maxcore(new int[][]{{3,4,2},{9,8,4}});
        System.out.println(tc3);
        int tc4=main.Maxcore(new int[][]{{5,2,2},{9,8,5}});
        System.out.println(tc4);
        int tc5=main.Maxcore(new int[][]{{5,4,5},{1,2,6},{7,4,6}});
        System.out.println(tc5);
        System.out.println(main.Maxcore(new int[][]{{3,4,6,3,4},{0,2,1,1,7},{8,8,3,2,7},{3,2,4,9,8},{4,1,2,0,0},{4,6,5,4,3}}));
        System.out.println(main.Maxcore(new int[][]{{2}}));

    }
    public int Maxcore(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        int m = matrix.length, n = matrix[0].length;
        int [][] dp = new int [m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return dfs (matrix, m - 1, n - 1, dp);
    }
    public int dfs(int[][] matrix, int x, int y, int[][] dp){
        if (dp[x][y] != -1){
            return dp[x][y];
        }
        if (x == 0 && y == 0){
            dp[x][y] = matrix[x][y];
            return dp[x][y];
        }
        if (x == 0){
            dp[x][y] = Math.min(matrix[x][y], dfs(matrix, x,y - 1, dp));
            return dp[x][y];
        }
        if (y == 0){
            dp[x][y] = Math.min(matrix[x][y], dfs(matrix, x - 1, y, dp));
            return dp[x][y];
        }
        dp[x][y] = Math.max(Math.min(matrix[x][y], dfs(matrix, x,y - 1, dp)),
                Math.min(matrix[x][y], dfs(matrix, x - 1, y, dp)));
        return dp[x][y];
    }
}
