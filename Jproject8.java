import java.util.Random;
import java.util.Scanner;


public class source {
    public static int add(int x,int y){
        return x+y;
    }
    public static boolean judge(int x,int y){
        return (x==y?true:false);
    }
    public static boolean judge(double x,double y){
        return (x==y?true:false);
    }
    public static boolean judge(long x,long y){
        return (x==y?true:false);
    }
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            Random r=new Random();
            int a=sc.nextInt(),b=sc.nextInt();
            double c=sc.nextDouble();
            double d=sc.nextDouble();
            long e=sc.nextLong(),f=sc.nextLong();
            if(judge(c,d))
                System.out.println("EQUAL");
            else
                System.out.println("NOT EQUAL");
            if(judge(a,b))
                System.out.println("equal");
            else
                System.out.println("not equal");
            if(judge(e,f))
            System.out.println("Equal");
            else
            System.out.println("Not Equal");

//        System.out.println("guess the number in 0~100!");
//        int num=r.nextInt(101);
//        int i=0,a;
//        System.out.println(add(i,num));
//        while (true){
//            i+=1;
//            System.out.printf("第%d次猜测：",i);
//            a=sc.nextInt();
//            if(a>num)
//                System.out.println("bigger");
//            else if(a<num)
//                System.out.println("smaller");
//            else{
//                System.out.println("congratulations!猜对了");
//                break;
//            }
//        for (int i = 0; i < 10; i++) {
//            int num=r.nextInt(10);
//            System.out.println(num);
        }
        //   System.out.println("number is: "+num);
}
