class Solution {
    int result=0;
    public int longestArithSeqLength(int[] A) {
        if(A.length == 0)
            return 0;
        
        helper(A, 0, new ArrayList());
        
        return result;
    }
    
    //recursive solution
    void helper(int[] A, int index, List<Integer> list){
        
        if(index == A.length){
            int len = 0;
            boolean isSequence = true;
            if(list.size() == 1){
                len = 1;
            } else if(list.size() == 2){
                len = 2;
            } else if(list.size() >2){
                for(int i=1; i<list.size()-1; i++){
                    if(!(2*list.get(i) == list.get(i-1) + list.get(i+1))){
                        isSequence = false;
                    }
                }
            }
            
            if(isSequence){
                if(list.size() > result)
                    result = list.size();
            }
            
            return;
        }
        
        list.add(A[index]);
        helper(A, index+1, list);
        list.remove(list.size()-1);
        helper(A, index+1, list);
    }
}