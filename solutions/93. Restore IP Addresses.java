class Solution {
    List<String> list = new ArrayList();
    public List<String> restoreIpAddresses(String s) {
     
        if(s.length()<4 || s.length()>12)
            return list;
        
        helper(s, "", "", 0, 0);
        
        System.out.println(list);
        
        return list;
    }
    
    void helper(String s, String current, String result, int index, int dot){
        
        if(index == s.length()){
            String res = result;
            if(result.charAt(0) == '.'){
                res = result.substring(1);
                dot--;
            }
            
            String r = "";
            if(dot == 3){
                //System.out.println(res);
                String[] strArr = res.split("\\.");
                for(int i=0; i<strArr.length; i++){
                    //System.out.println(strArr[i]);
                    if(!strArr[i].equals(Integer.valueOf(strArr[i]).toString()))
                        return;
                    
                    r += "." + Integer.valueOf(strArr[i]).toString();   
                }
                list.add(r.substring(1));
            }
                
            
            return;
        }
        
        if(dot > 3)
            return;
        
        Character c = s.charAt(index);
        current += c;
        if(current.length() < 3){
            helper(s, current, result, index+1, dot);
            helper(s, "", result + '.' + current, index+1, dot+1);
        } else if(Integer.valueOf(current) <= 255){
            helper(s, "", result+'.' + current, index+1, dot+1);
        }
    }
}
