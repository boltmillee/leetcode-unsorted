class Solution {
    public int evalRPN(String[] tokens) {
        
        
        Stack<Integer> s = new Stack();
        int result = 0;
        for(int i=0; i<tokens.length; i++){
            char[] arr = tokens[i].toCharArray();
            if(arr.length == 1 && (arr[0] == '+' || arr[0] == '-' || arr[0] == '*' || arr[0] == '/')){
            char[] chA = tokens[i].toCharArray();
                
                Character ch = chA[0];
                
                if(ch == '+'){
                    Integer a = s.pop();
                    Integer b = s.pop();
                    //result += a+b;
                    s.push(a+b);
                } else if(ch == '-'){
                    Integer a = s.pop();
                    Integer b = s.pop();
                    //result += b-a;
                    s.push(b-a);
                } else if(ch == '*'){
                    Integer a = s.pop();
                    Integer b = s.pop();
                    s.push(a*b);
                } else if(ch == '/'){
                    Integer a = s.pop();
                    Integer b = s.pop();
                    s.push(b/a);
                }           
            } else{
                s.add(Integer.valueOf(tokens[i]));
            }
            
    }
        
        return s.pop();
        
}
}
