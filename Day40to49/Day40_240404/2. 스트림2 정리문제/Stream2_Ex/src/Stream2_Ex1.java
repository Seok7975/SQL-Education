/*
1. 11, 22, 33, 44을 요소로 갖는 스트림을 생성하고 그 각요소를 출력하자.
"So Simple"이라는 요소로 갖는 스트림을 생성하고 그 각요소를 출력하자.
"Toy", "Robot", "Box"를 요소로 갖고 있는 리스트를 요소로 갖는 스트림을 생성하고
그 각요소를 출력하자.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class FactorOfStream
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        //List<Integer> list2 = Arrays.asList(11, 22 ,33 ,44);

        list.stream().forEach(n -> System.out.println(n + "\t"));
        System.out.println();

        Stream.of(11, 22, 33, 44)
                    .forEach(n -> System.out.println(n + "\t"));
        System.out.println();

        Stream.of("So Simple")
                .forEach(s -> System.out.println(s + "\t"));
        System.out.println();

        //List<String> sl = Arrays.asList("Toy", "Robot", "Box");
        //Stream.of(sl)
        Stream.of("Toy", "Robot", "Box")
                .forEach(x -> System.out.println(x + "\t"));
        System.out.println();
    }
}