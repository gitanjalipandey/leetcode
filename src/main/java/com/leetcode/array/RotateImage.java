package com.leetcode.array;

// https://leetcode.com/problems/rotate-image/submissions/

public class RotateImage {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = rows - 1;

        while (i < j) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }

        for (i = 0; i < rows; i++) {
            for (j = i; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
