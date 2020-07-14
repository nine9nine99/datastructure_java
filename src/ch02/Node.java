package ch02;

public class Node {
    public Object data;//存放节点值
    public Node next;//后续节点的引用
    //无参构造体
    public Node(){
        this.data = null;
        this.next = null;
    }
    //一个参数的构造体
    public Node(Object data){
        this.data = data;
        this.next = null;
    }
    public Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }
}
