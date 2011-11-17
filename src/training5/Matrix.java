package training5;

public class Matrix {

    int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        for (int[] line : matrix) {

            for (int i : line) {
                sBuilder.append(i);
                sBuilder.append(" ");
            }
            // use system line seperator so code runs on every OS with JVM
            sBuilder.append(System.getProperty("line.separator"));
        }
        return sBuilder.toString();
    }

    // ******************** Klassenmethode ****************************
    public static boolean isTriangularMatrix(Matrix m) {
        return m.isTriangularMatrix();
    }

    // ******************** Instanzmethode ****************************
    public boolean isTriangularMatrix() {
        // is square matrix ? - 2D or higher arrays can have different length
        int size = matrix.length;
        for (int[] line : matrix)
            if (line.length != size)
                return false;

        // is a triangle matrix?
        for (int i = 0; i < size; ++i)
            for (int j = i + 1; j < size; ++j)
                if (matrix[j][i] != 0)
                    return false;

        return true;
    }

    public static void test() {
        //@formatter:off
        int[][] test = {
                {
                    5 , 5 , 5, 5, 5
                },
                {
                    0 , 1 , 5, 5, 5
                },
                {
                    0 , 0 , 2, 5, 5
                },
                {
                    0 , 0 , 0, 1, 5
                },
                {
                    0 , 0 , 0, 0, 4
                }
        };
        //formatter:on
        Matrix m = new Matrix(test);
        System.out.println(m.toString());
        System.out.println(m.isTriangularMatrix());
        System.out.println(Matrix.isTriangularMatrix(m));
        System.out.println();
    
        //@formatter:off
        test = new int[][]{
                {
                    5 , 5 , 5, 5, 5
                },
                {
                    0 , 1 , 5, 5, 5
                },
                {
                    0 , 1 , 2, 5, 5
                },
                {
                    0 , 0 , 0, 1, 5
                },
                {
                    0 , 0 , 0, 0, 4
                }
        };
        //@formatter:on
        m = new Matrix(test);
        System.out.println(m.toString());
        System.out.println(m.isTriangularMatrix());
        System.out.println(Matrix.isTriangularMatrix(m));
    }
}
