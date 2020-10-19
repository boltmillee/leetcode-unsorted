class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int result = 0;
        
        for(Integer i : nums){
            if(!map.containsKey(i)){
                int left = map.containsKey(i-1)?map.get(i-1):0;
                int right = map.containsKey(i+1)?map.get(i+1):0;
​
                int sum = left + right + 1;
                
                map.put(i, sum);
                result = Math.max(result, sum);
​
​
                map.put(i-left, sum);
                map.put(i+right, sum);
            } 
        }
        
        return result;
    }
}
