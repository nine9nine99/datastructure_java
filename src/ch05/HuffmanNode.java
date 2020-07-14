package ch05;

public class HuffmanNode {
    public int weight;
    public int flag;
    public HuffmanNode parent, lchild, rchild;
    public HuffmanNode(){
        this.parent = null;
        this.lchild = null;
        this.rchild = null;
    }

    public HuffmanNode(int weight){
        this.weight = weight;
        flag = 0;
        this.parent = this.lchild = this.rchild = null;
    }
}
