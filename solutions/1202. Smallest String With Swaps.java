class Solution {
    String res = null;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        if(pairs.size() == 0)
            return s;
        
        helper(s, pairs, new HashSet());
        
        return res;
    }
    
    void helper(String s, List<List<Integer>> pairs, Set<String> set){
        
        if(set.contains(s))
            return;
        else
            set.add(s);
        
        String temp = s;
        for(int i=0; i<pairs.size(); i++){
            temp = swap(s, pairs.get(i));
            
            //if(temp.compareTo(s)<0){
            if(res == null || temp.compareTo(res) < 0)
                res = temp;
                
            helper(temp, pairs, set);
                
            //} 
                
            temp = s;
        }
        //temp = s;
    }
    
    String swap(String s, List<Integer> list){
        StringBuilder sb = new StringBuilder(s);
        Character c1 = s.charAt(list.get(0));
        sb.setCharAt(list.get(0), s.charAt(list.get(1)));
        sb.setCharAt(list.get(1), c1);
        
        return sb.toString();
    }
}
