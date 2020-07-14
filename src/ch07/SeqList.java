package ch07;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 待排序顺序表类
 * */

public class SeqList {
    public RecordNode[] r; //顺序表记录结点数组
    public int curlen;  //顺序表长度

    //构造存储空间为maxsize的顺序表
    public SeqList(int maxSize){
        this.r = new RecordNode[maxSize];
        this.curlen = 0;  //顺序表当前长度
    }

    //顺序表在第i个结点前插入结点x
    public void insert(int i, RecordNode x) throws Exception{
        if (curlen==r.length){
            throw new Exception("顺序表已满");
        }
        if (i<0 || i>r.length){
            throw new Exception("插入范围非法");
        }
        for (int j=curlen; j>i; j--)
            r[j] = r[j-1];
        r[i] = x;
        this.curlen++;
    }

    /**
     * 插入排序
     * */
    public void insertSort(){
        RecordNode temp;
        int i, j;
        for (i=1; i<this.curlen; i++){
            temp = r[i];
            for (j=i-1; j>=0&&temp.key.compareTo(r[j].key)<0; j--){
                r[j+1] = r[j];
            }
            r[j+1] = temp;
        }
    }


    /**
     * 加入哨兵的插入排序
     * 具有弊端：只能检验n-1个元素
     * */
    public void insertSortWithGuard(){
        int i,j;
        for (i=1; i<r.length; i++)
            r[0] = r[i];
            for (j=i-1; r[0].key.compareTo(r[j].key)<0; j--)
                r[j+1] = r[j];
            r[j+1] = r[0];
    }

    /**
     * 希尔排序
     * */
    public void shellSort(int[] d){//增量数组
        RecordNode temp;
        int i, j;
        for (int k=0; k<d.length; k++){
            int dk = d[k];
            //一趟中若干子表，每次对子表都进行插入排序
            for (i=dk; i<this.curlen;i++){
                temp = r[i];
                for (j=i-dk; j>=0&&temp.key.compareTo(r[j].key)<0; j-=dk)
                    r[j+dk] = r[j];
                r[j+dk] = temp;
            }
        }
    }

    /**
     * 冒泡排序
     * */
    public void bubbleSort(){
        RecordNode temp; //辅助结点
        boolean flag = true; //是否交换的标记

        for (int i=1; i<this.curlen&&flag;i++){
            flag=false;//记录未交换
            for (int j=0; j<curlen-1; j++){
                if (r[j].key.compareTo(r[j+1].key)>0){//逆序时，交换
                    temp = r[j];
                    r[j] = r[j+1];
                    r[j+1] = temp;
                    flag = true;
                }
            }
        }
    }

    /**
     * 快速排序
     * */
    public int Partition(int i, int j){
        RecordNode pivot = r[i];//第一个记录作为支点
        while (i<j){//从表的两端交替向中间扫描
            while (i<j&&pivot.key.compareTo(r[j].key)<=0);{//从后向前扫描
                j--;
            }
            if (i<j){//比支点记录管家你小的向前移动
                r[i] = r[j];
                i++;
            }
            while (i<j&&pivot.key.compareTo(r[i].key)>0)
                i++;
            if (i<j){//将比支点大的关键字值向后移动
                r[j] = r[i];
                j--;
            }
        }
        r[i] = pivot;
        return i;
    }

    public void qSort(int low, int high){
        if (low<high){
            int pivotloc = Partition(low, high);//第一趟排序
            qSort(low, pivotloc-1);//低子表递归排序
            qSort(pivotloc+1, high);//高子表递归排序
        }
    }

    public void quickSort(){
        qSort(0, this.curlen-1);
    }


}
