/*
 * @Date: 2019-11-04 14:08:05
 * @LastEditors: Qiyue
 * @LastEditTime: 2019-11-04 14:47:05
 */
public class LeetCode_200 {
    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) { return 0;}
        int cols = grid[0].length;
        int count = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                count += dfs(grid, i, j);
            }
        }
        return count;
    }
    public static int dfs(char[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0'){
            return 0;
        }
        grid[row][col] = '0';
         dfs(grid, row,col-1);
         dfs(grid, row-1,col);
        dfs(grid, row+1,col);
        dfs(grid, row, col+1);
        return 1;
    }

    public static void main(String[] args) {
        
    }
}