class Solution {
    boolean p,a;
    List<List<Integer>> list = new ArrayList();
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int n = matrix.length;
        if(n==0)
            return list;
        int m = matrix[0].length;
        
        if(m == 0)
            return list;
        
        boolean[][] visited;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited = new boolean[n][m];
                if((i==0 && j== m-1) || i == n-1 && j == 0){
                    List<Integer> temp = new ArrayList();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                    continue;
                } 
                p=false;
                a=false;
                dfs(matrix, i, j, visited, i, j);
                
                if(a && p){
                    List<Integer> temp = new ArrayList();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        
        return list;
    }
    
    void dfs(int[][] matrix, int i, int j, boolean[][] visited, int fi, int fj){
       
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length)
            return;
        
        if(visited[i][j] == true)
            return;
       
        if(matrix[i][j] > matrix[fi][fj])
            return;
         
        if((i<=0 || j<=0)){
