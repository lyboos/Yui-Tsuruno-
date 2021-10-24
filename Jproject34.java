public class PolynList {


    public static int lastRemaining(int n, int m) {//不要更改这里的static修饰符
        // 具体代码写这里
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for (int i = 0; i <=n-1 ; i++) {
            list.add(i);
        }
        int realm=m;
        while (list.size()>1){
            int realn=list.size();
            while (realm>realn)
                realm-=realn;
            list.remove(realm-1);
            realm+=(m-1);
        }
		// 另外因为语言级别的问题，菱形操作符里的具体类型全部要写上，不然可能也会报错；
		// 如：ArrayList<Integer> list = new ArrayList<Integer>(n);
        return list.get(0);//这里return自己的结果
    }

    //多项式相加
    public Node add(Node link1, Node link2) {
        // please enter your code here...
        Node head=new Node();
        Node result=new Node();
        head.next=result;
        if(link1==null&&link2==null)
            return new Node();
        if(link1==null)
            return link2;
        if(link2==null)
            return link1;
        Node start1=link1.next;
        Node start2=link2.next;
        link1=link1.next;
        link2=link2.next;
        int allcount=0;
        int[] arr=new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i]=-314;
        }
        while (start1!=null){
            arr[allcount]=start1.exp;
            allcount++;
            if(start1.next!=null)
            start1=start1.next;
            else break;
        }
        while (start2!=null){
            arr[allcount]=start2.exp;
            allcount++;
            if(start2.next!=null)
            start2=start2.next;
            else break;
        }
        for (int i = 0; i < allcount-1; i++) {
            for (int j = i+1; j <allcount ; j++) {
                if(arr[i]>arr[j]){
                    int exchange=arr[j];
                    arr[j]=arr[i];
                    arr[i]=exchange;
                }
            }
        }
        //System.out.println(start1.toString());
        //System.out.println(start2.toString());
        int count=0;
        boolean signal1=true,signal2=true;
        while (signal1||signal2){
            Node temp=new Node();
            temp.exp=arr[count];
            if(link1!=null&&signal1)
            {
                if(link1.exp==arr[count]) {
                    temp.coef += link1.coef;
                    if(link1.next!=null)
                    link1 = link1.next;
                    else
                        signal1=false;
                }
            }
            if(link2!=null&&signal2)
            {
                if(link2.exp==arr[count]) {
                    temp.coef += link2.coef;
                    if(link2.next!=null)
                    link2 = link2.next;
                    else signal2=false;
                }
            }
            count++;
            if(count>allcount)
                break;
            if(!(temp.coef==-314||(temp.coef==0)))
            {
                //add_element(temp,result);
                Node nextres=new Node();
                nextres.coef=temp.coef;
                nextres.exp=temp.exp;
                result.next=nextres;
                result=result.next;
            }
        }
        return head.next.next;
   }

    public static void main(String[] args) {
        PolynList polynList=new PolynList();
        Node a=new Node();
        Node b=new Node();
        Node c=new Node(1,1);
        Node d=new Node(4,-2);
        Node e=new Node(7,2);
        Node f=new Node(9,3);
        a.next=c;
        b.next=d;
        c.next=e;
        d.next=f;
        System.out.println(polynList.add(a,b).toString());
    }

    private void add_element(Node adder,Node origin){
        Node temp=new Node();
        temp.coef=adder.coef;
        temp.exp=adder.exp;
        origin.next=temp;
    }
}
