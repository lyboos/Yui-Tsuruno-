import java.util.*;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
//        arrList<String> list=new arrList<>();
//        list.add("a",0);
//        list.add("b",0);
//        list.add("bz",0);
        List<String> list=new ArrayList<>();
        list.add("a,7,");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c,99,6,");
//迭代器处理
//        Iterator<String> iterator=list.iterator();
//        while (iterator.hasNext()){
//            if(iterator.next().equals("b")) iterator.remove();
//        }
//    }

//stream流处理
        list=list.
                stream().
                filter(e ->!e.equals("b")).
                distinct().
                map(e->e+55).
                flatMap(e->Arrays.stream(e.split(","))).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());

        System.out.println(list);

         String str="lyboos";
        Optional<String> optionalS=Optional.ofNullable(str);
        optionalS.ifPresent(System.out::println);
    }
}

