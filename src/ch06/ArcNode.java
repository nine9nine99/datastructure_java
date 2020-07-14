package ch06;
//边节点
public class ArcNode {
    public int adjVex; //指示与顶点Vi邻接的顶点在图中的位置
    public int value; //边的权值
    public ArcNode nextArc; //指向下一个边结点
    public ArcNode(){
        this.adjVex = -1;
        this.value = 0;
        this.nextArc = null;
    }

    public ArcNode(int adjVex){
        this.adjVex = adjVex;
        this.value = 0;
        this.nextArc = null;
    }

    public ArcNode(int adjVex, int value){
        this.adjVex = adjVex;
        this.value = value;
        this.nextArc = null;
    }

    public ArcNode(int adjVex, int value, ArcNode nextArc){
        this.adjVex = adjVex;
        this.value = value;
        this.nextArc = nextArc;
    }
}
