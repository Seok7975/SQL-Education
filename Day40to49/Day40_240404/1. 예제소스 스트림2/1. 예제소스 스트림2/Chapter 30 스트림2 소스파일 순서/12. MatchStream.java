import java.util.stream.IntStream;

class MatchStream {
    public static void main(String[] args) {
        boolean b = IntStream.of(1, 2, 3, 4, 5)
                          .allMatch(n -> n%2 == 0);	// 전부다, Boolean
        System.out.println("모두 짝수이다. " + b);

        b = IntStream.of(1, 2, 3, 4, 5)
                    .anyMatch(n -> n%2 == 0);	// 하나라도
        System.out.println("짝수가 하나는 있다. " + b);

        b = IntStream.of(1, 2, 3, 4, 5)
                    .noneMatch(n -> n%2 == 0); // 짝수가 모두 존재하지 않으면 True
        System.out.println("짝수가 하나도 없다. " + b);
    }
}

//모두 짝수이다. false
//짝수가 하나는 있다. true
//짝수가 하나도 없다. false

/*

forEach

void forEach(Consumer<? super T> action)		// Stream<T>의 메소드
void forEach(IntConsumer action)				// IntStream의 메소드
void forEach(LongConsumer action)				// LongStream의 메소드
void forEach(DoubleConsumer action)				// DoubleStream의 메소드

앞서 언급했듯이 forEach와 peek은 각각 최종 연산과 중간 연산이라는 부분에서만 차이가 있다. 즉
forEach는 최종 연산이기 때문에 반환형이 void이다. 반면 peek은 중간 연산이기 때문에 반환형이
void가 아니다. peek이 반환한 결과를 대상으로 최종 연산을 진행해야 하기 때문이다.

allMatch, anyMatch, noneMatch
중간 연산을 통해 생성된 스트림에 대해 다음과 같은 유형의 질문을 할 수 있다.

"스트림 안에 저장된 데이터가 모두 0보다 큰 수인가?"
"스트림 안에 저장된 데이터 중에서 0보다 큰 수가 하나라도 있는가?"
"스트림 안에 저장된 데이터는 모두 0보다 크지 않은가?"

그리고 이러한 유형의 질문을 위해 다음 메소드들이 존재한다.

[Stream<T>의 메소드들]
boolean allMatch(Predicate<? super T> predicate)
	-> 스트림의 데이터가 조건을 모두 만족하는가?
	
boolean anyMatch(Predicate<? super T> predicate)
	-> 스트림의 데이터가 조건을 하나라도 만족하는가?
	
boolean noneMatch(Predicate<? super T> predicate)
	-> 스트림의 데이터가 조건을 하나도 만족하지 않는가?
	
[IntStream의 메소드들]
boolean allMatch(IntPredicate predicate)
boolean anyMatch(IntPredicate predicate)
boolean noneMatch(IntPredicate predicate)

[DoubleStream의 메소드들]
boolean allMatch(DoublePredicate predicate)
boolean anyMatch(DoublePredicate predicate)
boolean noneMatch(DoublePredicate predicate)

그리고 위에서 보이지는 않았지만 LongStream에도 이에 해당하는 메소드들이 존재한다.

예제에서 등장한 allMatch 연산은 다음과 같다. 스트림의 모든 데이터가 전달된 람다식의 조건을 만족하는 경우
true를 반환한다.

.allMatch(n -> n%2 == 0)

이어서 등장한 anyMatch 연산은 다음과 같다. 스트림의 데이터 중 하나라도 전달된 람다식의 조건을 만족하는 경우
true를 반환한다.

.anyMatch(n -> n%2 == 0)

마지막으로 등장한 noneMatch 연산은 다음과 같다. 스트림의 데이터 모두 전달된 람다식의 조건을
만족하지 않는 경우 true를 반환한다.

.noneMatch(n -> n%2 == 0)
*/