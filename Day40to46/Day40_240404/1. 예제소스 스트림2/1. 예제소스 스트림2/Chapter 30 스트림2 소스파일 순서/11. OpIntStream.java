import java.util.stream.IntStream;

class OpIntStream {
    public static void main(String[] args) {
        // 합
        int sum = IntStream.of(1, 3, 5, 7, 9)
                          .sum();
        System.out.println("sum = " + sum);

        // 개수
        long cnt = IntStream.of(1, 3, 5, 7, 9)
                          .count();
        System.out.println("count = " + cnt);

        // 평균
        IntStream.of(1, 3, 5, 7, 9)
                .average()
                .ifPresent(av -> System.out.println("avg = " + av));

        // 최소
        IntStream.of(1, 3, 5, 7, 9)
                .min()
                .ifPresent(mn -> System.out.println("min = " + mn));

        // 최대
        IntStream.of(1, 3, 5, 7, 9)
                .max()
                .ifPresent(mx -> System.out.println("max = " + mx));
 
    }
}

//sum = 25
//count = 5
//avg = 5.0
//min = 1
//max = 9

/*

sum(), count(), average(), min(), max()
최종 연산에는 sum, count, average, min, max가 존재한다. 그런데 메소드의 이름이 의미하듯이
이는 수에 의미 있는 연산이다. 따라서 IntStream, LongStream, DoubleStream형 참조변수가
참조하는 스트림을 대상으로만 이 연산들이 가능하다.

[IntStream의 메소드들]
int sum()
long count()
OptionalDouble average()
OptionalInt min()
OptionalInt max()

[DoubleStream의 메소드들]
double sum()
long count()
OptionalDouble average()
OptionalDouble min()
OptionalDouble max()

LongStream에도 동일한 이름의 메소드들이 존재한다.

위 예제를 보면서 다음과 같은 스타일로 예제를 작성하면 어떨까 하는 생각을 해볼 수 있다. 
하나의 스트림을 생성해서 이를 기반으로 합도 계산하고 개수도 하는 등 
필요한 모든 것을 계산하는 것이다.

public static void main(STring[] args){
	IntStream is = IntStream.of(1, 3 ,5, 7, 9);
	System.out.println("sum = " + is.sum());
	System.out.println("count = " + is.count());
	...
}

그러나 스트림은 최종 연산을 하는 순간 '파이프라인'의 마지막을 통과해버린다. 
따라서 이미 흘러가버린 스트림을 대상으로는 그 어떤 연산도 추가로 진행할 수 없다. 
(그러므로 각각 스트림을 생성해야함)
때문에 위 예제에서 보이듯이 얻고자 하는 것이 있다면 그때마다 매번 스트림을 생성해야 한다. 
그리고 이러한 스트림의 특성 때문에 실제 코드에서
Stream<T>형 참조변수나 IntStream형 참조변수를 선언할 일이 거의 없다.

*/