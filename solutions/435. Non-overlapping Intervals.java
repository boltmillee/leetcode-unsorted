class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals, (int a[],int b[]) -> a[0]-b[0]);
        List<int[]> list = new ArrayList();
        list.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            if(list.get(list.size() -1)[1] <= intervals[i][0]){
                list.add(intervals[i]);
            } else{
                if(list.get(list.size() -1)[1] > intervals[i][1]){
                    list.remove(list.size() -1);
                    list.add(intervals[i]);    
                }
            }
        }
        return intervals.length - list.size();
    }
}
