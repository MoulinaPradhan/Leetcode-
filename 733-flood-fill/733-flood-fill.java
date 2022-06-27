class Solution {
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int[][] floodFill(int[][] image, int r, int c, int newColor) {
        if (image[r][c] == newColor) return image; // same color -> no need to replace
        
        int m = image.length, n = image[0].length;
        int oldColor = image[r][c];
        image[r][c] = newColor; // set new color
        for (int i = 0; i < 4; i++) {
            int nr = r + DIR[i], nc = c + DIR[i+1];
            if (nr < 0 || nr == m || nc < 0 || nc == n || image[nr][nc] != oldColor) continue;
            floodFill(image, nr, nc, newColor);
        }
        return image;
    }
}