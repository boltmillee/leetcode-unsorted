            if(j+1<board[0].length && board[i][j+1] == 'M')
                count += 1;
            
            if(i+1<board.length && board[i+1][j] == 'M')
                count += 1;
            
            if(j-1>=0 && i-1>=0 && board[i-1][j-1] == 'M')
                count += 1;
            
            if(j-1>=0 && i+1<board.length && board[i+1][j-1] == 'M')
                count += 1;
            
            if(j+1<board[0].length && i-1>=0 && board[i-1][j+1] == 'M')
                count += 1;
            
            if(j+1<board[0].length && i+1<board.length && board[i+1][j+1] == 'M')
                count += 1;
            
            if(count !=0){
                board[i][j] = (char) (count+'0');
                //System.out.println(board[i][j]);
                return;
            } else{
                board[i][j] = 'B';
                if(j-1>=0)
                    dfs(board, i, j-1, visited);
            
            if(i-1>=0)
                dfs(board, i-1, j, visited);
            
            if(j+1<board[0].length)
                dfs(board, i, j+1, visited);
            
            if(i+1<board.length)
                dfs(board, i+1, j, visited);
            
            if(j-1>=0 && i-1>=0)
                dfs(board, i-1, j-1, visited);
            
            if(j-1>=0 && i+1<board.length)
                dfs(board, i+1, j-1, visited);
            
            if(j+1<board[0].length && i-1>=0)
                dfs(board, i-1, j+1, visited);
            
            if(j+1<board[0].length && i+1<board.length)
                dfs(board, i+1, j+1, visited);
            }
            
        }
    }
}
