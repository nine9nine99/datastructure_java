package ch04;

public class SeqString implements IString{
    private char[] strvalue; //字符串数组，存放串值
    private int curlen; //串长度

    //构造方法1，构造一个空串
    public SeqString(){
        strvalue = new char[0];
        curlen = 0;
    }

    //构造方法2，以字符串常量构造串对象
    public SeqString(String str){
        char[] tempchararray = str.toCharArray();
        strvalue = tempchararray;
        curlen = tempchararray.length;
    }

    //构造方法3，以字符数组构造串对象
    public SeqString(char[] value){
        this.strvalue = new char[value.length];
        for (int i=0; i<value.length; i++){
            this.strvalue[i] = value[i];
        }
        curlen = value.length;
    }


    @Override
    public void clear() {
        this.curlen = 0;
    }

    @Override
    public boolean isEmpty() {
        if (this.curlen==0)
            return true;
        else
            return false;
    }

    @Override
    public int length() {
        return curlen;
    }

    @Override
    public char charAt(int index) {
        if (index<0 || index>curlen)
            throw new StringIndexOutOfBoundsException(index);
        else
            return strvalue[index];
    }

    //扩充字符串存储空间容量，参数制定容量
    public void allocate(int newCapacity){
        char[] temp = strvalue;
        strvalue = new char[newCapacity];//扩充数组
        for (int i=0; i<temp.length; i++)
            strvalue[i] = temp[i];
    }

    //返回串中序号从begin到end-1的子串
    @Override
    public IString substring(int begin, int end) {
        if (begin<0){
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");
        }
        if (end>curlen){
            throw new StringIndexOutOfBoundsException("结束为止不能大于"+curlen);
        }
        if (begin>curlen){
            throw new StringIndexOutOfBoundsException("起始位置不能大于结束为止");
        }
        if (begin==0&&end==0){
            return this;
        }else {
            char[] buffer = new char[end-begin];
            for (int i=0; i<buffer.length; i++){
                buffer[i] = strvalue[i+begin];
            }
            return new SeqString(buffer);
        }
    }

    @Override
    public IString insert(int offset, IString str) {
        if (offset<0||offset>this.curlen){
            throw new StringIndexOutOfBoundsException("插入位置不合法");
        }
        int len = str.length();
        int newCount = len + this.curlen;
        if (newCount>strvalue.length){
            allocate(newCount);
        }else {
            for(int i = curlen-1; i>=offset; i--){
                strvalue[len+i] = strvalue[i];
            }
            for (int i=0; i<len; i++)
                strvalue[offset+i] = str.charAt(i);
        }
        this.curlen = newCount;
        return this;
    }

    @Override
    public IString delete(int begin, int end) {
        if (begin>end){
            throw new StringIndexOutOfBoundsException("起始位置不能大于结束位置");
        }
        if (begin<0 || end>curlen){
            throw new StringIndexOutOfBoundsException("起始或结束位置不合法");
        }
        for (int i=0; i<curlen-end; i++)
            strvalue[begin+i] = strvalue[end+i]; //覆盖
        curlen = curlen-(end-begin);
        return this;
    }

    @Override
    public IString concat(IString str) {
        return insert(curlen, str);
    }

    @Override
    public int compareTo(IString str) {
        return 0;
    }

    public int compareTo(SeqString str) {
        char[] s1 = strvalue;
        char[] s2 = str.strvalue;
        int len1 = curlen;
        int len2 = str.curlen;
        int n = Math.min(len1, len2); //选出两个字符串中较短的
        int k=0;
        while (k<n){
            char ch1 = s1[k];
            char ch2 = s2[k];
            if (ch1!=ch2)
                return ch1-ch2; //返回第一个不匹配的字符差
            k++;
        }
        return len1-len2; //返回两个字符串的长度差
    }

    @Override
    public int indexOf(IString str, int begin) {
        return 0;
    }

    //模式串t在主串中从strat开始的第一次匹配位置，匹配失败返回-1
    public int indexOf_BF(IString t, int start){
        int slen = start; //slen主串长度 tlen模式串长度
        int tlen = start;
        int i = start; //主串中子串的序号
        int j = 0;  //子串的起始位置

        if (this!=null&&t!=null&&t.length()>0&&this.length()>0&&this.length()>t.length()){
            while ((i<slen)&&(j<tlen)){
                if (this.charAt(i)==t.charAt(j)){
                    i++;
                    j++;
                }else{
                    i = i-j+1;
                    j=0;
                }
            }if (j>=t.length())
                return i-tlen; //匹配成功返回字符串差值
            else
                return -1; //匹配失败返回-1
        }else
        {
            throw new StringIndexOutOfBoundsException("无法进行匹配");
        }

    }
}
