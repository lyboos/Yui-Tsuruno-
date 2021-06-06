public class test {
    public static void main(String[] args) {
        int a=0,b=1;
        StringBuffer sb=new StringBuffer();
        StringBuilder sp=new StringBuilder();
        try{
            new test().a();
            if(a==0)
            {
                throw new ArithmeticException();
            }
            System.out.println(b/a);
        }
        catch (Exception e){
            System.out.println("exception");
        }
        catch (Throwable e){
            System.out.println("throwable");

        }
        finally {
            System.out.println("this is an error test!");
        }
    }

    public void a(){
        b();
    }

    public void b(){
        a();
    }
}
