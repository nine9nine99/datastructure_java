package ch06;
import ch03.LinkQueue;


public class Example6_1 {
    public final static int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        Object vexs[] = {"A", "B", "C", "D", "E", "F", "G"};
        int[][] arcs = {
                {0,1,INFINITY,1, INFINITY, INFINITY, INFINITY},
                {1, 0, 1, INFINITY, INFINITY, INFINITY, INFINITY},
                {INFINITY, 1, 0, 1, INFINITY, INFINITY, INFINITY},
                {1, INFINITY, 1, 0, INFINITY, INFINITY, INFINITY},
                {INFINITY, INFINITY, INFINITY, INFINITY, 0, 1, INFINITY},
                {INFINITY, INFINITY, INFINITY, INFINITY, 1, 0, 1},
                {INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 1, 0},};
        MGraph G = new MGraph(GraphKind.UDG, 7, 6, vexs, arcs);
        CC_BFS(G);
    }

    public static void CC_BFS(IGraph G) throws Exception{
        boolean[] visited = new boolean[G.getVexNum()];

        for (int v=0; v<G.getVexNum(); v++)
            visited[v] = false;

        LinkQueue Q = new LinkQueue(); //辅助队列Q，用于接收顶点
        LinkQueue P = new LinkQueue(); //辅助队列P，用于记录连通分量顶点
        int i = 0;//记录连通分量个数

        for (int v=0; v<G.getVexNum(); v++){
            P.clear();
            if (!visited[v]){
                visited[v] = true;
                P.offer(G.getVex(v)); //入队
                Q.offer(v);
                while (!Q.isEmpty()){
                    int u = (Integer)Q.poll();
                    for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w)){
                        if (!visited[w]){
                            visited[w] = true;
                            P.offer(G.getVex(w));
                            Q.offer(w);
                        }
                    }
                }
                System.out.println("第"+ ++i + "个连通分量：");
                while (!P.isEmpty())
                    System.out.print(P.poll().toString()+ " ");
                System.out.println();
            }
        }
    }
}

