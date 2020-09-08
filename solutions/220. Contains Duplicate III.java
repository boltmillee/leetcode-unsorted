class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet();
        
        for(int i=0; i<nums.length; i++){
            //To get the next biggest number from set
            Integer next = set.ceiling(nums[i]);
            
            if(next != null && nums[i] + t >= next)
                return true;
            
            Integer prev = set.floor(nums[i]);
            
            if(prev != null && prev + t >= nums[i])
                return true;
            
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
                
        }
        
        return false;
    }
}
