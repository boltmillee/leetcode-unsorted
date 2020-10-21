class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        
        if(grid.length == 0 || grid[0].length == 0)
            return result;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                 if(grid[i][j] == '1'){
                     dfs(grid, i, j);
                     result++;
                 }
            }
        }
        
        return result;
    }
    
    public void dfs(char[][] grid, int i, int j){
        
        if(i<0 || i >= grid.length || j<0 || j>=grid[0].length)
            return;
        
        if(grid[i][j] == '1')
            grid[i][j] = '0';
        else
            return;
        
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
