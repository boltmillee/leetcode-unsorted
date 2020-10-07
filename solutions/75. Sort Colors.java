class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length-1;
        int current = 0;
        while(current<=two){
            
            if(nums[current] == 0){
                swap(nums, zero, current);
                zero++;
                current++;
            } else if(nums[current] == 2){
                swap(nums, two, current);
                two--;
            } else{
                current++;
            }
        }
        
    }
    
    public void swap(int[] nums, int f, int s){
        
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }
}
