import java.util.Scanner;

public class forwhile {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
  ly:      for (int i = 0; i < 3; i++) {
         lyy:   for (int j = 0; j < 3; j++) {
                break lyy;
            }
        }
        int count=0;
 ly:       for (int i = 1; i <=3 ; i++) {
            for (int j = 1; j <=35 ; j++) {
                if(j%5==0)
                continue ;
                else{
                    System.out.println("send present to "+i+"班"+j+"号同学");
                    count++;
                }
                if(count>=100)
                    break ly;
            }
              System.out.println();
        }
        System.out.println("共发送"+ count +"个president");
    }
}
