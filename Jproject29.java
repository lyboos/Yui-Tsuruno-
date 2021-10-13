package cpu.fpu;

import util.DataType;
import util.IEEE754Float;
import util.Transformer;

/**
 * floating point unit
 * 执行浮点运算的抽象单元
 * 浮点数精度：使用3位保护位进行计算
 */
public class FPU {

    private final String[][] addCorner = new String[][]{
            {IEEE754Float.P_ZERO, IEEE754Float.P_ZERO, IEEE754Float.P_ZERO},
            {IEEE754Float.N_ZERO, IEEE754Float.P_ZERO, IEEE754Float.P_ZERO},
            {IEEE754Float.P_ZERO, IEEE754Float.N_ZERO, IEEE754Float.P_ZERO},
            {IEEE754Float.N_ZERO, IEEE754Float.N_ZERO, IEEE754Float.N_ZERO},
            {IEEE754Float.P_INF, IEEE754Float.N_INF, IEEE754Float.NaN},
            {IEEE754Float.N_INF, IEEE754Float.P_INF, IEEE754Float.NaN}
    };

    private final String[][] subCorner = new String[][]{
            {IEEE754Float.P_ZERO, IEEE754Float.P_ZERO, IEEE754Float.P_ZERO},
            {IEEE754Float.N_ZERO, IEEE754Float.P_ZERO, IEEE754Float.N_ZERO},
            {IEEE754Float.P_ZERO, IEEE754Float.N_ZERO, IEEE754Float.P_ZERO},
            {IEEE754Float.N_ZERO, IEEE754Float.N_ZERO, IEEE754Float.P_ZERO},
            {IEEE754Float.P_INF, IEEE754Float.P_INF, IEEE754Float.NaN},
            {IEEE754Float.N_INF, IEEE754Float.N_INF, IEEE754Float.NaN}
    };

