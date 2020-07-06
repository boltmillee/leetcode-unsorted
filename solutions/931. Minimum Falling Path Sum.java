class Solution {
    // Question will have the same recursive logic as (120-Triangle) problem.
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int dp[] = new int[n];
        
        for(int j=n-1; j>=0; j--){
            dp[2][j] = A[2][j];
        }
        
        for(int i = n-2; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(j==n-1){
                    dp[j] =A[i][j] + Math.min(dp[j], dp[i+1][j-1]);
                } else if(j == 0){
                    dp[i][j] = A[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                } else{
                    int min = Math.min(dp[i+1][j-1], dp[i+1][j+1]);
                    
                    dp[i][j] = A[i][j] + Math.min(dp[i+1][j], min);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            res = Math.min(res, dp[0][i]);
        }
        
        return res;
    }
}