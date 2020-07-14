package ch02;

public class SqList implements IList {
    private Object[] listElem;
    private int curLen;
    public SqList(int maxSize){
        curLen = 0;//初始化顺序表实际长度
        listElem = new Object[maxSize];
    }
    //将一个存在的表变为空表
    public void clear(){
        curLen = 0;
    }
    //判断一个线性表中的数据元素个数是否为0
    public boolean isEmpty(){
        return curLen == 0;
    }
    //求线性表中元素的个数
    public int length(){
        return curLen;
    }
    public Object get(int i) throws Exception{
        if (i<0 || i>curLen-1)
            throw new Exception("The " + i + " does not exact");
        return listElem[i];
    }
    //插入数据
    public void insert(int i, Object x) throws Exception{
        if (curLen == listElem.length)
            throw new Exception("The list is full");
        if (i<0 || i>curLen)
            throw new Exception("The insert is illegal");
        for (int j = curLen; j>i; j--)
            listElem[j] = listElem[j-1];//插入位置及其之后的所有数据元素往后移一位
        listElem[i] = x;
        curLen++;//表长+1
    }
    //删除数据
    public void remove(int i) throws Exception{
        if (i<0 || i>curLen-1)
            throw new Exception("The delete poison is illegal");
        for (int j = i; j<curLen-1;j++)
            listElem[j] = listElem[j+1];//被删除的元素左移一格
        curLen--;
    }
    //顺序表的查找操作
    public int indexOf(Object x){
        int j = 0;
        while (j<curLen&&!listElem[j].equals(x))
            j++;
        if (j<curLen)
            return j;//返回数据表中的位置
        else
            return -1;//返回的值在顺序表中不存在
    }
    //输出所有数组元素
    public void display() throws Exception{
        int i;
        for (i = 0; i<=curLen; i++)
            System.out.print(listElem[i] + " ");
    }

    public void exchange(){
        int i,j;
        for (i = 0, j=curLen-1; i<j; i++, j--){
                Object ex = listElem[i];
                listElem[i] = listElem[j];
                listElem[j] = ex;
            }
    }

    public void move(int k){
        
    }
}

