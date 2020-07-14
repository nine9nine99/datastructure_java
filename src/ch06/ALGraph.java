package ch06;
//邻接表创建图
import ch03.LinkQueue;
import java.util.Scanner;

public class ALGraph implements IGraph {
    private GraphKind kind; //图的类型标志
    private int vexNum, arcNum; //图的顶点数目和边数
    private VNode[] vexs; //顶点

    public ALGraph(){
        this.kind = null;
        this.vexNum = 0;
        this.arcNum = 0;
        this.vexs = null;
    }

    public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode[] vexs){
        this.kind = kind;
        this.vexNum = vexNum;
        this.arcNum = arcNum;
        this.vexs = vexs;
    }

    @Override
    public void creatGraph() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择创建的类型");
        GraphKind kind = GraphKind.valueOf(sc.next());
        switch (kind){
            case UDG:
                //createUDG();
                return;

            case DG:
                //createDG();
                return;

            case UDN:
                createUDN();
                return;

            case DN:
                createDN();
                return;
        }
    }

    public void createDN(){
        Scanner sc = new Scanner(System.in);
        System.out.println("分别输入图的顶点数和图的边数：");
        vexNum = sc.nextInt();
        arcNum = sc.nextInt();
        vexs = new VNode[vexNum];
        System.out.println("输入有向图的顶点：");
        for (int i=0; i < vexNum; i++){
            vexs[i] = new VNode(sc.next());
        }
        System.out.println("请输入各边的顶点及其权值：");
        for (int k=0; k<arcNum; k++){
            int v = locateVex(sc.next()); //弧头
            int u = locateVex(sc.next()); //弧尾
            int value = sc.nextInt();
            addArc(v, u, value);
        }
    }

    public void createUDN(){
        Scanner sc = new Scanner(System.in);
        System.out.println("分别输入顶点数量和边的数量：");
        vexNum = sc.nextInt();
        arcNum = sc.nextInt();
        vexs = new VNode[vexNum];
        System.out.println("分别输入图中各点");
        for (int i=0; i<vexNum; i++){
            vexs[i] = new VNode(sc.next());
        }
        System.out.println("输入各边的顶点及其权值：");
        for (int k=0; k<arcNum; k++){
            int v = locateVex(sc.next()); //弧头
            int u = locateVex(sc.next()); //弧尾
            int value = sc.nextInt();
            addArc(v, u, value);
            addArc(u, v, value);
        }
    }

    //在v和u之间添加一条弧 通过使用头插法
    public void addArc(int v, int u, int value){
        ArcNode arc = new ArcNode(u, value);
        arc.nextArc = vexs[v].firstArc;
        vexs[v].firstArc = arc;
    }

    public int nextAdjVex(int v, int w) throws Exception{
        if (v<0 || v>vexNum){
            throw new Exception("输入顶点不合法");
        }
        VNode vex = vexs[v];//顶点
        ArcNode arcvw = null; //目标边结点存储
        for (ArcNode arc = vex.firstArc; arc!=null; arc = arc.nextArc){
            if (arc.adjVex == w){
                arcvw = arc;
                break;
            }
        }
        if (arcvw != null && arcvw.nextArc != null)
            return arcvw.nextArc.adjVex;
        else
            return -1;
    }

    @Override
    public int getVexNum() {
        return 0;
    }

    @Override
    public int getArcNum() {
        return 0;
    }

    @Override
    public Object getVex(int v) throws Exception {
        if (v<0 || v >= vexNum){
            throw new Exception("输入的顶点不合法");
        }
        return vexs[v].data;
    }

    //给定vex，并获得vex的值
    @Override
    public int locateVex(Object vex) {
        for (int v=0; v<vexNum; v++){
            if (vexs[v].data.equals(vex))
                return v;
        }
        return -1;
    }

    //获取第一个邻接顶点
    @Override
    public int firstAdjVex(int v) throws Exception {
        if (v<0 || v >= vexNum){
            throw new Exception("输入的顶点不合法");
        }
        VNode vex = vexs[v];
        if (vex.firstArc != null)
            return vex.firstArc.adjVex;
        else
            return  -1;
    }

    //广度优先算法
    private static boolean[] visited; //访问标志数组
    public static void BFSTraverse(IGraph G) throws Exception{
        visited = new boolean[G.getVexNum()];
        for (int v=0; v<G.getVexNum(); v++){
            visited[v] = false;
        }
        for (int v=0; v<G.getVexNum(); v++){
            if(!visited[v])
                BFS(G, v);
        }
    }

    private static void BFS(IGraph G, int v) throws Exception{
        visited[v] = true;
        System.out.println(G.getVex(v).toString()+"");
        LinkQueue Q = new LinkQueue(); //辅助队列
        Q.offer(v); //第一个元素入队
        while (!Q.isEmpty()){
            int u = (Integer)Q.poll(); //第一个元素出队
            for (int w = G.firstAdjVex(u); w>=0; w = G.nextAdjVex(u,w)){
                if (!visited[w]){
                    visited[w] = true;
                    System.out.print(G.getVex(w).toString()+"");
                    Q.offer(w);
                }
            }
        }
    }

}
