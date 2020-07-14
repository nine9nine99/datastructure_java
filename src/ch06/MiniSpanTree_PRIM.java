package ch06;

public class MiniSpanTree_PRIM {
    private class CloseEdge{ //内部类用于辅助记录从顶点集U到V-U的代价最小的边
        Object adjVex; //顶点集
        int lowCost;
        public CloseEdge(Object adjVex, int lowCost){
            this.adjVex = adjVex;
            this.lowCost = lowCost;
        }
    }

    //使用普里姆算法从第u个顶点出发构造网G的最小生成树T， 返回由生成树组成的二维数组
    public Object[][] PRIM(MGraph G, Object u) throws Exception{
        Object[][] tree = new Object[G.getVexNum()-1][2];
        int count = 0;
        CloseEdge[] closeEdges = new CloseEdge[G.getVexNum()];
        int k = G.locateVex(u); //获得起始顶点
        for (int j=0; j<G.getVexNum(); j++)
            if (j!=k)
                closeEdges[j] = new CloseEdge(u, G.getArcs()[k][j]);

        closeEdges[k] = new CloseEdge(u, 0);
        for (int i=1; i<G.getVexNum(); i++){
            k = getMinMum(closeEdges);
            System.out.print(k);
            tree[count][0] = closeEdges[k].adjVex; //生成树的边放在数组中
            tree[count][1] = G.getVexs(k);
            count++;
            closeEdges[k].lowCost=0; //k值进入U集合
            for (int j=0; j<G.getVexNum(); j++){
                if (G.getArcs()[k][j]<closeEdges[j].lowCost)
                    closeEdges[j] = new CloseEdge(G.getVex(k), G.getArcs()[k][j]);
            }
        }
        return tree;
    }

    private int getMinMum(CloseEdge[] closeEdge){
        int min = Integer.MIN_VALUE;
        int v = -1;
        for (int i = 0; i<closeEdge.length;i++){
            if (closeEdge[i].lowCost!=0 && closeEdge[i].lowCost<min){
                min = closeEdge[i].lowCost;
                v=i;//更新最小值的点
            }
        }
        return v;
    }
}
