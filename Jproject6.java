mport java.util.Scanner;

public class bytedemo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=0,c,d,e;
        for(int i=100;i<=a;i++){
            c=i/100;
            d=i/10%10;
            e=i%10;
            if(c*c*c+d*d*d+e*e*e==i)
                System.out.println(i);
        }
    }
//        for (int i=0;i<=a;i+=2)
//        {
//            b+=i;
//        }
//        System.out.println(b);
// }
}
