class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];

        // Important check
        if(oldColor == color)
            return image;

        dfs(image, sr, sc, oldColor, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c,
                     int oldColor, int newColor) {

        // Boundary check
        if(r < 0 || c < 0 ||
           r >= image.length ||
           c >= image[0].length)
            return;

        // Different color
        if(image[r][c] != oldColor)
            return;

        // Fill color
        image[r][c] = newColor;

        // 4 directions
        dfs(image, r + 1, c, oldColor, newColor); // down
        dfs(image, r - 1, c, oldColor, newColor); // up
        dfs(image, r, c + 1, oldColor, newColor); // right
        dfs(image, r, c - 1, oldColor, newColor); // left
    }
}