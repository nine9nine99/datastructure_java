package ch06;

public interface IGraph {
    void creatGraph();
    int getVexNum();
    int getArcNum();
    Object getVex(int v) throws Exception;
    int locateVex(Object vex);
    int firstAdjVex(int v) throws Exception;
    int nextAdjVex(int v, int w) throws Exception;
}

