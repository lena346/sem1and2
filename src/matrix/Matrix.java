package matrix;

public class Matrix {
    int n,m;
    int[][] mainMatrix;
    public Matrix(int n, int m)
    {
        this.n = n;
        this.m = m;
        this.mainMatrix = new int[this.n][this.m];
    }
    public Matrix(int [][] paramMatrix)
    {
        this.n = paramMatrix.length;
        this.m = paramMatrix[0].length;
        this.mainMatrix = paramMatrix;
    }
    public int getElement(int n, int m)
    {
        return this.mainMatrix[n][m];
    }

    public void setElement(int n, int m, int value)
    {
        this.mainMatrix[n][m] = value;
    }

    public int getVerticalLength()
    {
        return this.mainMatrix.length;
    }

    public int getHorizontalLength()
    {
        return this.mainMatrix[0].length;
    }

    public void displayMatrix()
    {
        for(int i = 0; i < this.n; i++)
        {
            for(int j = 0; j < this.m; j++)
            {
                System.out.print(this.mainMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] transpone(int[][] paramMatrix)
    {
        int[][] tmpMatrix = new int[paramMatrix[0].length][paramMatrix.length];
        for(int i = 0; i < paramMatrix[0].length; i++)
        {
            for(int j = 0; j < paramMatrix.length; j++)
            {
                tmpMatrix[i][j] = paramMatrix[j][i];
            }
        }
        return tmpMatrix;
    }

    public static Matrix transpone(Matrix paramMatrix)
    {
        Matrix tmpMatrix = new Matrix(paramMatrix.m, paramMatrix.n);
        for(int i = 0; i < paramMatrix.m; i++)
        {
            for(int j = 0; j < paramMatrix.n; j++)
            {
                tmpMatrix.setElement(i, j, paramMatrix.getElement(j, i));
            }
        }
        return tmpMatrix;
    }

    public static Matrix multiplicationbyanumb(Matrix first, int k) {
        int n = first.getVerticalLength();
        int m = first.getHorizontalLength();
        int[][] tmpArr = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++) {
                tmpArr[i][j] = first.getElement(i, j) * k;
            }
        }
        Matrix tMatrix = new Matrix(tmpArr);
        return tMatrix;
    }

    public static Matrix exponentiation(Matrix first, int p) throws NotEqualLengthsOfMatrixException {
        int n = first.getVerticalLength();
        int m = first.getHorizontalLength();
        Matrix tmpArr = new Matrix(first.mainMatrix);
        for (int i = 0; i < p-1; i++) {
            tmpArr = multiply(first, tmpArr);
        }
        return tmpArr;
        }

    public static Matrix add(Matrix first, Matrix second) throws NotEqualLengthsOfMatrixException {
        if(first.getVerticalLength() != second.getVerticalLength() ||
                first.getHorizontalLength() != second.getHorizontalLength())
        {
            throw  new NotEqualLengthsOfMatrixException();
        }
        else {
            Matrix tmpMatrix = new Matrix(first.getVerticalLength(), second.getHorizontalLength());
            for (int i = 0; i < tmpMatrix.getHorizontalLength(); i++) {
                for(int j = 0; j < tmpMatrix.getVerticalLength(); j++){
                    tmpMatrix.setElement(i, j, first.getElement(i, j) + second.getElement(i, j));
                }
            }
            return tmpMatrix;
        }
    }

    public static Matrix subtract (Matrix first, Matrix second) throws NotEqualLengthsOfMatrixException {
        if(first.getVerticalLength() != second.getVerticalLength() ||
                first.getHorizontalLength() != second.getHorizontalLength())
            throw  new NotEqualLengthsOfMatrixException();
        else {
            Matrix tmpMatrix = new Matrix(first.getVerticalLength(), second.getHorizontalLength());
            for (int i = 0; i < tmpMatrix.getHorizontalLength(); i++) {
                for(int j = 0; j < tmpMatrix.getVerticalLength(); j++){
                    tmpMatrix.setElement(i, j, first.getElement(i, j) - second.getElement(i, j));
                }
            }
            return tmpMatrix;
        }
    }
    public static Matrix multiply (Matrix first, Matrix second) throws NotEqualLengthsOfMatrixException {
        if(first.getHorizontalLength() != second.getVerticalLength())
            throw  new NotEqualLengthsOfMatrixException();
        else {
            Matrix tmpMatrix;
            int n = first.getVerticalLength();
            int m = second.getHorizontalLength();
            int o = second.getVerticalLength();
            int[][] tmpArr = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    for (int k = 0; k < o; k++) {
                        tmpArr[i][j] += first.getElement(i, k) * second.getElement(k, j);
                    }
                }
            }
            tmpMatrix = new Matrix(tmpArr);
            return tmpMatrix;
        }
    }
}


class NotEqualLengthsOfMatrixException extends Exception {}


class MatrixMain {

    public static void main(String[] args) throws java.lang.Exception {

        int[][] A = {{2, 2, 2},
                {1, 1, 1},
                {3, 3, 3}};



        Matrix y = new Matrix(A);
        y.displayMatrix();
        Matrix mM = Matrix.exponentiation(y,3);
        mM.displayMatrix();


    }
}