class Solution {
    suppose
        a=
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList();
        if(s.length() < p.length())
            return list;
        
        int n = s.length();
        int m = p.length();
        int first=0, last=0, count=p.length();
        Map<Character, Integer> map = new HashMap();
        
        for(int i=0; i<m; i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        while(last<n){
            
            Character lastChar = s.charAt(last);
            map.put(lastChar, map.getOrDefault(lastChar, 0) - 1);
            if(map.get(lastChar) >=0)
                count--;
            
            last++;
            
            while(count == 0){
            
                Character firstChar = s.charAt(first);
                map.put(firstChar, map.getOrDefault(firstChar, 0) + 1);
                if(map.get(firstChar) > 0)
                    count++;
                
                if(last - first == m) list.add(first);
                    
                first++;
                
            }
            
        }
            
        return list;
    }
    
}
