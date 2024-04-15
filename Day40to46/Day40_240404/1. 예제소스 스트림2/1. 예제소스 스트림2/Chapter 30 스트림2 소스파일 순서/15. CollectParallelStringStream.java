import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;

class CollectParallelStringStream {
    public static void main(String[] args) {
        String[] words = {"Hello", "Box", "Robot", "Toy"};
        Stream<String> ss = Arrays.stream(words);
        
        List<String> ls = ss.parallel()
                          .filter(s -> s.length() < 5)                          
                          .collect(
                              () -> new ArrayList<>(),
                              (c, s) -> c.add(s),
                              (lst1, lst2) -> lst1.addAll(lst2));
    
        System.out.println(ls);
    }
}
//[Box, Toy]

/*
	병렬 스트림에서의 collect

앞서 예제에서 보인 collect 메소드의 호출문은 다음과 같다.

.collect(()-> new ArrayList<>(),
		(c, s) -> c.add(s),
		(lst1, lst2) -> lst1,addAll(lst2));

만약에 병렬 스트림을 대상으로 위의 메소드가 호출이 되면, 첫 번째 인자로 전달된 람다식을 기반으로 
다수의 저장소가 생성되어, 두 번째 람다식을 기반으로 이 다수의 저장소에 데이터가 나뉘어 저장된다.
따라서 저장이 끝난 다음에는 이 저장소에 담긴 데이터들을 하나로 묶는 과정을 거쳐야 하는데 이 때
사용되는 것이 세 번째 전달인자인 다음 람다식이다.

(lst1, lst2) -> lst1.addAll(lst2));

위의 addAll 메소드는 첫 번째 람다식에서 생성한 컬렉션 인스턴스의 메소드로써, 메소드의 호출 결과로
lst2가 저장하고 있는 모든 데이터가 lst1에 담기게 된다.

참고로 병렬 처리가 능사는 아니다. 병렬 처리를 했을 때 오히려 속도가 느려지는 경우도 의외로 많다.
처리해야 할 일에 비해 병렬 처리를 위한 전후 과정이 더 소모적인 경우에는 병렬 처리가 방해가 되기
때문이다. 따라서 병렬 처리를 결정했을 때는 테스트를 통해서 병렬 처리의 적합성을 판단해야 한다.
*/