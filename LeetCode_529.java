/*
 * 扫雷
 * @Date: 2019-11-04 14:59:43
 * @LastEditors: Qiyue
 * @LastEditTime: 2019-11-04 18:25:16
 */
public class LeetCode_529 {
    
    public static char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(board, click[0], click[1]);
        return board;
    } 

     public static void dfs(char[][]board, int row, int col) {
        if ( row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] == 'M') {
            return;
        }

        if (board[row][col] != 'E') {
            return;
        }
      
        int mineCount = 0;
        if (row-1>=0) {
            mineCount += board[row-1][col] == 'M' ? 1 : 0;
        }
        if (col-1>=0) {
            mineCount += board[row][col-1] == 'M' ? 1 : 0;
        }
        if (row+1<board.length) {
            mineCount += board[row+1][col] == 'M' ? 1 : 0;
        }
        if (col+1<board[row].length) {
            mineCount += board[row][col+1] == 'M' ? 1 : 0;
        }
        if (row-1 >= 0 && col-1>=0) {
            mineCount += board[row-1][col-1] == 'M' ? 1 : 0;
        }
        if (row-1 >= 0 && col+1<board[row].length) {
            mineCount += board[row-1][col+1] == 'M' ? 1 : 0;
        }
        if (row+1 <board.length && col+1<board[row].length) {
            mineCount += board[row+1][col+1] == 'M' ? 1 : 0;
        }
        if (row+1 <board.length && col-1>=0) {
            mineCount += board[row+1][col-1] == 'M' ? 1 : 0;
        }

        if (mineCount == 0) {
            board[row][col] = 'B';
            dfs(board, row-1, col);
            dfs(board, row, col-1);
            dfs(board, row+1, col);
            dfs(board, row, col+1);
            dfs(board, row+1, col+1);
            dfs(board, row+1, col-1);
            dfs(board, row-1, col+1);
            dfs(board, row-1, col-1);
        } else {
            board[row][col] = (char) (mineCount+'0');
        }
    }
    public static void main(String[] args) {
        
    }
}