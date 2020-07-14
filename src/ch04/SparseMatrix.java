package ch04;

import org.omg.CORBA.PUBLIC_MEMBER;

public class SparseMatrix {
    public TripleNode data[];
    public int rows;
    public int cols;
    public int nums;

    //稀疏矩阵构造器
    public SparseMatrix(int maxsize){
        data = new TripleNode[maxsize]; //为顺序表分配maxSize个存储单元
        for (int i = 0; i<maxsize; i++){
            data[i] = new TripleNode();
        }
        rows = 0;
        cols = 0;
        nums = 0;
    }

    //打印三元数组
    public void printMatrix(){
        int i;
        System.out.println("稀疏矩阵三元数组存储结构：");
        System.out.println("行数："+rows+"列数："+cols+"非零元素个数："+nums);
        System.out.println("行下标 列下标 元素值");
        for (i=0; i<nums; i++){
            System.out.println(data[i].row+"\t"+data[i].column+"\t"+data[i].value);
        }
    }

    //从稀疏矩阵创建三元组表，mat为稀疏矩阵
    //初始化三元组表
    public SparseMatrix(int mat[][]){
        int i,j;
        int k=0;
        int count = 0;
        rows = mat.length;
        cols = mat[0].length;

        //统计非零元素个数
        for (i = 0; i<mat.length; i++){
            for (j = 0; j<mat[i].length; j++){
                if (mat[i][j]!=0)
                    count ++;
            }
        }
        nums = count; //非零元素个数
        data = new TripleNode[nums]; //三元结点空间
        for (i = 0; i<mat.length; i++){
            for (j=0; j<mat[i].length; j++){
                if (mat[i][j]!=0){
                    data[k] = new TripleNode(i,j,mat[i][j]);
                    k++;
                }
            }
        }
    }

    //矩阵转置算法
    /**转置无变化*/
    public SparseMatrix transpose(){
        SparseMatrix tm = new SparseMatrix(nums);
        tm.cols = rows; //行数列数互换
        tm.rows = cols;
        tm.nums = nums;
        int q=0; //序号
        for (int col=0; col<cols; col++){
            for (int p=0; p<nums; p++){
                if (data[p].column == col){
                    tm.data[q].row = data[p].column;
                    tm.data[q].column = data[p].row;
                    tm.data[q].value = data[q].value;
                    q++;
                }
            }
        }
        return tm;
    }

}
