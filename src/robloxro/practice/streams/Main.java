package robloxro.practice.streams;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        System.out.println("*************** CREATE STREAMS *******************");
        System.out.println("There are three ways to create streams");
        System.out.println("Method 1 - .stream method on Arrays or collections");
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(arr);
        System.out.println("Method 2- Stream.of on Arrays or collections");
        Stream<String> stream2 = Stream.of("1", "2", "2","1");
        System.out.println("Method 3- .stream() method on collections");
        List<String> myListList = new ArrayList<>();
        myListList.add("one");
        myListList.add("two");
        myListList.add("three");
        Stream<String> stream3=myListList.stream();
        System.out.println("****************** OPERATIONS ON STREAMS *********************");
        System.out.println("****************** count distinct items  *********************");
        long streamDistinct=stream1.distinct().count();
        System.out.println("there are "+streamDistinct+ " distict items in stream1");
        streamDistinct=stream2.distinct().count();
        System.out.println("there are "+streamDistinct+ " distict items in stream2");
        System.out.println("****************** iterating *********************");
        boolean isExist = stream3.anyMatch(element -> element.contains("a"));
        System.out.println(isExist?"Character a is in stream 3":" Character a is not in stream 3");
        System.out.println("****************** filtering *********************");
         myListList = new ArrayList<>();
        myListList.add("ana");
        myListList.add("are ana mere ha ha ha");
        myListList.add("mere");
        Stream newFilteredStream=myListList.stream().filter(element1 -> element1.contains("ana"));
        List x = (List) newFilteredStream.collect(Collectors.toList());
        System.out.println(" Ana can be found in this list  "+x.toString());
        System.out.println("****************** convert using map *********************");
        List<String> uris = new ArrayList<>();
        uris.add("C:\\My.txt");
        uris.add("D:\\MyText.txt");
        Stream<Path> stream = uris.stream().map(uri -> Paths.get(uri));
        System.out.println(stream.collect(Collectors.toList()).toString());
        System.out.println("****************** matching using anyMatch, allMatch,noneMatch *********************");
        myListList = new ArrayList<>();
        myListList.add("ana");
        myListList.add("are ana mere ha ha ha");
        myListList.add("mere");
        boolean isValid = myListList.stream().anyMatch(element -> element.contains("a")); //
        boolean isValidOne = myListList.stream().allMatch(element -> element.contains("mere")); //
        boolean isValidTwo = myListList.stream().noneMatch(element -> element.contains("bere")); //
        System.out.println(isValid + " " +isValidOne +" "+isValidTwo);
        System.out.println("****************** reducing *********************");
        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
        System.out.println("reduced 1 ="+reduced);
        reduced = integers.stream().reduce(23, (a, b) -> a - b);
        System.out.println("reduced 2 ="+reduced);
        int[] array = {23,43,56,97,32};
        //Set start value. Result will be start value + sum of array.
        int startValue = 100;
        int sum = Arrays.stream(array).reduce(startValue, (x1, y) -> x1+y);
        System.out.println(sum);
        sum = Arrays.stream(array).reduce(startValue, Integer::sum);
        System.out.println(sum);
        sum = Arrays.stream(array).reduce(startValue, ReducedCustomFunction::addIntData);
        System.out.println(sum);


    }
}

