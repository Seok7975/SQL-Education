/*
2. 다음을 IntStream을 이용하여 코딩하시오.
7, 5, 3을 인자로 전달해서 -> 메서드 or 클래스를 따로 만들라는 말이네?
스트림으로,
숫자 5 부터 8 이전까지 스트림으로
숫자 5 부터 8 까지 스트림으로
그리고 각각의 스트림의 요소를 출력하시오.
 */


import java.util.stream.IntStream;


class Stream2_Ex2_CreateIntStream
{
    public static void main(String[] args)
    {
        // 인자로 전달하는 값을 스트림으로
        IntStream is = IntStream.of(7, 5, 3);
        showIntStream(is);

        // 숫자 5 부터 8 이전까지 스트림으로
        IntStream is2 = IntStream.range(5, 8);
        showIntStream(is2);

        // 숫자 5 부터 8 까지 스트림으로
        IntStream is3 = IntStream.rangeClosed(5, 8);
        showIntStream(is3);
    }


    public static void showIntStream(IntStream is)
    {
        is.forEach(n -> System.out.println(n + "\t"));
        System.out.println();
    }

}
