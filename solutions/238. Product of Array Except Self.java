class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] arr = new int[nums.length];
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int[] b = new int[nums.length];
        b[nums.length-1] = nums[nums.length-1];
        
        for(int i=1; i<nums.length; i++){
            f[i] = nums[i]*f[i-1]; 
        }
        
        for(int i=nums.length-2; i>=0; i--){
            b[i] = b[i+1]*nums[i];
        }
        
        arr[0] = b[1];
        arr[nums.length-1] = f[nums.length-2];
        
        for(int i=1; i<nums.length-1; i++){
            arr[i] = f[i-1] * b[i+1];
        }
        
        return arr;
    }
}
