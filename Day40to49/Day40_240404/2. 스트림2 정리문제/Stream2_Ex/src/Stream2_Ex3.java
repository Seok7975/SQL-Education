/*
3. 다음 문자열을 요소로 가지는 스트림을 생성해서,
가장 긴 문자열을 구해서 출력하자. 병렬스트림을 이용하자.
"Box", "Simple", "Complex", "Robot"
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

class Stream2_Ex3_ToParallelStream
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("Box", "simple",
                "Complex", "Robot");

        Stream<String> ss = list.stream();

        BinaryOperator<String> bs = (s1, s2)
        ->
        {
            if(s1.length() > s2.length())
            {
                return s1;
            }
            else
            {
                return s2;
            }
        };

        String str =ss.parallel().reduce("", bs);
        System.out.println(str);
    }
}
