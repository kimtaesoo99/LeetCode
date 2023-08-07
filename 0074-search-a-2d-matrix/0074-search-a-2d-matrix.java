class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchRows(matrix, target);
        if (row == -1) {
            return false;
        }
        return binarySearchColumns(matrix[row], target);
    }

    private int binarySearchRows(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean binarySearchColumns(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
