package ch04;

public class OLNode {
    public int row, col;
    public int e;
    public OLNode right;
    public OLNode down;

    OLNode(){
        this.row = 0;
        this.col = 0;
        this.e = 0;
    }

    OLNode(int row, int col, int e){
        this.row = row;
        this.col = col;
        this.e = e;
        right = null;
        down = null;
    }
}
