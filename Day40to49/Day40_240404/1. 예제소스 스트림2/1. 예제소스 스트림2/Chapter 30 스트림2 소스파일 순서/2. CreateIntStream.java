import java.util.stream.IntStream;

class CreateIntStream {
    public static void showIntStream(IntStream is) {
        is.forEach(n -> System.out.print(n + "\t"));
        System.out.println();
    }

    public static void main(String[] args) {
        // 인자로 전달하는 값을 스트림으로
        IntStream is3 = IntStream.of(7, 5, 3); 
        showIntStream(is3);

        // 숫자 5 부터 8 이전까지 스트림으로
        IntStream is4 = IntStream.range(5, 8);  // 5<=   <8
        showIntStream(is4);

        // 숫자 5 부터 8 까지 스트림으로
        IntStream is5 = IntStream.rangeClosed(5, 8);  // 5<=   <=8
        showIntStream(is5);
     }
}

//7	5	3	
//5	6	7	
//5	6	7	8

/*

DoubleStream, IntStream, LongStream
인터페이스 Stream<T>의 타입 매개변수 T에 int와 같은 기본 자료형의 이름이 올 수 없으므로 다음
인터페이스들이 정의되어 있다.

DoubleStream, IntStream, LongStream

그리고 앞서 소개한 of 메소드가 위의 인터페이스에 다음과 같이 정의되어 있다.

static DoubleStream of(double...values)		// DoubleStream의 메소드
static DoubleStream of(double t)			// DoubleStream의 메소드

static IntStream of(int...values)			// IntStream의 메소드
static IntStream of(int t)					// IntStream의 메소드

static LongStream of(long...values)			// LongStream의 메소드
static LongStream of(long t)				// LongStream의 메소드

따라서 위의 메소드를 통해서 기본 자료형 데이터로 이뤄진 스트림을 생성하면, 불필요한 오토 박싱과
오토 언박싱을 피할 수 있다. 그리고 다음 메소드들을 통해서 범위 내에 있는 값들로 스트림을 구성할
수도 있다.

static IntStream range(int startInclusive, int endExclusive)	// IntStream의 메소드
static IntStream rangeClosed(int startInclusive, int endInclusive)	// IntStream의 메소드

static LongStream range(Long startInclusive, Long endExclusive)	// LongStream의 메소드
static LongStream rangeClosed(Long startInclusive, Long endInclusive)	// LongStream의 메소드

위 유형의 메소드가 double형에 대해서는 존재하지 않는데, 이유는 두 실수 사이에 존재하는 값의 수는 셀 수 없기 때문이다.

*/