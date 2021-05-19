public class bvsource extends source {

    public bvsource(String add) {
        super(add);
    }

    public void test()
    {
        char[] ly=this.getName().toCharArray();
        for (char c : ly) {
            System.out.print(c + " ");
        }
    }
    public static void main(String[] args) {
        bvsource bv=new bvsource("pilipili");
        System.out.println(bv.getAdd());
        bv.setName("lyboos");
        System.out.println(bv.getName());
        System.out.println(bv.getClass());
        bv.test();
    }
}
//public class source {
//    private String name;
//    private String add;
//    public source(String add) {
//        this.add = add;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public String getAdd() {
//        return add;
//    }
//
//    public void setAdd(String add) {
//        this.add = add;
//    }
//
//    public static void main(String[] args) {
//        source ly=new source("bili");
//        ly.setName("lyboos");
//        System.out.println(ly.getClass());
//    }
//}
