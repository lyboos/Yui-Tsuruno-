import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class calculate {
    private static Deque<Character> symbolDeque=new LinkedList<>();
    private static Deque<Double> numberDeque=new LinkedList<>();

    private static void cal(){
        double a=numberDeque.pop();
        double b=numberDeque.pop();
        char c=symbolDeque.pop();

        switch (c){
            case '+': numberDeque.push(b+a);break;
            case '-': numberDeque.push(b-a);break;
            case '*': numberDeque.push(b*a);break;
            case '/': numberDeque.push(b/a);break;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String calcu=sc.nextLine();
        char[] formula=calcu.toCharArray();
        int i=0;
        while (i<calcu.length()){
            char c=formula[i];
            if(isOp(c))
            {
                Character before=symbolDeque.peek();
                    while (before!=null&&isHigher(before,c)){
                        cal();
                        before=symbolDeque.peek();
                    }
                    symbolDeque.push(c);
                    i++;

            }
            else {
                String num=""+c;
                i++;
                while (i<=formula.length-1&&!isOp(formula[i]))
                {
                    num+=formula[i];
                    i++;
                }
                numberDeque.push(Double.parseDouble(num));
            }

        }
        while (!symbolDeque.isEmpty()) cal();
        System.out.println(numberDeque.peek());


    }

    private static boolean isHigher(char b,char c) {
        return (b=='*'||b=='/'||c=='+'||c=='-');
    }

    private static boolean isOp(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*';
    }
}
