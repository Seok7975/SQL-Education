import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;

class CollectStringStream {
    public static void main(String[] args) {
        String[] words = {"Hello", "Box", "Robot", "Toy"};
        Stream<String> ss = Arrays.stream(words);
        
        List<String> ls = ss.filter(s -> s.length() < 5)
                          .collect(
                              () -> new ArrayList<>(),
                              (c, s) -> c.add(s),
                              (lst1, lst2) -> lst1.addAll(lst2));
    
        System.out.println(ls);
    }
}

//[Box, Toy]

/*
collect
앞서 언급했듯이 한번 파이프라인에 흘려보낸 스트림은 
되돌리거나 다른 파이프라인에 다시 흘려보낼수 없다. 
때문에 필요하다면 파이프라인을 통해서 가공되고 걸러진 데이터를 최종 연산 과정에서 
별도로 저장해야 한다. 그리고 이때 다음 메소드를 호출하게 된다.

[Stream<T>의 메소드]
<R> R collect(Supplier<R> supplier,
			BiConsumer<R, ? suepr T> accumulator,
			BiConsumer<R, R> combiner)
			
[IntStream의 메소드]
<R> R collect(Supplier<R> supplier,
			ObjIntConsumer<R> accumulator,
			BiConsumer<R, R> combiner)
			
[LongStream의 메소드]
<R> R collect(Supplier<R> supplier,
			ObjLongConsumer<R> accumulator,
			BiConsumer<R, R> combiner)
			
[DoubleStream의 메소드]
<R> R collect(Supplier<R> supplier,
			ObjDoubleConsumer<R> accumulator,
			BiConsumer<R, R> combiner)
			
매개변수 선언을 보면 복잡해 보이지만 사용하기는 어렵지 않다. 그럼 예제를 통해서 collect 메소드의
사용 방법을 보이겠다. 다음은 문자열로 구성된 스트림에서 길이가 5미만인 문자열을 걸러내어 컬렉션 인스턴스에
저장하는 예이다.

위 예제에서는 다음 중간 연산을 통해서 길이가 5미만인 문자열만 걸러내어 스트림을 생성하였다.

ss.filter(s->s.length() < 5)

그리고 이어서 다음 최종 연산을 진행하였다.

.collect(()-> new ArrayList<>(),
		(c, s) -> c.add9s),
		(lst1, lst2) -> lst1,addAll(lst2));
		
위의 문장에서 첫 번째 매개변수로 전달된 람다식은 다음과 같다. collect 메소드는 이 람다식을
기반으로 데이터를 저장할 저장소를 생성한다.

() -> new ArrayList<>()

이어서 두 번째 매개변수로 전달된 다음 람다식을 관찰하자.

(c, s) -> c.add(s)

위의 람다식에서 c는 collect의 첫 번째 인자를 통해서 생성된 컬렉션 인스턴스이고, s는 스트림을
이루는 데이터들이다. 즉 이 문장을 통해서 컬렉션 인스턴스에 스트림의 데이터가 저장된다. 그리고 데이터의
저장이 끝나면 이 컬렉션 인스턴스의 참조 값이 반환되면서 collect 연산은 마무리된다. 그렇다면 세 번째
인자로 전달된 다음 람다식에는 어떤 의미가 있을까?

(lst1, lst2) -> lst1,addAll(lst2));		// 위 예제에서는 의미 없는 람다식

위 예제와 같이 병렬 스트림이 아닌 '순차 스트림(Sequential Stream)'의 경우 세 번째 인자는
사용되지 않는다. 그렇다고 해서 null을 전달하면 NullPointerException 예외가 발생하니 이어서
설명하는 병렬 스트림을 고려한 람다식을 작성해서 전달해야 한다.
*/