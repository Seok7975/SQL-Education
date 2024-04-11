import java.util.stream.Stream;

class InstSortedStream {
    public static void main(String[] args) {
        Stream.of("Box", "Apple", "Robot")
            .sorted()				//Compareable 이 구현 되어 있어야함
            .forEach(s -> System.out.print(s + '\t'));
        System.out.println();
        
        Stream.of("Box", "Apple", "Rabbit")
            .sorted((s1, s2) -> s1.length() - s2.length())
            .forEach(s -> System.out.print(s + '\t'));
        System.out.println();
    }
}

//Apple	Box	Robot	
//Box	Apple	Rabbit	

/*
정렬
정렬 기능을 제공하는 중간 연산 메소드들은 다음과 같다.

Stream<T> sorted(Comparator<? super T> comparator)		// Stream<T>의 메소드
Stream<T> sorted()	// Stream<T>의 메소드
IntStream sorted()	// IntStream의 메소드
LongStream sorted()	// DoubleStream의 메소드

다음 메소드를 통한 정렬을 위해서는 스트림을 구성하는 인스턴스가 
Comparable<T> 인터페이스를 구현하고 있어야 한다.

Stream<T> sorted()

Stream<T> sorted(Comparator<? super T> comparator)
위의 메소드를 호출할 때는 Comparator<T>의 compare 메소드 구현에 해당하는 람다식을 전달해야 한다.
*/