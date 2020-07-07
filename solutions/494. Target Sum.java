class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int sum =0;
        for(int i=0; i<nums.length; i++)
            sum += nums[i];
        
        helper(nums, 0, sum, S);
        
        return count;
    }
    
    void helper(int[] nums, int index, int sum, int target){
       
        
        if(index == nums.length){
            if(sum == target){
                count++;
        }
            return;
        }
        
 
        helper(nums, index+1, sum, target);
        helper(nums, index+1, sum - 2 *nums[index], target);       
                
        
        
    }
}