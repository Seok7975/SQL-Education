import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

class StreamOfStream {
    public static void main(String[] args) {
        // ex 1
        Stream.of(11, 22, 33, 44)
            .forEach(n -> System.out.print(n + "\t"));
        System.out.println();

        // ex 2
        Stream.of("So Simple")
            .forEach(s -> System.out.print(s + "\t"));
        System.out.println();

        // ex 3
        List<String> sl = Arrays.asList("Toy", "Robot", "Box");
        Stream.of(sl)
            .forEach(w -> System.out.print(w + "\t"));
        System.out.println();       
    }
}

//11	22	33	44	
//So Simple	
//[Toy, Robot, Box]

/*

스트림의 생성: 스트림 생성에 필요한 데이터를 직접 전달
스트림의 생성과 관련하여 Stream<T> 인터페이스에 정의되어 있는 static 메소드가 둘이 있다.

static <T> Stream<T> of(T t)
static <T> Stream<T> of(T...values)

이 두 메소드에는 스트림 생성에 필요한 데이터를 인자로 직접 전달할 수 있다. 
위 예제에서는 다음 메소드 호출을 통해서 네 개의 정수로 이루어진 스트림을 생성하였다. 물론 스트림의
생성 과정에서 Integer형으로 오토 박싱이 진행된다.

Stream.of(11, 22, 33, 44)

그리고 다음 메소드 호출을 통해서 하나의 문자열 "So Simple"로 이루어진 스트림도 생성하였다.

Stream.of("So Simple")

그렇다면 다음 메소드 호출을 통해서 만들어진 스트림은 어떠한 데이터로 이뤄져 있겠는가?

List<String> s1 = Arrays.asList("Toy", "Robot", "Box");
Stream.of(s1)		// 어떤 데이터로 이뤄진 스트림이 생성되는가?
이 경우 세 개의 문자열로 이뤄진 스트림이 생성되는 것으로 오해할 수 있다. 그러나 위 문장을 통해서
생성된 스트림에는 하나의 인스턴스만 존재한다. 그리고 그 인스턴스는 참조변수 s1이 참조하는 컬렉션
인스턴스이다.
이렇듯 컬렉션 인스턴스도 그 자체로 스트림을 이루는 데이터가 되게 할 수 있다. 이는 언뜻 불필요할 것
같지만 복잡한 데이터를 관리하고 처리할 경우 유용하게 사용되기도 한다.

[참고] Stream.of 메소드에 배열을 전달하는 경우
Stream.of 메소드에 컬렉션 인스턴스를 전달하면 해당 인스턴스 하나로 이뤄진 스트림이 생성됨을 예제를
통해 보였다. 그런데 Stream.of 메소드에 배열을 전달하면 그때는 하나의 배열로 이뤄진 스트림이
생성되는 것이 아니라, 배열에 저장된 요소로 이뤄진 스트림이 생성된다.

*/