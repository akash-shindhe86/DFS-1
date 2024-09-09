// Time Complexity : O(nm) for dfs and bfs, 
// Space Complexity : O(mn) for dfs and bfs,
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        int startCol = image[sr][sc];
        int[][] dirs = new int [][]{{0,1},{0,-1},{-1,0},{1,0}};
        dfs(image, sr,sc,color,startCol, dirs);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int startCol, int [][] dirs){
        //base
        if(r < 0 || c < 0 || r == image.length || c == image[0].length || image[r][c] != startCol){
            return;
        }

        //logic
        image[r][c] = color;
        for(int dir []: dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
                dfs(image, nr,nc,color,startCol, dirs);
        }
    }

    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }

        int m = image.length;
        int n = image[0].length;
        int startCol = image[sr][sc];
        int[][] dirs = new int [][]{{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = color;
        q.add(new int []{sr,sc});

        while(!q.isEmpty()){
            int cur [] = q.poll();
            for(int dir []: dirs){
                int nr = dir[0] + cur[0];
                int nc = dir[1] + cur[1];
                //bound check
                if(nr >= 0 && nc >= 0 && nr <  m && nc < n && image[nr][nc] == startCol){
                    image[nr][nc] = color;
                    q.add(new int []{nr,nc});
                }
            }
        }
        return image;
    }
}