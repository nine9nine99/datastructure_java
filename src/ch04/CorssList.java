package ch04;

public class CorssList {
    public int mu, nu, tu; //行数，列数，非零元素个数
    public OLNode[] rhead, chead; //行、列指针数组

    public CorssList(int m, int n){
        mu = m;
        nu = n;
        rhead = new OLNode[m]; //初始化行指针数组
        chead = new OLNode[n]; //初始化列指针数组
        tu = 0;
        for (int i=0; i<m; i++){
            rhead[i] = new OLNode();
        }
        for (int i = 0; i<n; i++){
            chead[i] = new OLNode();
        }
    }
}
