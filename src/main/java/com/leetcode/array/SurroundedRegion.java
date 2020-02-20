package com.leetcode.array;

// https://leetcode.com/problems/surrounded-regions/

public class SurroundedRegion {
    public void solve(char[][] board) {
        int rows = board.length;


        if (board == null || rows == 0) return;
        int cols = board[0].length;
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                System.out.println("first row has 0");
                setSign(0, i, board);
            }
        }

        for (int i = 0; i < cols; i++) {
            if (board[rows - 1][i] == 'O') {
                setSign(rows - 1, i, board);
            }
        }

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                setSign(i, 0, board);
            }
        }

        for (int i = 0; i < rows; i++) {
            if (board[i][cols - 1] == 'O') {
                setSign(i, cols - 1, board);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    private void setSign(int row, int col, char[][] board) {
        //  System.out.println("befpre row="+row+" col="+col+" board[row][col]="+board[row][col]);
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') return;

        board[row][col] = '*';
        System.out.println("row=" + row + " col=" + col + " board[row][col]=" + board[row][col]);
        setSign(row + 1, col, board);
        setSign(row - 1, col, board);
        setSign(row, col + 1, board);
        setSign(row, col - 1, board);

    }
}
