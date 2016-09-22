import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by J28848 on 9/22/16.
 */
public class Java8Collector {
    public static void main(String[] args) {
//        new Test().overloaded1(1);
        List<String> list = Arrays.asList(new String[]{"1","2","3","4","5","1"});
        System.out.println(list);
        TreeSet set = list.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);
        List<Integer> together= Stream.of(Arrays.asList(1,2),Arrays.asList(3,4)).flatMap(numbers->numbers.stream()).collect(Collectors.toList());
        System.out.println(together);
    }

    static class Test{
        public void overloaded1(String param){
            System.out.println("this param is String");
        }
        public void overloaded1(Integer param){
            System.out.println("this param is Integer");
        }
    }
}
