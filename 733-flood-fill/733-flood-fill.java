class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
             if (image[sr][sc] == color) return image;
        flood(image, sr,sc,image[sr][sc], color);
        return image;
    }
    public void flood (int [][] image, int sr, int sc , int color, int newColor){
        if(sr< 0 || sr>= image.length || sc <0 || sc>=image[0].length || image[sr][sc] != color) return ;
        image[sr][sc] = newColor;
        flood(image, sr,sc-1, color, newColor);
         flood(image, sr,sc+1, color, newColor);
         flood(image, sr-1,sc, color, newColor);
         flood(image, sr+1,sc, color, newColor);
    }
}