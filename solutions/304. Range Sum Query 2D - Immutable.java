class NumMatrix {
    
    Pair[][] dp ;
    
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        
        if(n==0)
            return;
        
        int m = matrix[0].length;
        
        if(m==0)
            return;
        
        dp = new Pair[n][m];
        Pair p0 = new Pair();
        p0.colSum = matrix[0][0];
        p0.cumSum = matrix[0][0];
        dp[0][0] = p0;
        for(int i=1; i<m; i++){
            Pair p = new Pair();
            p.colSum = matrix[0][i];
            p.cumSum = dp[0][i-1].cumSum + matrix[0][i];
            dp[0][i] = p;
        }
        
        for(int i=1; i<n; i++){
            Pair p = new Pair();
            p.colSum = dp[i-1][0].colSum + matrix[i][0];
            p.cumSum = dp[i-1][0].cumSum + matrix[i][0];
            dp[i][0] = p;
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                Pair p = new Pair();
                p.colSum = dp[j-1][i].colSum + matrix[j][i];
                p.cumSum = dp[j][i-1].cumSum + dp[j-1][i].colSum + matrix[j][i];
                System.out.print(p.colSum + "/" + p.cumSum + " ");
                dp[j][i] = p;
            }
            
            System.out.println();
        }
        
        System.out.print("hh");
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        if(row1 == 0 && col1 == 0){
            
            return dp[row2][col2].cumSum;
        
        } else if(col1 == 0){
            
            return dp[row2][col2].cumSum - dp[row1-1][col2].cumSum;    
            
        } else if(row1 == 0){
            
            return dp[row2][col2].cumSum - dp[row2][col1-1].cumSum;    
        
        } else{
            return dp[row2][col2].cumSum - dp[row1-1][col2].cumSum - dp[row2][col1-1].cumSum + dp[row1-1][col1-1].cumSum;   
        }
    }
    
    class Pair{
        int colSum;
        int cumSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */