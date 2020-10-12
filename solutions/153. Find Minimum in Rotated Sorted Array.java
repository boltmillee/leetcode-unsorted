class Solution {
    int min = Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        
        if(nums.length == 1)
            return nums[0];
        
        int index = bs(nums, 0, nums.length-1);
        
        if(index == -1)
            return nums[0];
        
        return nums[index];
    }
    
    int bs(int[] nums, int i, int j){
        
        while(i<j){
            int mid = i + (j-i)/2;
        
            if(nums[mid] > nums[mid+1]){
                return mid+1;
            }
​
            if(nums[mid] < nums[j]){
                j = mid;
            }else if(nums[mid] > nums[j]){
                i = mid;
            }
​
        }
            
        return -1;
    }
}
