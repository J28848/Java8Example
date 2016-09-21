import java.util.ArrayList;
import java.util.List;

/**
 * Created by J28848 on 9/8/16.
 */
public class Java8MethodReference {
    public static void main(String args[]){
        List names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println);
    }
}
