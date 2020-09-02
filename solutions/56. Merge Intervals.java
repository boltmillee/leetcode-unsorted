class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length == 0)
            return new int[0][2];
//         Arrays.sort(intervals, new Comparator<int[]>() {
//     @Override
//     public int compare(int[] s1, int[] s2) {
//         if (s1[0] > s2[0])
//             return 1;
//         else if (s1[0] < s2[0])
//             return -1;
//         else {
//             if(s1[1] < s2[1])
//                 return 1;
//             else if (s1[1] > s2[1])
//                 return -1;
//             else
//                 return 0;
//         }
//     }
// });
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList(); 
        int low = intervals[0][0];
        int high = intervals[0][1];
         for(int i=0; i<intervals.length-1; i++){
             high = Math.max(high, intervals[i][1]);
             if(intervals[i+1][0]>high){
                 int[] arr = new int[2];
                 arr[0] = low;
                 arr[1] = high;
                 list.add(arr);
                 low = intervals[i+1][0];
                 high = intervals[i+1][1];
             }
         } 
        
        if(high < intervals[intervals.length-1][0]){
            list.add(intervals[intervals.length-1]);
        }else{       
            int[] arr = new int[2];
                 arr[0] = low;
                 arr[1] = Math.max(high,intervals[intervals.length-1][1]);
                 list.add(arr);
        }
        
        
        int[][] res = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            int[] temp = new int[2];
