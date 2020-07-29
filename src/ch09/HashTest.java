package ch09;

public class HashTest {
    int[] elem;
    public int count;
    private int maxSize = 20;

    private final int NULLKEY = -32769;
    public final int SUCCESS = 1;
    public final int UNSUCCESS = 0;

    //散列初始化
    public HashTest(){
        this.elem = new int[maxSize];
        this.initHashTest();
    }

    public HashTest(int maxSize){
        this.maxSize = maxSize;
        this.elem = new int[maxSize];
        this.initHashTest();
    }

    //初始化散列
    public void initHashTest(){
        for (int i = 0; i<maxSize; i++){
            this.elem[i] = NULLKEY;
        }
    }

    //散列求值
    public int Hash(int key){
        return key%maxSize;
    }

    public void insertHash(int key){
        int addr = Hash(key);//散列地址
        while (this.elem[addr]!=NULLKEY){
            addr = Hash(addr+1); //线性探索
        }
        this.elem[addr] = key;
        ++count;
    }

    //插入关键字
}
