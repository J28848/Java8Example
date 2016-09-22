import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by J28848 on 9/22/16.
 */
public class Java8String {
    public static void main(String[] args) {
        String[] artists = new String[]{"A","B","C","D"};
        //Traditional String handling
        StringBuilder builder=new StringBuilder("[");
        for (String name :artists)
        {
            if (builder.length()>1)
                builder.append(", ");
            builder.append(name);
        }
        builder.append("]");
        System.out.println(builder.toString());

        // handle string with collecotr.
        String res = Arrays.stream(artists).collect(Collectors.joining(", ","[","]"));

        System.out.println(res);

        //groupby

        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);


    }

}
