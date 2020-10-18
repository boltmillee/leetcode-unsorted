class Solution {
    public void nextPermutation(int[] nums) {
        int min = nums.length-1;
        Stack s = new Stack();
        boolean isSwapped = false;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                int temp = Integer.MAX_VALUE;
                int index = -1;
                for(int j=i+1; j<nums.length; j++){
                    if(nums[j] > nums[i]){
                        temp = Math.min(temp, nums[j]);
                        index = j;
                    }
                }
                
                swap(nums,i, index);
                Arrays.sort(nums, i+1, nums.length);
                isSwapped = true;
                break;
            }else{
                s.add(nums[i]);
                min = Math.min(nums[min], nums[i]);
            }
        }
        
        if(!isSwapped)
            Arrays.sort(nums);
    }
    
    public void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
