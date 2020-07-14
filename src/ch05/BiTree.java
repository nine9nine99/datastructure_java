package ch05;

import ch03.LinkQueue;
import ch03.LinkStack;

public class BiTree {
    private BiTreeNode root;//根结点
    public BiTree(){//空树
        this.root = null;
    }

    public BiTree(BiTreeNode root){
        this.root = root; //构造一棵树
    }

    //先序序列和中序序列创建一棵二叉树的算法
    public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count){
        if (count>0){
            char r = preOrder.charAt(preIndex);//charAt返回索引处字符
            int i = 0;
            for (;i<count;i++){
                if (r == inOrder.charAt(i+inIndex))
                    break;
            root = new BiTreeNode(r);
            root.lchild = new BiTree(preOrder, inOrder, preIndex+1, inIndex, i).root; //建立左子树
            root.rchild = new BiTree(preOrder, inOrder, preIndex+i+1, inIndex+i+1, count-i-1).root;
            //建立右子树
            }
        }
    }

    public void preRootTraverse(BiTreeNode T){
        if (T != null){
            System.out.println(T.data);
            preRootTraverse(T.lchild);
            preRootTraverse(T.rchild);
        }
    }

    public void inRootTraverse(BiTreeNode T){
        if (T!=null){
            inRootTraverse(T.lchild);
            System.out.println(T.data);
            inRootTraverse(T.rchild);
        }
    }

    public void postRootTraverse(BiTreeNode T){
        if (T!=null){
            postRootTraverse(T.lchild);
            postRootTraverse(T.rchild);
            System.out.println(T.data);
        }
    }

    //先序遍历的非递归操作
    public void preRootTraverse() throws Exception {
        BiTreeNode T = root;
        if (T != null){
            LinkStack S = new LinkStack();
            S.push(T);
            while (!S.isEmpty()){
                T = (BiTreeNode)S.pop();
                System.out.print(T.data);
                while (T!=null){
                    if (T.lchild!=null)
                        System.out.print(T.lchild.data+" ");
                    if (T.rchild!=null)
                        S.push(T.rchild);
                    T = T.lchild;
                }
            }
        }
    }

    //中序非递归遍历
    public void inRootTraverse() throws Exception{
        BiTreeNode T = root;
        if (T!=null){
            LinkStack S = new LinkStack();
            S.push(T);
            if (!S.isEmpty()){
                while (S.peek()!=null){//判断栈顶元素
                    S.push(((BiTreeNode)S.peek()).lchild);
                }
            }
            S.pop();
            if (!S.isEmpty()){
                T = (BiTreeNode)S.pop();
                System.out.println(T.data);
                S.push(T.rchild);
            }
        }
    }
/**
 * 入一次右，便不停入左
 *
 * */
    //后序非递归操作
    public void postRootTraverse(){
        BiTreeNode T = root;
        if (T!=null){
            Stack S = new Stack(8);
            S.push(T);      //根结点入栈
            boolean flag;   //访问标记
            BiTreeNode p = null;  //p指向刚访问的结点
            while (!S.isEmpty()){
                while (S.peek()!=null){
                    S.push(((BiTreeNode)S.peek()).lchild);//左孩子连续入栈
                     }
                S.pop();
                /**NullPointerException*/
                while (!S.isEmpty()){
                    T = (BiTreeNode)S.peek(); //查看栈顶元素
                    if (T.getRchild()==null || T.getRchild()==p){ //确认到叶子结点
                        System.out.print(T.getData());
                        S.pop();  //移除栈顶元素
                        p = T;  //p指向刚被访问的结点
                        flag = true;  //设置访问标记
                    }else {
                        S.push(T.getRchild());
                        flag = false;
                    }
                    if (!flag)//入的值为右孩子则退出循环
                        break;
                }
            }
        }
    }

    //层级遍历
    public void levelTraverse(BiTreeNode root){
        BiTreeNode T = root;
        if (T!=null){
            LinkQueue L = new LinkQueue();
            L.offer(T); //根结点入栈
            while (!L.isEmpty()){
                T = (BiTreeNode)L.poll();//结点出队
                System.out.print(T.data);
                if (T.lchild!=null)
                    L.offer(T.lchild);
                if (T.rchild!=null)
                    L.offer(T.rchild);
            }
        }
    }

    //查找一个点
    public BiTreeNode searchNode(BiTreeNode t, Object x){
        if (t!=null){
            if (t.data.equals(x))
                return t;
            else{
                BiTreeNode lresult = searchNode(t, x);
                return lresult != null ? lresult : searchNode(t.rchild, x);
            }
        }
        return null;
    }

    //计算二叉树结点个数
    public int countNode(BiTreeNode T){
        int count = 0;
        if (T!=null){
            ++count;
            count += countNode(T.lchild);
            count += countNode(T.rchild);
        }
        return count;
    }

    public static class DebugBiTree{
        public BiTree creatBiTree(){
            BiTreeNode d = new BiTreeNode('D');
            BiTreeNode g = new BiTreeNode('G');
            BiTreeNode h = new BiTreeNode('H');
            BiTreeNode e = new BiTreeNode('E', g, null);
            BiTreeNode b = new BiTreeNode('B', d,e);
            BiTreeNode f = new BiTreeNode('F', null, h);
            BiTreeNode c = new BiTreeNode('C', f, null);
            BiTreeNode a = new BiTreeNode('A', b, c);
            return new BiTree(a);
        }

        public static void main(String[] args) throws Exception {
            DebugBiTree debugBiTree = new DebugBiTree();
            BiTree biTree = debugBiTree.creatBiTree();
            BiTreeNode root = biTree.root;

            biTree.postRootTraverse();
        }
    }

    public int getDepth(BiTreeNode T){
        if (T!=null) {
            int lDepth = getDepth(T.lchild);
            int rDepth = getDepth(T.rchild);
            return 1 + (lDepth > rDepth ? lDepth : rDepth);
        }
        return 0;
    }

    //判断两棵树是否相等
    public boolean isEqual(BiTreeNode T1, BiTreeNode T2){
        if (T1==null&&T2==null)
            return true;
        if (T1!=null&&T2!=null)
            if (T1.data.equals(T2.data))
                if (isEqual(T1.lchild, T2.lchild))
                    if (isEqual(T2.rchild, T2.rchild))
                        return true;
        return false;
    }

    //递归判断两个二叉树是否相等
    public boolean isEqual1(BiTreeNode T1, BiTreeNode T2){
        if (T1 == null && T2 == null)
            return true;
        else if (T1!=null && T2!=null)
            return (T1.data.equals(T2.data))&&(isEqual1(T1.lchild, T2.lchild))&&
                    (isEqual1(T1.rchild, T2.rchild));
        else
            return false;
    }


    public BiTreeNode getRoot(){
        return root;
    }

    public void setRoot(BiTreeNode root){
        this.root = root;
    }
}