    /**
     * compute the float add of (dest + src)
     */
    public DataType add(DataType src, DataType dest) {
        // TODO
        if(CheckNaN(src, dest)!=null)
            return new DataType(IEEE754Float.NaN);
        String a=src.toString();
        String b=dest.toString();
        if(cornerCheck(addCorner,a,b)!=null)
            return new DataType(cornerCheck(addCorner,a,b));
        if(a.substring(1).equals("0000000000000000000000000000000"))
            return dest;
        if(b.substring(1).equals("0000000000000000000000000000000"))
            return src;
        if(a.substring(1).equals(b.substring(1))&&a.charAt(0)!=b.charAt(0))
            return new DataType(IEEE754Float.P_ZERO);
        char a_symbol=a.charAt(0);
        char b_symbol=b.charAt(0);
        String a_exp=get_exp(a);
        String b_exp=get_exp(b);
        boolean bisnor=true;
        boolean aisnor=true;
        String a_spcify=get_spcify(a);
        String b_spcify=get_spcify(b);


        if(a_exp.equals("00000000"))
        {
            a_exp=oneAdder(a_exp).substring(1);
            aisnor=false;
        }
        if(b_exp.equals("00000000"))
        {
            bisnor=false;
            b_exp=oneAdder(b_exp).substring(1);
        }
        while (!a_exp.equals(b_exp)){
            if(Integer.parseInt(a_exp)>Integer.parseInt(b_exp))
            {
                b_exp=oneAdder(b_exp).substring(1);
                b_spcify=rightShift(b_spcify,1);
            }
            else
                {
                a_exp=oneAdder(a_exp).substring(1);
                a_spcify=rightShift(a_spcify,1);
                }
        }

        String result_spcify;
        //原码加减法
        char result_symbol=(a_symbol);
        //String result_spcify=add_origin(a_spcify,b_spcify,a_symbol,b_symbol);
        int isnotadd=0;
        String adder1=a_spcify;
        String adder2=b_spcify;
        if(a_symbol!=b_symbol){
            adder2=Reverse(adder2);
            isnotadd=1;
        }
        char[] add1=adder1.toCharArray();
        char[] add2=adder2.toCharArray();
        char[] result=new char[add2.length];
        int bit=0,carry=0;
        for (int i = add1.length-1; i >=0 ; i--) {
            bit=(add1[i]-'0')^(add2[i]-'0')^carry;
            carry=(((add1[i]-'0')&(add2[i]-'0'))|((add1[i]-'0')&carry)|((add2[i]-'0')&carry));
            result[i]=(char) (bit+'0');
        }
        if(String.valueOf(result).substring(1).equals("0000000000000000000000"))
            return new DataType(result_symbol+"0000000000000000000000000000000");
        result_spcify=String.valueOf(result);
        System.out.println(result_spcify);
        String result_exp=a_exp;
        if(carry==1&&isnotadd==0){
            result_spcify="1"+result_spcify.substring(0,result_spcify.length()-1);
            result_exp=oneAdder(result_exp).substring(1);
            if(result_exp.equals("11111111")){
                return new DataType(result_symbol+"1111111100000000000000000000000");
            }
        }
        else if(isnotadd==1&&carry==0){
            result_spcify=Reverse(result_spcify);
            result_symbol=(b_symbol);
        }
        //规格化
        while (result_spcify.charAt(0)!='1'&&!result_exp.equals("00000000")){
            char[] leftmove=result_spcify.toCharArray();
            for (int i = 0; i < leftmove.length-1; i++) {
                leftmove[i]=leftmove[i+1];
            }
            leftmove[leftmove.length-1]='0';
            result_spcify=String.valueOf(leftmove);
            //sub one to exp
            result_exp=add_origin(result_exp,"11111111",'1','1');
            //System.out.println("+1:"+result_exp);
        }
        //溢出判断
        if(result_exp.equals("00000000"))
        {
            char[] rightmove=result_spcify.toCharArray();
            for (int i = rightmove.length-1; i >0; i--) {
                rightmove[i]=rightmove[i-1];
            }
            rightmove[0]='0';
            result_spcify=String.valueOf(rightmove);
        }


        StringBuffer result_final=new StringBuffer(round(result_symbol,result_exp,result_spcify));

        System.out.println("src:"+a);
        System.out.println("dest:"+b);
        System.out.println("result:"+result_final.toString());
        return new DataType(result_final.toString());
    }

    private String add_origin(String adder1, String adder2,char a1symbol,char a2symbol) {
        int isnotadd=0;
        if(a1symbol!=a2symbol){
            adder2=Reverse(adder2);
            isnotadd=1;
        }
        char[] add1=adder1.toCharArray();
        char[] add2=adder2.toCharArray();
        char[] result=new char[add2.length];
        int bit=0,carry=0;
        for (int i = add1.length-1; i >=0 ; i--) {
            bit=(add1[i]-'0')^(add2[i]-'0')^carry;
            carry=((add1[i]-'0')&(add2[i]-'0')|((add1[i]-'0')&carry)|((add2[i]-'0')&carry));
            result[i]=(char) (bit+'0');
        }
            return String.valueOf(result);
    }

    private String get_exp(String str) {
        return str.substring(1,9);
    }

    private String get_spcify(String str) {
            StringBuffer stringBuffer=new StringBuffer();
        if(get_exp(str).equals("00000000"))
            stringBuffer.append('0');
        else
            stringBuffer.append('1');
            stringBuffer.append(str.substring(9));
            stringBuffer.append("000");
            return stringBuffer.toString();

    }

    private String Reverse(String origin1){
        StringBuffer origin=new StringBuffer(origin1);
        for(int i=0;i<origin.length();i++){
            if(origin.charAt(i)=='0'){
                origin.replace(i,i+1,"1");
                continue;
            }
            if(origin.charAt(i)=='1'){
                origin.replace(i,i+1,"0");
                continue;
            }
        }
        for(int i=origin.length()-1;i>=0;i--){
            if(origin.charAt(i)=='1'){
                origin.replace(i,i+1,"0");
                continue;
            }
            if(origin.charAt(i)=='0'){
                origin.replace(i,i+1,"1");
                return origin.toString();
            }
        }
        return origin.toString();
    }

