
#Java 8 - Overview

**New Features**

* Lambda expression
* Method references
* Default method
* _New tools_
* Stream API
* Date Time API
* Optional Class
* Nashorn, JavaScript Engine

**Java 7**

```
 Collections.sort(names, new Comparator<String>() {
     @Override
     public int compare(String s1, String s2) {
        return s1.compareTo(s2);
     }
 });
```

**Java 8**

```
Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
```

#Java 8 - Lambda Expressions

*Syntax*
```
parameter -> expression body
```

* Optional type declaration - No need declare the type of a parameter
* Optional parenthesis around parameter - `()` only for single parameter
* Optional curly braces - `{}` only for single statement
* Optional return keyword - `return` single expression to return value, `{}` are required to indicate that expression return a value.

**Important Points**

1. define inline implementation of a functional interface.
2.  powerful functional programming, eliminate anonymous class.


#Java 8 - Method References

* Static methods
* Instance methods
* Constructors using new operator (TreeSet::new)

```
    List names = new ArrayList();
    //static method reference
    names.forEach(System.out::println);
```

#Java 8 - Functional Interfaces

>Functional interfaces have a single functionality to exhibit. Java 8 has defined a lot of functional interfaces to be used extensively in lambda expressions. 

eg.
Predicate <T> interface is a functional interface with a method test(Object) to return a Boolean value. This interface signifies that an object is tested to be true or false.

```
   eval(list, n-> n%2 == 0);

   public static void eval(List<Integer> list, Predicate<Integer> predicate) {
      for(Integer n: list) {
		
         if(predicate.test(n)) {
            System.out.println(n + " ");
         }
      }
   }
```
Here we've passed Predicate interface, which takes a single input and returns Boolean.


#Java 8 - Default Methods

A new concept of `default` method implementation in interfaces.

*Syntax*
```
public interface vehicle {
   default void print(){
      System.out.println("I am a vehicle!");
   }
}
```

*Multiple Defaults*

* create an own method that overrides
* call the default method of the specified interface using `super`

*Static Default Methods*

```
public interface Vehicle {
   static void blowHorn(){
      System.out.println("Blowing horn!!!");
   }
}

//can be called by 
Vehicle.blowHorn();
```

#Java 8 - Streams

>Using stream, you can process data in a declarative way similar to SQL statements.

* NO need loops and make repeated checks
* efficiency - multi-core processors and parallel code processing was inbuilt.

**What is Stream?**

* Sequence of elements
* Source
* Aggregate operations
* Pipelining
* Automatic iterations

**Generating Streams**

two methods go generate a Stream:
1. stream() - sequential stream
2. parallelStream() - parallel

Collections method.

* forEach 
* map - map each element to its corresponding result. 
* filter - used to eliminate elements based on a criteria
* limit - reduce the size of the stream
* sorted - sort the stream
* Parallel Processing - 
* Collectors - used to combine the result of processing on the elements of a stream.
* Statistics -  calculate all statistics when stream processing is being done.

```
List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
int count = strings.stream().filter(string -> string.isEmpty()).count();
random.ints().limit(10).forEach(System.out::println);
random.ints().limit(10).sorted().forEach(System.out::println);
List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
```

#Java 8 - Optional Class
>
Optional is a container object which is used to contain not-null objects. Optional object is used to represent null with absent value.
This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.

**Note** − This class inherits methods from the `java.lang.Object` class.
```
Integer value1 = null;
Optional<Integer> a = Optional.ofNullable(value1);
```

*method*

* static <T> Optional<T> empty()
* boolean isPresent()
* T orElse(T other)





#Java 8 - Nashorn JavaScript

>
1. Java 7 Javascript scripting engine based on Mozilla Rhino.
2. Java 8 ship a new engine called Oracle Nashorn based on [JSR292](https://jcp.org/en/jsr/detail?id=292)
3. Nashorn uses invokedynamics feature, provides 2 to 10 times better performance than Rhino, as it directly compiles the code in memory and passes the bytecode to JVM.
4. jjs - java8 command line tool, execute javascript code at console.

*demo*

```
> jjs sample.js
> Hello World!

```

>>
While Oracle Nashorn runs ECMA-compliant JavaScript, it is important to note that objects normally accessible in a web browser are not available, for example, `console`, `window`, and so on.


jjs in Interactive Mode

```
jjs
> print("Hello word!")
Hello World!

```

Pass Arguments

```
$jjs -- a b c
jjs> print('letters: ' +arguments.join(", "))
letters: a, b, c
jjs>

```

## Calling Javascript from Java

```
javac Java8NashornJavaScript.java & java Java8NashornJavaScript
```

_can calling javascript file from JAVA? homework_

## Calling JAVA from Javascript

```
jjs calljavasample.js
```

see [Oracle Nashorn: A Next-Generation JavaScript Engine for the JVM](http://www.oracle.com/technetwork/articles/java/jf14-nashorn-2126515.html)


#Java 8 - New Date/Time API

*drawbacks old date-time API*

* not Thread safe
* poor design - Default date starts from 1900, month from 1, days from 0
* difficult time zone handling
 
## new date-time API under package `java.time.`

* Local - Simplified for timezone handling
* Zoned - Specialized API to deal with various timezones.

####Example

* Local Data-Time API - timezones are not required
* Zoned Date-Time API
* Chrono Units Enum - Replace day, month, etc. `ChronoUnit.MONTHS`
* Period & Duration - for `Date` and `Time`
* Temporal Adjusters - perform the date mathematics. eg. "Second Saturday of the Moth"
* Backward Compatibility - `toInstant()` and `ofInstant(Insant, ZoneId)`

#Java 8 - Base64

Java 8 now have inbuilt encoder and decoder for Base64 encoding. 

*3 types:*

* Simple - `A-Za-z0-9+/.`
* URL - `A-Za-z0-9+_.`
* MIME - no more than 76 characters each line

*2 Nested Classes*

* static class Base64.Decoder
* static class Base64.Encoder


#Reference

* [Java8 Tutorial](http://www.tutorialspoint.com/java8/)