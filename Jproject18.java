public interface jiekou {
    public abstract void run();
    void bark();
    void eat();
    void say(String name);
}

public abstract class jiekouimpl implements jiekou{
    private int age;
    private String name;
    public void run(){
        System.out.println("run");
    }
    public void bark(){
        System.out.println("bark");
    }
}

public class avsource extends source{
    private int avnum;
    {
        System.out.println("匿名");
    }

    static {
        System.out.println("静态");
    }
    public avsource(String add) {
        super(add);
    }

    public int getAvnum() {
        return avnum;
    }

    public void setAvnum(int avnum) {
        this.avnum = avnum;
    }

    public static void main(String[] args) {
        avsource av=new avsource("ly");
//        source av=new avsource("bili");
//        System.out.println(av.getAdd());
//        Object cv=new bvsource("pili");
//        System.out.println(av instanceof avsource);
//        System.out.println(av instanceof source);
//        System.out.println(av instanceof bvsource);
//        System.out.println(cv instanceof bvsource);
//        System.out.println(cv instanceof source);
//        System.out.println(cv instanceof Object);
        //System.out.println(av instanceof String);
//        ((bvsource)cv).setName("lyboos");
//        ((bvsource) cv).test();
//        System.out.println(((source)cv).getInterger());
    }
}
