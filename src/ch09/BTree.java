package ch09;

//B树类定义

public class BTree<T> {
    public Node<T>root = null; //根结点
    public int degree;
    public BTree(int t){
        degree = t;
    }

    //B-数的查找工作
    public Result searchBTree(Node<T>root, T key){
        int i=0; //第几个关键字
        Node<T>p = root, q=null; //p指向待查找结点，q指向p的双亲结点
        boolean found = false;
        Result rs = new Result(); //存放查找结果
        Comparable<T>k = (Comparable<T>)key;
        while (p!=null&&!found){
            i=0; //每个结点查找的序号
            while (i<p.keyNum&&k.compareTo((p.key)[i])>0)
                i++;
            if (i<p.keyNum&&k.compareTo((p.key)[i])==0)
                found = true;
            else {
                q=p;
                p=p.child[i];
            }
        }
        if (found==true)
            p=q;
        rs.resultNode = p;
        rs.i = i;
        rs.found = found;
        return rs;
    }
}
