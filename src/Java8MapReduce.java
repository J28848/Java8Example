import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by J28848 on 9/22/16.
 */
public class Java8MapReduce {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person[]{
                new Person(20),new Person(30),new Person(40),new Person(50),new Person(60)

        });
        Integer totalAges = persons.stream().map(Person::getAge).reduce( 0, (a,b)-> a+b );
        System.out.printf("\ntotal Ages... %d\n",totalAges);

        System.out.printf("\nauto print person age... \n");

        persons.stream().map(Person::getAge).reduce((a,b)->a>b ? a : b).ifPresent(System.out::println);

        System.out.printf("\nauto print person Object... \n");

        persons.stream().reduce((p1,p2) -> p1.age > p2.age ? p1 : p2).ifPresent(System.out::println);
    }
    static class Person{
        private int age;
        Person(int age){this.age = age;}
        Integer getAge(){
            return age;
        }
    }
}
