class Solution {
    public int numIslands(char[][] grid) {
        
        int result=0;
        
        for(int i=0;i< grid.length; i++){
            for(int j=0; j< grid[i].length; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(grid, i, j);
                }
                    
            }
        }
        
        return result;
    }
    
    void dfs(char[][] grid, int i, int j){
        if(i < 0 || i> grid.length-1 || j < 0 || j> grid[i].length-1)
            return;
        
        if(grid[i][j] == '1')
            grid[i][j] = 0;
        else
            return;
        
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        
    }
}