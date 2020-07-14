package ch06;

public class Example6_5 {
    public final static int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        Object vexs[] = {"A", "B", "C", "D"};
        int[][] arcs = {
                {0, 15, 3, INFINITY},
                {10,0,2,INFINITY},
                {INFINITY, INFINITY,0, 2},
                {INFINITY, 8, 4, 0}
        };
        MGraph G = new MGraph(GraphKind.UDG, 4, 7, vexs, arcs);
        ShortestPath_FLOYD floyd = new ShortestPath_FLOYD();
        floyd.FLOYD(G);
        display(floyd.getD());
        findPlace(G, floyd.getD());
    }

    public static void display(int[][] D){
        System.out.println("各村之间的最短路径长度为：");
        for (int v=0; v<D.length; v++)
            for (int w=0; w<D.length; w++)
                System.out.print(D[v][w] + "\t");
            System.out.println();
    }

    public static void findPlace(MGraph G, int[][] D) throws Exception{
        int min = INFINITY;
        int u = -1;
        int sum;
        for (int v=0; v<D.length; v++){
            sum = 0;
            for (int w = 0; w<D.length; w++)
                sum += D[v][w];
            if (min>sum){
                min = sum;
                u = v;
            }
        }
        System.out.println("俱乐部应该设在"+ G.getVex(u)+"的位置,长度为：");
        for (int i = 0; i<D.length; i++)
            System.out.print(D[u][i]+"\t");
        System.out.println();
    }
}
