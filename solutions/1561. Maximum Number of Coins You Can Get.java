class Solution {
    public int maxCoins(int[] piles) {
//         List<Integer> list = new ArrayList();
        
//         for(int i=0; i<piles.length; i++){
//             list.add(piles[i]);
//         }
        
//         Collections.sort(list);
//         int result = 0;
//         while(list.size() > 0){
//             list.remove(list.size() - 1);
//             int second = list.remove(list.size() - 1);
//             list.remove(0);
            
//             result += second;
//         }
        
//         return result;
        Arrays.sort(piles);
        
        int start = piles.length/3;
        int result = 0;
        for(int i=start; i<piles.length; i=i+2){
            result += piles[i];
        }
        
        return result;
    }
}
