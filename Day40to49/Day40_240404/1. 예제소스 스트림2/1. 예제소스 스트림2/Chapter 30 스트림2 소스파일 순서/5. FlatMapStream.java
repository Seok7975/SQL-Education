import java.util.Arrays;
import java.util.stream.Stream;

class FlatMapStream {
    public static void main(String[] args) {
        Stream<String> ss1 = Stream.of("MY_AGE", "YOUR_LIFE");

        Stream<String> ss2 = ss1.flatMap(s -> Arrays.stream(s.split("_"))); 
        // stream 생성 {"MY", "AGE", "YOUR", "LIFE"}
        ss2.forEach(s -> System.out.print(s + "\t"));

        System.out.println();
     }
}

//MY	AGE	YOUR	LIFE	

/*

스트림의 중간 연산
* 맵핑(Mapping)에 대한 추가 정리
[Stream<T>의 map 시리즈 메소드들]
<R> Stream<R> map(Function<T, R> mapper)
IntStream mapToInt(ToIntFunction<T> mapper)
LongStream mapToLong(ToLongFunction<T> mapper)
DoubleStream mapToDouble(ToDoubleFunction<T> mapper)

그러나 맵핑 관련 메소드의 종류는 더 다양하다. 다음과 같이 Stream<T>에 위치한 flatMap 시리즈의
메소드들도 있다.(편의상 화살표가 가리키는 수준으로 기억하고 있어도 괜찮다.)

[Stream<T>의 flatMap 시리즈 메소드들]
<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
	-> <R> Stream<R> flatMap(Function<T, Stream<R>> mapper)
	
IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper)
	-> IntStream flatMapToInt(Function<T, IntStream> mapper)
	
LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper)
	-> LongStream flatMapToLong(Function<T, LongStream> mapper)
	
DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper)
	-> DoubleStream flatMapToDouble(Function<T, DoubleStream> mapper)
	
map 시리즈 메소드와 flatMap 시리즈 메소드의 차이점은 매개변수 선언을 보면 알 수 있다. 다음 매개변수 선언에서,

<R> Stream <R> flatMap(Function<T, Stream<R>> mapper)

Function<T, R>의 추상 메소드는 R apply(T t)이므로, 위 메소드 호출 시 전달해야 할 람다식이 구현해야 할
메소드는 다음과 같다.

Stream<R> apply(T t)

즉 flatMap에 전달할 람다식에서는 '스트림을 생성하고 이를 반환'해야 한다. 반면 map에 전달할 람다식에서는
스트림을 구성할 데이터만 반환하면 된다.

위 예제에서 호출한 String 클래스의 다음 메소드는 인자로 전달된 '기준'을 근거로 문자열을 나누고, 나뉜 문자열을
배열에 담아서 반환한다.

public String[] split(String regex)
	-> 인자로 전달된 구분자 정보를 기준으로 문자열 나누고, 이를 배열에 담아서 반환
	
따라서 예제에서는 문자열 'MY_AGE'와 'YOUR_LIFE'에 대해 각각 다음 람다식이 실행되고, 이때
생성된 두 개의 스트림을 하나로 묶은 스트림이 flatMap의 연산 결과로 반환이 된다.

s->Arrays.stream(s.split("_"))

이전에 보인 map은 일대 일로 매핑을 진행하였다. 그러나 위 예제에서 보이듯이 flatMap은 일대 다의 매핑을
진행한다.(두 개의 긴 문자열을 대상으로 매핑을 진행해서 네 개의 작은 문자열이 되게 하였다.)
*/