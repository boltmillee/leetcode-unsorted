//Can also be done using Priority queue.
​
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap();
        
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        String result = "";
        
        for(int i=0; i<s.length(); i++){
            List<Character> list = sortByValue(map);
            
            if(i==0){
                map.put(list.get(0), map.get(list.get(0)) - 1);
                result += list.get(0);    
            } else{
                Character ch = list.get(0);
                if(result.charAt(i-1) == ch){
                    if(list.size() > 1){
                        map.put(list.get(1), map.get(list.get(1)) - 1);
                        result += list.get(1);
                    }else
                        return "";
                } else{
                    map.put(list.get(0), map.get(list.get(0)) - 1);
                        result += list.get(0);
                }    
            }
        }
        return result;
    }
    
    public List<Character> sortByValue(HashMap<Character, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<Character, Integer> > list = 
               new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() { 
            public int compare(Map.Entry<Character, Integer> o1,  
                               Map.Entry<Character, Integer> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        List<Character> temp = new ArrayList(); 
        for (Map.Entry<Character, Integer> aa : list) { 
            if(aa.getValue() > 0)
                temp.add(aa.getKey()); 
        }
        
        return temp; 
    }
}
