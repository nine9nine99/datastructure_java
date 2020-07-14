package ch06;
//最短路径普里姆算法
public class Example6_4 {
    public final static int INFINITY = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
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
        Object[][] tree = new MiniSpanTree_PRIM().PRIM(G, "v1");

        for (int j=0; j<tree.length; j++)
            System.out.println(tree[j][0]+"-"+tree[j][1]);
    }
}