    public static void main(String[] args) {

//        FPU fpu=new FPU();
//        Transformer transformer=new Transformer();
//        DataType a=new DataType(transformer.floatToBinary("0.5"));
//        DataType b=new DataType(transformer.floatToBinary("-0.4375"));
//        System.out.println(a.toString());
//        System.out.println(b.toString());
//        System.out.println(fpu.add(a,b).toString());
    }

    /**
     * compute the float add of (dest - src)
     */
    public DataType sub(DataType src, DataType dest) {
        // TODO
        StringBuffer src_reverse=new StringBuffer(src.toString());
        if(src_reverse.charAt(0)=='1')
        src_reverse.replace(0,1,"0");
        else if(src_reverse.charAt(0)=='0')
        src_reverse.replace(0,1,"1");
        return add(dest,new DataType(src_reverse.toString()));
    }


    private String cornerCheck(String[][] cornerMatrix, String oprA, String oprB) {
        for (String[] matrix : cornerMatrix) {
            if (oprA.equals(matrix[0]) && oprB.equals(matrix[1])) {
                return matrix[2];
            }
        }
        return null;
    }

    /**
     * right shift a num without considering its sign using its string format
     *
     * @param operand to be moved
     * @param n       moving nums of bits
     * @return after moving
     */
    private String rightShift(String operand, int n) {
        StringBuilder result = new StringBuilder(operand);  //保证位数不变
        boolean sticky = false;
        for (int i = 0; i < n; i++) {
            sticky = sticky || result.toString().endsWith("1");
            result.insert(0, "0");
            result.deleteCharAt(result.length() - 1);
        }
        if (sticky) {
            result.replace(operand.length() - 1, operand.length(), "1");
        }
        return result.substring(0, operand.length());
    }

    /**
     * 对GRS保护位进行舍入
     *
     * @param sign    符号位
     * @param exp     阶码
     * @param sig_grs 带隐藏位和保护位的尾数
     * @return 舍入后的结果
     */
    private String round(char sign, String exp, String sig_grs) {
        int grs = Integer.parseInt(sig_grs.substring(24), 2);
        String sig = sig_grs.substring(0, 24);
        if (grs > 4) {
            sig = oneAdder(sig);
        } else if (grs == 4 && sig.endsWith("1")) {
            sig = oneAdder(sig);
        }

        if (Integer.parseInt(sig.substring(0, sig.length() - 23), 2) > 1) {
            sig = rightShift(sig, 1);
            exp = oneAdder(exp).substring(1);
        }
        return sign + exp + sig.substring(sig.length() - 23);
    }

    /**
     * add one to the operand
     *
     * @param operand the operand
     * @return result after adding, the first position means overflow (not equal to the carray to the next) and the remains means the result
     */
    private String oneAdder(String operand) {
        int len = operand.length();
        StringBuilder temp = new StringBuilder(operand);
        temp.reverse();
        int[] num = new int[len];
        for (int i = 0; i < len; i++) num[i] = temp.charAt(i) - '0';  //先转化为反转后对应的int数组
        int bit = 0x0;
        int carry = 0x1;
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            bit = num[i] ^ carry;
            carry = num[i] & carry;
            res[i] = (char) ('0' + bit);  //显示转化为char
        }
        String result = new StringBuffer(new String(res)).reverse().toString();
        return "" + (result.charAt(0) == operand.charAt(0) ? '0' : '1') + result;  //注意有进位不等于溢出，溢出要另外判断
    }

    private DataType CheckNaN(DataType src,DataType dest){
        String a = dest.toString();
        String b = src.toString();
        if (a.matches(IEEE754Float.NaN_Regular) || b.matches(IEEE754Float.NaN_Regular)) {
            return new DataType(IEEE754Float.NaN);
        }
        return null;
    }
}
