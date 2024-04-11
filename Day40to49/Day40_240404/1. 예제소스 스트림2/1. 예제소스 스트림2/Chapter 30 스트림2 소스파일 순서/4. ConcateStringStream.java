import java.util.stream.Stream;

class ConcateStringStream {
    public static void main(String[] args) {
        Stream<String> ss1 = Stream.of("Cake", "Milk");
        Stream<String> ss2 = Stream.of("Lemon", "Jelly");
        
        // 스트림을 하나로 묶은 후 출력
        Stream.concat(ss1, ss2).forEach(s -> System.out.println(s));
     }
}

//Cake
//Milk
//Lemon
//Jelly

/*

스트림의 연결
두 개의 스트림을 연결하여 하나의 스트림을 생성할 수도 있는데, 이를 위해 호출하는 메소드는 다음과
같다.(편의상 화살표가 가리키는 수준으로 기억하고 있어도 괜찮다.)

static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
	-> static <T> Stream<T> concat(Stream<T> a, Stream<T> b)
	
//<? extends T> 
// 두개의 메서드를 연결하는데 값이 변경되면 안되므로 꺼내는 것만 가능하게 하기 위해
// extends를 넣음

위의 메소드는 Stream<T>에 정의된 메소드인데, DoubleStream, IntStream, LongStream에도 이에
해당하는 메소드들이 각각 다음과 같이 정의되어 있다.

static DoubleStream concat(DoubleStream a, DoubleStream b)
static IntStream concat(IntStream a, IntStream b)
static LongStream concat(LongStream a, LongStream b)

*/