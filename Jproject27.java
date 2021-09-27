package util;

import java.util.Arrays;
import java.util.List;

public class CRC {

    /**
     * CRC计算器
     *
     * @param data       数据流
     * @param polynomial 多项式
     * @return CheckCode
     */
    public static char[] Calculate(char[] data, String polynomial) {
        //TODO
        StringBuilder str=new StringBuilder();
        str.append(String.valueOf(data));
        for (int i = 0; i < polynomial.length(); i++) {
            str.append(0);
        }
        //System.out.println(str.toString());
        StringBuffer tem=new StringBuffer();
        tem.append(str.substring(0,polynomial.length()));
        //System.out.println(tem.toString());
        char[] res=new char[polynomial.length()];
        for (int i = 0; i < str.length()-polynomial.length(); i++) {
            if(tem.charAt(0)=='1')
                for (int j = 0; j < polynomial.length(); j++) {
                    res[j]= (char) (48+(tem.charAt(j)^polynomial.charAt(j)));
                }
            else if(tem.charAt(0)=='0')
                for (int j = 0; j < polynomial.length(); j++) {
                    res[j]= tem.charAt(j);
                }
           // System.out.println("res:"+String.valueOf(res));
            tem=new StringBuffer();
            for (int j = 1; j < res.length; j++) {
                tem.append(res[j]);
            }
            tem.append(str.charAt(i+polynomial.length()));
            //System.out.println("tem:"+tem.toString());
        }
        char[] result=new char[res.length-1];
        for (int i = 1; i < res.length; i++) {
            result[i-1]=res[i];
        }
        return result;
    }

    /**
     * CRC校验器
     *
     * @param data       接收方接受的数据流
     * @param polynomial 多项式
     * @param CheckCode  CheckCode
     * @return 余数
     */
    public static char[] Check(char[] data, String polynomial, char[] CheckCode) {
        //TODO
//        StringBuffer CheckCode2=new StringBuffer();
//        CheckCode2.append(String.valueOf(CheckCode));
////        while (CheckCode2.length()<polynomial.length())
////        {
////            CheckCode2.insert(0,'0');
////        }
        String str=String.valueOf(data)+String.valueOf(CheckCode)+'0';
        System.out.println(str);
        StringBuffer tem=new StringBuffer();
        tem.append(str.substring(0,polynomial.length()));
        System.out.println(tem.toString());
        System.out.println(str.length());
        System.out.println(polynomial.length());
        char[] res=new char[polynomial.length()];
        for (int i = 0; i < str.length()-polynomial.length(); i++) {
            if(tem.charAt(0)=='1') {
                for (int j = 0; j < polynomial.length(); j++) {
                    res[j] = (char) (48 + (tem.charAt(j) ^ polynomial.charAt(j)));
                }
            }
            else if(tem.charAt(0)=='0')
                for (int j = 0; j < polynomial.length(); j++) {
                    res[j]= tem.charAt(j);
                }
            //System.out.println("res:"+String.valueOf(res));
            tem=new StringBuffer();
            for (int j = 1; j < res.length; j++) {
                tem.append(res[j]);
            }
            tem.append(str.charAt(i+polynomial.length()));
            //System.out.println("tem:"+tem.toString());
            System.out.println(String.valueOf(res));
        }
        char[] result=new char[res.length-1];
        for (int i = 1; i < res.length; i++) {
            result[i-1]=res[i];
        }
        return result;
    }


    public static void main(String[] args) {
        char[] ly={'1','1','1','1'};
        System.out.println(String.valueOf(Calculate(ly,"1101")));
        //System.out.println(String.valueOf(Check("1111".toCharArray(),"1101","111".toCharArray())));
    }

//    public static char[] calcu_inpaper(char[] tar,char[] tool,int count)
//    {
//        int len=tool.length;
//        StringBuffer str=new StringBuffer();
//        for (int i = len-1; i>=0; i--) {
//            if(tar[i+count]=='1'){
//            if(tool[i]=='0')
//                str.append(1);
//            else
//                str.append(0);
//            }
//            else{
//                if(tool[i]=='0')
//                    str.append(0);
//                else{
//                    str.append(1);
//                    tar[i+count-1]='0';
//                }
//            }
//        }
//        str.reverse();
//        return str.toString().toCharArray();//   }
}
