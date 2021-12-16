import java.util.ArrayList;

public class ALU {


    /**
     * TODO 1.实现将整数转化为16位补码
     *
     * @param num 十进制整数（数值大小不会超过16位补码的可表示范围）。
     * @return 16位二进制补码
     */
    public String intToComplement(int num) {
        boolean isNeg=false;
        if(num<0){
            num=-num;
            isNeg=true;
        }
        StringBuilder temp=new StringBuilder();
        while (num>0){
            if (num % 2 == 1) temp.append("1");
            else temp.append("0");
            num/=2;
        }
        String res=temp.reverse().toString();
        int len=res.length();
        for (int i = 0; i < 16 - len; i++) res = "0" + res;
        //System.out.println(res);
        if(isNeg){
            res=oneAdder(negation(res));
        }
        //System.out.println(res);
        return res;
    }

    private String implestr(String target, int length) {
        char symbol=target.charAt(0);
        int origin_length=target.length();
        String res=String.valueOf(target);
        for (int i = 0; i < length-origin_length; i++) {
            res=symbol+res;
        }
        return res;
    }

    private String oneAdder(String operand) {
        int len = operand.length();
        StringBuffer temp = new StringBuffer(operand);
        temp = temp.reverse();
        int[] num = new int[len];
        for (int i = 0; i < len; i++) num[i] = temp.charAt(i) - '0';  //先转化为反转后对应的int数组
        //加1操作
        int bit = 0x0;
        int carry = 0x1;
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            bit = num[i] ^ carry;
            carry = num[i] & carry;
            res[i] = (char) ('0' + bit);  //显示转化为char
        }
        String result = new StringBuffer(new String(res)).reverse().toString();
        return ""  + result;  //注意有进位不等于溢出，溢出要另外判断

    }

    private String negation(String target) {
        String res="";
        for (int i = 0; i < target.length(); i++) {
            res+=(target.charAt(i)=='0'?"1":"0");
        }
        return res;
    }

    /**
     * TODO 2.实现1个全加器
     *
     * @param x: 1位的二进制数
     * @param y: 1位的二进制数
     * @param c: 进位输入，1位的二进制数
     * @return 2位的字符串，包括1位的进位输出和1位的加法运算结果
     */
    public String fullAdder(char x, char y, char c) {
        int bit=(x-'0')^(y-'0')^(c-'0');
        int carry = ((x - '0') & (y - '0')) | ((y - '0') & (c - '0')) | ((x - '0') & (c - '0'));  //有两位为1则产生进位
        return "" + carry + bit;
    }

    /**
     * TODO 3.实现4位的先行进位加法器
     *
     * @param operand1 4位补码
     * @param operand2 4位补码
     * @param c 进位输入，1位的二进制数
     * @return 5位的加法运算结果，包括1位的进位和4位的和
     */
    public String claAdder(String operand1, String operand2, char c) {
        StringBuilder res=new StringBuilder();
        char carry=c;
        for (int i = 3; i >=0 ; i--) {
            String tem=fullAdder(operand1.charAt(i),operand2.charAt(i),carry);
            res.append(tem.charAt(1));
            carry=tem.charAt(0);
        }
        res.append(carry);
        return res.reverse().toString();
    }

    /**
     * TODO 4.实现16位的部分先行进位加法器（要求：基于上述方法claAdder）
     *
     * @param operand1 16位补码
     * @param operand2 16位补码
     * @param c 进位输入，1位的二进制数
     * @return 17位的加法运算结果，包括1位的进位和16位的和
     */
    public String pclaAdder(String operand1, String operand2, char c) {
        String res="";
        for (int i = 3; i >=0 ; i--) {
            String tem=claAdder(operand1.substring(i*4,(i+1)*4),operand2.substring(i*4,(i+1)*4),c);
            c=tem.charAt(0);
            res=(tem.substring(1))+res;
        }
        res=c+res;
        return res;
    }

    /**
     * TODO 5.实现布斯乘法
     *
     * @param operand1 被乘数，十进制整数，不会超过16位补码的可表示范围
     * @param operand2 乘数，十进制整数，不会超过16位补码的可表示范围
     * @return ArrayList的长度为17，第1个元素为初始的product+Y（含Y0，共33位），第2-17个元素为计算过程中每次右移后的product+Y（共33位）
     */
    public ArrayList<String> multiplication(int operand1, int operand2) {
        String dest=intToComplement(operand1);
        String src=intToComplement(operand2);
        String anti_dest=intToComplement(-operand1);
        String product=intToComplement(0)+src;
        int Y1=0,Y2=src.charAt(15)-'0';
        ArrayList<String> res=new ArrayList<String>();
        res.add(product+Y1);
        System.out.println(product+Y1);
        for (int i = 0; i < dest.length(); i++) {
            switch (Y1-Y2){
                case 1:
                    product=adder(product.substring(0,16),dest,16)+product.substring(16);
                    break;
                case -1:
                    product=adder(product.substring(0,16),anti_dest,16)+product.substring(16);
                    break;
                default:
                    break;
            }
            product=product.charAt(0)+product.substring(0,31);
            Y1=Y2;
            Y2=product.charAt(31)-'0';
            System.out.println(product+Y1);
            res.add(product+Y1);
        }
        return res;
    }

    private String adder(String dest, String src, int length) {
        String operand1=implestr(dest,length);
        String operand2=implestr(src,length);
        String res="";
        char carry='0';
        for (int i = length-1; i >= 0; i--) {
            String temp=fullAdder(operand1.charAt(i),operand2.charAt(i),carry);
            carry=temp.charAt(0);
            res=(temp.charAt(1))+res;
        }
        return res;
    }
}
