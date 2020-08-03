class Solution {
    List<String> list = new ArrayList();
    public List<String> generateParenthesis(int n) {
        helper("", 0, 0, 0, n);
        
        return list;
    }
    
    void helper(String s, int open, int close, int index, int n){
        if(index == 2*n){
            list.add(s);
            return;
        }
        
        if(open<n)
            helper(s+'(', open+1, close, index+1, n);
        
        if(open>close){
            helper(s+')', open, close+1, index+1, n);
        }
    }
}
