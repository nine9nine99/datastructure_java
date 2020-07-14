package ch06;

/**
 * P用于存储v0到目标顶点v当前求得最短路径得顶点
 * D[]用于保存当前得路径权值
 * **/

public class ShortestPath_DIJ {
    private boolean[][]P; //v0到其余顶点的最短路径，若P[v][w]为true，则w是v0到v当前求的最短路径上的顶点
    private int[] D; //v0到其余顶点的带权长度
    public final static int INFINITY = Integer.MAX_VALUE;

    public void DIJ(MGraph G, int v0){
        int vexNum = G.getVexNum();
        P = new boolean[vexNum][vexNum];
        D = new int[vexNum];

        //初始化。finish[v]为true则代表当且仅当v属于S，即求得从v0到v得最短路径
        boolean[] finish = new boolean[vexNum];
        for (int v=0; v<vexNum; v++){
            finish[v] = false;
            D[v] = G.getArcs()[v0][v]; //获得v0到v得权值
            for (int w=0; w<vexNum; w++)
                P[v][w] = false; //设置空路径
            if (D[v]<INFINITY){
                P[v][v0] = true;
                P[v][v] = true;
            }
        }
        /**
         * v用于保存当前权值较低得顶点
         * **/
        D[v0]=0;
        finish[v0] = true;
        int v = -1;
        for (int i = 1; i<vexNum; i++){
            int min = INFINITY;
            for (int w=0; w<vexNum; w++){
                if (!finish[w]){
                    if (D[w]<min){
                        v = w;
                        min = D[w];
                    }
                }
            }
            finish[v] = true;
            for (int w = 0; w<vexNum; w++){
                if (!finish[w]&&G.getArcs()[v][w]<INFINITY&&(min+G.getArcs()[v][w])<D[w]){
                    D[w] = min + G.getArcs()[v][w];
                    System.arraycopy(P[v], 0, P[w], 0, P[v].length);
                    P[w][w] = true;
                }
            }
        }
    }
    public int[] getD(){
        return D;
    }

    public boolean[][] getP(){
        return P;
    }
}
