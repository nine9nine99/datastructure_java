package ch04;

/**
 * 稀疏矩阵的三元结点
 * */

public class TripleNode {
    public int row;
    public int column;
    public int value;

    public TripleNode(int row, int column, int value){
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public TripleNode(){
        this.row = 0;
        this.column = 0;
        this.value = 0;
    }
}
