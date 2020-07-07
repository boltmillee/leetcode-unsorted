class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        if(n == 0)
            return 0;
        
        int[] dp = new int[n];
        dp[0] = 1;
        int result = 0;
        for(int i=1; i<n; i++){
            dp[i] =1;
            for(int j=0; j<i; j++){
                if(arr[i] - arr[j] == difference && dp[i]<dp[j]+1){
                    dp[i] =  1 + dp[j] ;
                }
            }
            
            if(result < dp[i])
                result = dp[i];
        }
        
        return result;
    }
}