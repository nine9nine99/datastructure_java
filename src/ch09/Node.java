package ch09;
//B-树结点
public class Node<T> {
    public int keyNum; //关键字个数域
    public boolean isLeaf; //是否为树叶
    public T[] key; //关键字数组
    public Node[] child; //子数指针数组
    public Node parent; //双亲结点
    Node(int m){
        keyNum = 0;
        isLeaf = true;
        key = (T[])(new Object[2*m - 1]);
        child = new Node[2*m];
        parent = null;
    }
}
