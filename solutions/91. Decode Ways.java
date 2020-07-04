class Solution {
    int result = 0;
    int res = 0;
    Map<Character, Integer> map = new HashMap();
    public int numDecodings(String s) {
        helper(s, 0, 0);
        
        return res;
    }
    
    void helper(String s, int index, int count){
        
        if(index == s.length()){
            res++;
            if(count > result)
                result = count;
            
            return;
        }
        
        String temp2 = s.substring(index, index+1);
        
        if( Integer.valueOf(temp2) >= 1 && Integer.valueOf(temp2) <= 9)
            helper(s, index+1, count+1);
        
        if(index < s.length() -1){
            String temp = s.substring(index, index+2);
            if(Integer.valueOf(temp) >=10 && Integer.valueOf(temp) <=26)
                helper(s, index+2, count+1);
        }
    }
}