import java.util.stream.IntStream;

class LazyOpStream {
    public static void main(String[] args) {
        // 최종 연산이 생략된 스트림의 파이프라인 -> 중간 연산만으로는 실행x
        IntStream.of(1, 3, 5)
            .peek(d -> System.out.print(d + "\t"));
        System.out.println();

  
        // 최종 연산이 존재하는 스트림의 파이프라인
        IntStream.of(5, 3, 1)
            .peek(d -> System.out.print(d + "\t"))
            .sum();            
        System.out.println();
    }
}

//
//5	3	1	

/*
루핑(Looping)
스트림을 이루는 모든 데이터 각각을 대상으로 특정 연산을 진행하는 행위를 가리켜 '루핑'이라 한다.
그리고 대표적인 루핑 연산으로 forEach가 있다. 그러나 이는 '최종 연산'이다. 반면 '중간 연산'에도
루핑을 위한 다음 메소드들이 존재한다.

Stream<T> peek(Consumer<? super T> action>		// Stream<T>의 메소드
IntStream peek(IntConsumer action)		// IntStream의 메소드
LongStream peek(LongConsumer action)	// LongStream의 메소드
DoubleStream peek(DoubleConsumer action)	// DoubleStream의 메소드

즉 위의 메소드들은 '최종 연산'이냐 '중간 연산'이냐 하는 부분에서만 forEach와 차이가 있다. 그럼
위의 예제를 통해서 스트림의 '지연(Lazy) 처리'를 확인해 보자.

다음 스트림의 파이프라인에는(연산들에는) 최종 연산이 존재하지 않는다. 따라서 중간 연산은 진행되지 않는다.

IntStream.of(1, 3, 5)
		.peek(d->System.out.print(d + "\t"));
		
반면 다음 파이프라인에는 최종 연산이 존재한다. 이 최종 연산 sum은 스트림에 저장된 값을 모두 더하여 그
결과를 반환한다.

IntStream.of(5, 3, 1)
	.peek(d -> Systetm.out.print(d + "\t"))
	.sum();
	
그런데 위의 문장에서 sum이 반환하는 값을 저장하거나 출력하지 않는다. 따라서 sum은 프로그램의
실행 결과에 아무런 영향을 주지 않는다. 그럼에도 불구하고 이 연산으로 인해 파이프라인에 데이터가
흐른다. 따라서 중간 연산이 실행된다.

*/