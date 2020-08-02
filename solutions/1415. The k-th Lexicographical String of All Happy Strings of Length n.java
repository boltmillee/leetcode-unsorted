class Solution {
    Set<String> set = new HashSet();
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        
        helper("", "", list, n);
        List<String> res = new ArrayList<String>(set);
        Collections.sort(res);
        
        if(res.size() >= k){
            return res.get(k-1);
        } else{
            return "";
        }
      
    }
    
    void helper(String current, String prev, List<String> list, int n){
        
        if(current.length() == n){
            set.add(current);
            return;
        }
        
        for(int i=0; i<3; i++){
            if(list.get(i) != prev){
                helper(current+list.get(i), list.get(i), list, n);
            }
        }
    }
}
