class Solution {
// Time Complexity : O(mn) for BFS, O((mn)^2) for bfs brute force
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was unable to do dfs.

    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < mat.length; i ++){
            for(int j = 0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(new int []{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        // int dis = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                
                int [] cur = q.poll();
                for(int dir []: dirs){
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    //bound check
                    if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] == -1){
                        // if(mat[nr][nc] == 1){
                            mat[nr][nc] = mat[cur[0]][cur[1]] + 1;
                            q.add(new int []{nr,nc});        
                        // }
                    }
                }
            }
            // dis++;
        }
        return mat;
    }

    public int[][] updateMatrixBruteForce(int[][] mat) {
        for(int i = 0; i < mat.length; i ++){
            for(int j = 0; j<mat[0].length; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = bfs(mat,i,j);
                }
            }
        }
        return mat;
    }

    private int bfs(int[][] mat, int i , int j){
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int []> q = new LinkedList<>();
        q.add(new int []{i,j, mat[i][j]});
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                int [] cur = q.poll();
                for(int dir []: dirs){
                    int nr = dir[0] + cur[0];
                    int nc = dir[1] + cur[1];
                    //bound check
                    if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length){
                        if(mat[nr][nc] == 0){
                            return cur[2];
                        }else{
                            q.add(new int []{nr,nc, cur[2]+ 1});
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}