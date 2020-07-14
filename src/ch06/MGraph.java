package ch06;
//邻接矩阵创建图


import java.util.Scanner;

public class MGraph implements IGraph{
    public final static int INFINITY = Integer.MAX_VALUE;
    private GraphKind kind; //图的种类
    private int vexNum, arcNum; //图的当前顶点数和边数
    private Object[] vexs; //顶点
    private int[][] arcs; //邻接矩阵
    public MGraph(){
        this(null, 0, 0, null, null);
    }

    public MGraph(GraphKind kind, int vexNum, int arcNum, Object[] vexs, int[][] arcs){
        this.kind = kind;
        this.vexNum = vexNum;
        this.arcNum = arcNum;
        this.vexs = vexs;
        this.arcs = arcs;
    }

    //创建图
    @Override
    public void creatGraph() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入图的类型：");
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

    //无向网的创建算法
    public void createUDN(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数");
        vexNum = sc.nextInt(); //顶点数
        arcNum = sc.nextInt(); //边数
        vexs = new Object[vexNum];
        System.out.println(vexs);
        System.out.println("请分别输入图的各个顶点：");
        //通过使用数组获取顶点向量
        for (int v = 0; v < vexNum; v++) vexs[v] = sc.next();
        //通过使用矩阵初始化邻接矩阵
        arcs = new int[vexNum][vexNum];
        for (int v = 0; v<vexNum; v++){
            for (int u = 0; u<vexNum; u++){
                arcs[v][u] = INFINITY;
            }
        }
        System.out.println("请输入各个边的两个顶点及其权值：");
        for (int k=0; k<arcNum; k++){
            int v = locateVex(sc.next());
            int u = locateVex(sc.next());
            arcs[v][u] = arcs[u][v] = sc.nextInt();
        }
    }

    public void createDN(){
        Scanner sc = new Scanner(System.in);
        vexNum = sc.nextInt(); // 顶点数
        arcNum = sc.nextInt(); //边数
        vexs = new Object[vexNum]; //边的集合
        System.out.println("请分别输入图的各个顶点");
        //初始化顶点
        for (int v = 0; v<vexNum; v++) vexs[v] = sc.next();
        //初始化矩阵
        arcs = new int[vexNum][vexNum];
        for (int v=0; v<vexNum; v++){
            for (int u=0; v<vexNum; u++){
                arcs[v][u] = INFINITY;
            }
        }
        System.out.println("请输入各个边的两个顶点及其权值");
        for (int k=0; k<arcNum; k++){
            int v = locateVex(sc.next());
            int u =locateVex(sc.next());
            arcs[v][u] = sc.nextInt();
        }
    }

    @Override
    public int getVexNum() {
        return vexNum;
    }

    @Override
    public int getArcNum() {
        return arcNum;
    }


    @Override
    public int locateVex(Object vex) {
        for (int v = 0; v<vexNum; v++)
            if (vexs[v].equals(vex))
                return v;
        return -1;
    }

    @Override
    public int firstAdjVex(int v) throws Exception{
        if (v<0 && v>=vexNum)
            throw new Exception("第"+v+"个顶点不存在");
        for (int i=0; i<vexNum; i++)
            if (arcs[v][i]!=0 && arcs[v][i]<INFINITY){
                return arcs[v][i];
            }
         return 0;
    }

    @Override
    public int nextAdjVex(int v, int w) throws Exception{
        if (v<0 || v>=vexNum)
            throw new Exception("输入的顶点不合法");
        for (int i = w+1; i<vexNum; i++)
            if (arcs[v][i] != 0 && arcs[v][i]<INFINITY)
                return i;
         return -1;
    }

    public Object getVex(int v) throws Exception{
        if (v<0 && v>= vexNum)
            throw new Exception("第"+v+"个顶点不存在");
        return vexs[v];
    }

    public GraphKind getKind(){
        return kind;
    }

    public int[][] getArcs(){
        return arcs;
    }

    public Object getVexs(int i){
        return vexs[i];
    }

    //图的广度优先算法
    public static void BFSTraverse(IGraph G) throws Exception{

    }


    public static void main(String args[]){
        Object[] vexs = {"v0", "v1", "v2", "v3", "v4", "v5"};
        int[][] arcs = {
                {INFINITY, 7, 1, 5, INFINITY, INFINITY},
                {7, INFINITY, 6, INFINITY, 3, INFINITY},
                {1,6,INFINITY,7,6,4},
                {5, INFINITY, 7, INFINITY, INFINITY, 2},
                {INFINITY, 3, 6, INFINITY, INFINITY, 7},
                {INFINITY, INFINITY, 4, 2, 7, INFINITY}
        };
        MGraph G = new MGraph(GraphKind.UDG, 6, 10, vexs, arcs);


    }

}
