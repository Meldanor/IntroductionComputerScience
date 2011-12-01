/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training7.gauss;

public class Gauss {

    private final Solid[][] original;
    private Solid[][] result;

    public Gauss(Solid[][] matrix) {
        this.original = matrix;
    }

    public void solve() {
        Solid[][] matrix = original.clone();
        // look whether we have to do something
        for (int row = 0; row < matrix.length; ++row) {
            for (int column = row; column < matrix[row].length; ++column) {
                Solid s = matrix[row][column];
                if (!s.isZero()) {
                    int lineIndex = searchForSwap(matrix, row, column);
                    if (lineIndex != -1)
                        swap(matrix, lineIndex, column);
                    else {
                    }
                }
            }
        }
    }

    private boolean isInNormalForm(Solid[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < i; ++j) {
                
            }
        }
    }

    private int searchForSwap(Solid[][] matrix, int row, int colum) {
        for (int i = row + 1; i < matrix.length; ++i)
            if (matrix[i][colum].isZero())
                return i;

        return -1;
    }

    /**
     * Swaps two rows. The matrix itself will be changed!
     * 
     * @param matrix
     *            The matrix itself
     * @param row1
     *            A row of the matrix
     * @param row2
     *            A row of the matrix
     */
    private void swap(Solid[][] matrix, int row1, int row2) {
        Solid[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    /**
     * Multiply one row with a factor. The original line in the matrix keep
     * unchanged!
     * 
     * @param matrix
     *            The matrix itself
     * @param row
     *            The row index to get scaled
     * @param factor
     *            The factor. Must be the same solid as the matrix!
     * @return
     */
    private Solid[] multiply(Solid[][] matrix, int row, Solid factor) {
        Solid[] temp = matrix[row].clone();
        int border = temp.length;
        for (int i = 0; i < border; ++i)
            temp[i] = temp[i].mult(factor);
        return temp;
    }

    /**
     * Add the summandLine to the resultLine, so that only the resultLine is
     * changed. The matrix will be changed!
     * 
     * @param matrix
     *            The matrix itself
     * @param summandLine
     *            The summandline
     * @param resultLine
     *            The line which will be changed
     */
    private void add(Solid[][] matrix, int summandLine, int resultLine) {
        int border = matrix[summandLine].length;
        for (int i = 0; i < border; ++i)
            matrix[resultLine][i] = matrix[resultLine][i]
                    .add(matrix[summandLine][i]);
    }

    /**
     * @return The original matrix which is initialed by the gauss object
     */
    public Solid[][] getOriginalMatrix() {
        return original;
    }

    /**
     * @return The original matrix as a readable string. Each row is sperator by
     *         System.getProperty("line.separator")
     */
    public String originalToString() {
        return matrixToString(original);
    }

    /**
     * @return The normalized matrix as a readable string. Each row is sperator
     *         by System.getProperty("line.separator")
     */
    public String resultToString(Solid[][] matrix) {
        return matrixToString(matrix);
    }

    /**
     * Convert the matrix to a readable format, where each row is seperated by
     * System.getProperty("line.separator")
     * 
     * @param matrix
     *            The matrix to get converted, will be untouched
     * @return A readable string
     * 
     */
    private String matrixToString(Solid[][] matrix) {
        StringBuilder sBuilder = new StringBuilder();
        for (Solid[] line : matrix) {

            for (Solid s : line) {
                sBuilder.append(s.toString());
                sBuilder.append(" ");
            }
            // use system line seperator so code runs on every OS with JVM
            sBuilder.append(System.getProperty("line.separator"));
        }
        return sBuilder.toString();
    }
}
