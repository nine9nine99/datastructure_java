package ch06;
//顶点结点
public class VNode {
    public Object data;
    public ArcNode firstArc;

    public VNode(){
        this.data = null;
        this.firstArc = null;
    }
    public VNode(Object data){
        this.data = data;
        this.firstArc = null;
    }
    public VNode(Object data, ArcNode firstArc){
        this.data = data;
        this.firstArc = firstArc;
    }
}
