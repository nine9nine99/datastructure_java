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


    /**
     * 直接选择排序
     * */
    public void selectSort(){
        RecordNode temp;
        for (int i=0; i<this.curlen-1; i++){
            //从r[i]开始的子序列中寻找最小关键字的记录
            int min = i;
            for (int j=i+1; j<this.curlen-1; j++){
                if (r[j].key.compareTo(r[min].key)<0)
                    min = j; //记录值最小的结点
            }
            if (min!=i){
                temp = r[i];
                r[i] = r[min];
                r[min] = temp;
            }
        }
    }

    /**
     * 树形选择排序
     * */
    void tournamentSort(){
        /**
         * @param tree 胜者树结点数组
         * @param leafsize 胜者树的叶子结点树
         * @param TreeSize 所有结点数
         * @param loadindex 叶子结点存放的起始位置
         * */
        TreeNode[] tree;
        int leafsize = 1;

        //胜者树的叶子结点个数必须是2的幂，确保为完全二叉树
        while (leafsize<this.curlen){
            leafsize *= 2;
        }

        int TreeSize = 2*leafsize-1;
        int loadindex = leafsize-1;
        tree = new TreeNode[TreeSize];
        int j=0;
        //把待排序结点复制到胜者树的叶子结点中
        for (int i = loadindex; i<TreeSize; i++){
            tree[i] = new TreeNode();
            tree[i].index = i;
            if (j<this.curlen){
                tree[i].active = 1;
                tree[i].data = r[j++];
            }else {
                tree[i].active = 0;

            }
        }

        int i = loadindex; //初始化查找关键子值最小的结点
        while (i>0){
            j = i;
            while (j<2*i){
                if (tree[j+1].active==0||(tree[j].data).key.compareTo((tree[j+1]).data.key)<=0){ //右孩子为空 左孩子小于右孩子
                    tree[(j-1)/2] = tree[j]; //左孩子给父节点
                }else {
                    tree[(j-1)/2] = tree[j+1]; //右孩子给父结点
                }
                j += 2; //进入下一组
            }
            i = (i-1)/2; //下一个父节点所在的数组位置
        }

    }

    /**
     * 堆排序
     * */
    //筛选法调整堆算法
    public void sift(int low, int high){
        int i = low; //根结点
        int j = 2*i+1; //左孩子
        RecordNode temp = r[i];

        while (j<high){
            if (j<high-1&&r[j].key.compareTo(r[j+1].key)>0){
                j++; //记录比较，j为左右孩子的较小者
            }
            if (temp.key.compareTo(r[j].key)>0){ //父结点值较大
                r[i] = r[j];
                i = j; //新根结点
                j = 2*i + 1; //新左孩子
            }else {
                j = high + 1; //退出循环
            }
        }
        r[i] = temp; //当前子树的原根结点调整后的位置
    }

    //堆排序算法
    public void heapSort(){
        System.out.println("堆排序");
        int n = this.curlen;
        RecordNode temp;

        for (int i = (n/2)+1; i>=0; i--){
            sift(i, n); //创建初始堆
        }

        for (int i=n-1; i>0; i--){
            temp = r[0]; //将根结点最小的数字换到最后
            r[0] = r[i];
            r[i] = temp;
            sift(0, i);
        }
    }

    public int length(){
        return curlen;
    }

    /**
     * 顺序查找算法
     * */
    public int seqSearch(Comparable key){
        int i = 0, n = length();
        while (i<n&&r[i].key.compareTo(key)!=0){
            i++;
        }
        if (i<n){ //查找成功返回位置，失败返回-1
            return n;
        }else {
            return -1;
        }
    }

    /**
     * 顺序查找-加入哨兵结点
     */
    public int seqSearchWithGuard(Comparable key){
        int i = length()-1;
        r[0].key = key;
        while ((r[i].key).compareTo(key)!=0){
            i--;
        }
        if (i>0){
            return i;
        }else {
            return -1;
        }
    }

    /**
     * 二分查找算法
     *
     */
    public int binarySearch(Comparable key){
        int length = length();
        if (length>0){
            int low = 0, high = length-1;
            while (low<=high){
                int mid = (high+low)/2;
                if (r[mid].key.compareTo(key)==0){
                    return mid;
                }else if (r[mid].key.compareTo(key)>0){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
