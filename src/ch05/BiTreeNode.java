package ch05;

import java.math.BigInteger;
import java.security.PublicKey;
import java.util.Objects;

public class BiTreeNode {
    public Object data;
    public BiTreeNode lchild, rchild;
    //空节点
    public BiTreeNode(){
        this.data = null;
        this.lchild = null;
        this.rchild = null;
    }
    //左右子树为空的二叉树
    public BiTreeNode(Object data){
        this.data = data;
        this.lchild = null;
        this.rchild = null;
    }

    //构造三个域都不为空的二叉树结点
    public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild){
        this.data = data;
        this.rchild = rchild;
        this.lchild = lchild;
    }


    public BiTreeNode getLchild(){
        return lchild;
    }

    public BiTreeNode getRchild(){
        return rchild;
    }

    public Object getData(){
        return data;
    }

    public void setLchild(BiTreeNode lchild){
        this.lchild = lchild;
    }

    public void setRchild(BiTreeNode rchild){
        this.rchild = rchild;
    }

    public void setData(Object data){
        this.data = data;
    }
}
