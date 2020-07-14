package ch04;

import java.util.Scanner;

/**
 * 制作魔方阵
 * */

class Magic {
    public Magic(int n){
        int mat[][] = new int[n][n];
        int i = 0;
        int j = n/2;
        for (int k=1; k<n*n; k++){
            mat[i][j] = k;
            if (k%n==0){ //下一位置有数字
                i = (i+1)%n; //下一数字在下一行
            }else {
                i = (i-1+n)%n; //上一行 保证第一行的元素会进入最后一行
                j = (j+1)%n; //下一列
            }
        }

        for (i=0; i<mat.length; i++){
            for (j=0; j<mat[i].length; j++)
                System.out.print(mat[i][j]+"\t");
            System.out.println();
        }
    }
}

public class Example4_7 {
    public static void main(String[] args){
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("魔方阵的阶数n：");
        n = scanner.nextInt();
        System.out.println(n+"阶魔方阵：");
        new Magic(n);
    }
}
