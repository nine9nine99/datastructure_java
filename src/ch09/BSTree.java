package ch09;

import ch05.BiTreeNode;
import ch07.RecordNode;

public class BSTree {
    public BiTreeNode root;
    public BSTree(){
        root = null;
    }
    /**
     * 二叉排序树定义
     * */
    public void inOrderTraverse(BiTreeNode p){
        if (p!=null){
            inOrderTraverse(p.lchild);
            System.out.print((p.data).toString()+"\t");
            inOrderTraverse(p.rchild);
        }
    }

    /**
     * 二叉排序树的查找
     * */
    public Object searchBST(Comparable key){
        if (key==null||!(key instanceof Comparable)){
            return null;
        }
        return searchBST(root, key);
    }

    public Object searchBST(BiTreeNode p, Comparable key){
        if (p!=null){
            if (key.compareTo(((RecordNode)p.data).key)==0){
                return p.data;
            }
            if (key.compareTo(((RecordNode)p.data).key)<0){
                searchBST(p.lchild, key);
            }else {
                searchBST(p.rchild, key);
            }
        }
        return null;
    }

    /**
     * 二叉树插入操作
     * */
    //插入根结点
    public boolean insertBST(Comparable key, Object theElement){
        if (key==null || !(key instanceof Comparable)){//不能插入空对象或不可比较大小的对象
            return false;
        }
        if (root == null){
            root = new BiTreeNode(new RecordNode(key, theElement));
            return true;
        }
        return insertBST(root, key, theElement);
    }

    //插入左子树，右子树
    public boolean insertBST(BiTreeNode p, Comparable key, Object theElement){
        if (key.compareTo(((RecordNode)p.data).key)==0){ //值相同的结点不会被加入
            return false;
        }
        if (key.compareTo(((RecordNode)p.data).key)<0){
            if (p.lchild==null){ //左子树为空
                p.lchild = new BiTreeNode(new RecordNode(key, theElement)); //值作为该根的叶子结点
                return true;
            }else {
                return insertBST(p.lchild, key, theElement); //插入到p的左子树
            }
        }else if (p.rchild==null){
            p.rchild = new BiTreeNode(new RecordNode(key, theElement)); //作为p的右叶子结点
            return true;
        }else {
            return insertBST(p.rchild, key, theElement); //插入到p的右子树
        }
    }

    //对结点进行删除，成功返回删除值，失败返回null
    public Object removeBST(Comparable key){
        if (root==null||key==null||!(key instanceof Comparable)){
            return null;
        }
        return removeBST(root, key, null);
    }

    //以p为根结点的二叉排序树中删除elemKey结点，parent为p的父节点
    private Object removeBST(BiTreeNode p, Comparable elemKey, BiTreeNode parent){
        if (p!=null){
            if (p!=null){
                if (elemKey.compareTo(((RecordNode)p.data).key)<0){//小于根结点，从左子树中删除
                    return removeBST(p.lchild, elemKey, p);//进入左子树中递归
                }else if (elemKey.compareTo(((RecordNode)p.data).key)>0){//大于根结点，从右子树删除
                    return removeBST(p.rchild, elemKey, p);//进入右子树递归
                }else if (p.lchild!=null&&p.rchild!=null){ //删除的结点有左右子树
                    BiTreeNode innext = p.rchild; //寻找中根次序下的后续结点，即最左结点
                    while (innext.lchild!=null){
                        innext = innext.lchild;
                    }
                    p.data = innext.data; //后继结点代替p
                    return removeBST(p.rchild, ((RecordNode)p.data).key, p); //递归删除p的右子树
                }else {
                    if (parent==null){//删除根结点
                        if (p.lchild!=null){
                            root = p.lchild;
                        }else {
                            root = p.rchild;
                        }
                        return p.data;
                    }
                    if (p==parent.lchild){//删除的是左孩子
                        if (p.lchild!=null){
                            parent.lchild = p.lchild; //p的左子树填补
                        }else {
                            parent.lchild = p.rchild; //p的右子树填补
                        }
                    }else if (p.rchild!=null){ //删除的是右孩子
                        parent.rchild = p.lchild;
                    }else {
                        parent.rchild = p.rchild;
                    }
                    return p.data;
                }
            }
        }
        return null;
    }
}
