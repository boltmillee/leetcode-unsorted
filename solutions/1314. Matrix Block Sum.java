class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
       /* 
       Alternate approach to calculate cumulative sum from (0, 0) to (i, j)
        
        Make a class pair which has cumulative sum till now and sum of colums from 
        0 to i. so for current (i, j)
        columnSum = mat[i][j] + columnSum(i-1);
        cumulative sum = cumulative sum(j-1) + columnSum(i-1) + matrix[i][j];
        */
    }
}