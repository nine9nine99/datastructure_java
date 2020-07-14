package ch05;

public class HuffmanTree {
    public int[][] huffmanCoding(int[] W) {
        int n = W.length; //字符个数
        int m = 2*n - 1; //结点数
        HuffmanNode[] HN = new HuffmanNode[m];
        int i;
        //nullpointerexception
        for (i = 0; i <= n-1; i++)
            HN[i] = new HuffmanNode(W[i]); //构造n个具有权值的结点
        for (i = n; i < m; i++) {
            HuffmanNode min1 = seleceMin(HN, i - 1);
            min1.flag = 1;
            HuffmanNode min2 = seleceMin(HN, i - 1);
            min2.flag = 1;
            //构造父亲结点
            HN[i] = new HuffmanNode();
            min1.parent = HN[i];
            min2.parent = HN[i];
            HN[i].weight = min1.weight + min2.weight;
            HN[i].lchild = min1;
            HN[i].rchild = min2;
        }

        //从叶子结点向根结点求哈夫曼编码
        int[][] HuffCode = new int[n][n]; //分配n*n个结点空间
        for (int j = 0; j <= n-1; j++) {
            int start = n - 1;    //编码开始位置，初始化为数组的结尾
            for (HuffmanNode c = HN[j], p = c.parent; p != null; c = p, p = p.parent) {
                if (p.lchild.equals(c))
                    HuffCode[j][start--] = 0;
                else
                    HuffCode[j][start--] = 1;
            }
            HuffCode[j][start] = -1; //编码开始位置为-1
        }
        return HuffCode;
    }


    public HuffmanNode seleceMin(HuffmanNode[] HN, int end){
        HuffmanNode min = HN[end];
        for (int i=0; i<= end; i++){
            HuffmanNode h = HN[i];
            if (h.weight<min.weight&&h.flag==0)
                min = h;
        }
        return min;
    }

    public static void main(String[] args){
        int[] W = {23,11,5,3,29,14,7,8};
        HuffmanTree T = new HuffmanTree();
        int[][] HN = T.huffmanCoding(W);
        for (int i=0; i<HN.length; i++){
            System.out.print(W[i] + " ");
            for (int j = 0; j<HN[i].length; j++){
                if (HN[i][j] == -1){
                    for (int k=j+1; k<HN[i].length; k++)
                        System.out.print(HN[i][k]);
                    break;
                }
            }System.out.println();
        }

    }
}
