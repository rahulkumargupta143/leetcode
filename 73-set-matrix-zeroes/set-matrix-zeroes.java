class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        // Step 1: Check first row and first col
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) firstRow = true;
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstCol = true;
        }

        // Step 2: Use first row/col as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 3: Update matrix based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Handle first row and first col separately
        if (firstRow) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (firstCol) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}
