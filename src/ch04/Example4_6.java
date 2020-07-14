package ch04;

public class Example4_6 {
    public static void main(String[] args){
        int m[][] = {{0,0,8,0,0,0}, {0,0,0,0,0,0}, {5,0,0,0,16,0},{0,0,18,0,0,0},
                {0,0,0,9,0,0}};
        SparseMatrix sm = new SparseMatrix(m);
        SparseMatrix tm = sm.transpose();
        sm.printMatrix();
        tm.printMatrix();
    }
}
