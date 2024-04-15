import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;

class ReportCard {
    private int kor;    // 국어 점수
    private int eng;    // 영어 점수
    private int math;    // 수학 점수
    
    public ReportCard(int k, int e, int m) {
        kor = k;
        eng = e;
        math = m;    
    }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }
}

//Map : 내가 원하는 대로 가공할 때
//Filter : 

class GradeAverage {
    public static void main(String[] args) {
        ReportCard[] cards = {
            new ReportCard(70, 80, 90),
            new ReportCard(90, 80, 70),
            new ReportCard(80, 80, 80)
        };       

        Stream<ReportCard> sr = Arrays.stream(cards);

        IntStream si = sr.flatMapToInt(
               r -> IntStream.of(r.getKor(), r.getEng(), r.getMath()));

        double avg = si.average().getAsDouble();
        System.out.println("avg. " + avg);
     }
}

// avg. 80.0

/*

위 예제의 다음 문장을 보자.

IntStream si = sr.flatMapInt(
			r-> IntStream.of(r.getKor(), r.getEng(), r.getMath()));
			
위 문장의 람다식에서는 국어, 영어, 수학 점수로 이루어진 스트림을 생성해서 반환한다. 따라서 위의
flatMapToInt 연산을 통해서 생성된 스트림에는 모든 학생들의 국, 영, 수에 대한 점수가 담긴다.
그리고 이렇게 얻은 스트림을 대상으로 다음 문장을 통해 평균을 구하였다.

double avg = si.average().getAsDouble();

참고로 스트림의 종류에 따라서 호출할 수 있는 최종 연산의 종류가 나뉜다. IntStream형 참조변수로
참조하는 스트림을 대상으로는 다음 메소드를 호출할 수 있지만, Stream<T>형 참조변수로 참조하는
스트림을 대상으로는 다음 메소드를 호출할 수 없다.(

OptionalDouble average()
	-> 인터페이스 IntStream, LongStream, DoubleStream에 존재하는 메소드
	
그런데 위 메소드의 반환형이 OptionalDouble이다. 따라서 그 안에 저장된 값은 getAsDouble
메소드 호출을 통해 얻을 수 있다.

*/