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

import java.util.Arrays;

public class Gauss {

    private final Solid[][] original;
    private Solid[][] result;

    public Gauss(Solid[][] matrix) {
        this.original = matrix;
    }

    public void solve() {

        result = original.clone();

        // -1 because of we don't want to norm the results
        for (int i = 0; i < result.length - 1; ++i) {
            for (int j = i; j < result[i].length; ++j) {
                // When there is a leading zero element in the column
                if (result[i][j].isZeroElement()) {
                    int temp = searchForSwap(result, i, j);
                    // have found a row which is leading by a non zero element
                    if (temp != -1)
                        swap(result, i, temp);
                    // when there is no zero element in this column go to the
                    // next
                    else
                        ++i;

                }
                Solid[] pivot = result[i].clone();
                // change pivot to one element
                if (!pivot[j].isOneElement())
                    pivot = mult(result, i, result[i][j].getMultInverse());

                // add all rows with the pivot row but not the pivot row with
                // itself
                for (int k = 0; k < result.length; ++k)
                    if (k != i)
                        result[k] = add(result[k],
                                mult(result, i, result[k][j].getAddInverse()));

                // look for a contradiction in the
                for (int k = 0; k < result.length; ++i) {
                    if (!result[k][result[k].length - 1].isZeroElement()) {
                        inner: for (int t = 0; t < result[k].length - 1; ++k)
                            if (!result[k][t].isZeroElement())
                                break inner;
                        throw new RuntimeException(
                                "Can't solve system because of a contradiction.\n"
                                        + Arrays.toString(result[k]));
                    }
                }
            }
        }

    }

    private int searchForSwap(Solid[][] matrix, int row, int column) {
        int nonPerfect = -1;
        for (int i = row + 1; i < matrix.length; ++i) {
            if (matrix[i][column].isOneElement())
                return i;
            if (!matrix[i][column].isZeroElement())
                nonPerfect = i;

        }
        return nonPerfect;
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
    private Solid[] add(Solid[] a, Solid[] b) {
        Solid[] t = new Solid[a.length];
        for (int i = 0; i < a.length; ++i) {
            t[i] = a[i].add(b[i]);
        }

        return t;
    }

    private Solid[] mult(Solid[][] matrix, int row, Solid factor) {
        Solid[] result = matrix[row].clone();
        for (int i = 0; i < result.length; ++i)
            result[i] = result[i].mult(factor);

        return result;
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
                sBuilder.append("\t");
            }
            // use system line seperator so code runs on every OS with JVM
            sBuilder.append(System.getProperty("line.separator"));
        }
        return sBuilder.toString();
    }
}
