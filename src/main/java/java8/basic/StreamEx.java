package java8.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) throws Exception{
        //TODO Stream
        //컬렉션(배열포함)의 반복자. 람다함수로 처리
        //내부반복자 사용
        // - 개발자는 처리코드에만 집중
        // - 병렬작업도와 CPU 효율 상승. 외부반복자보다 효율적이다.
        // - 병렬작업은 컬렉션내부에서 처리한다.
        List<Integer> vector = new Vector<>();
        vector.addAll(Arrays.asList(1,2,3,4,5));
        vector.stream().forEach( i -> System.out.println("stream : " + Thread.currentThread().getName()) );

        //병렬작업시. collection.stream() 대신 collection.parallelStream() 사용한다.
        vector.parallelStream().forEach( i -> System.out.println("stream : " + Thread.currentThread().getName()) );
        //작업스레드가 main 말고 ForkJoin 스레드가 같이 사용되는 것을 볼 수 있다.

        //TODO BaseStream
        //BaseStream : 직접 이용하지는 않고, 공통정의부분만 모아놓은 것.

        //아래는 모두 직접 이용한다.
        //Stream
        //IntStream : Stream을 상속받은 것은 아니다!!! 완전 다른 클래스이다.
        //LongStream
        //DoubleStream

        // 스트림을 얻는 Source
        // 1. 컬렉션에서

        // 2. 배열
        IntStream intStream = Arrays.stream(new int[]{1,2,3,4,5}); //Arrays.stream 이용
        Stream.of(Arrays.asList(1,2,3,4,5)); //Stream.of 이용
        IntStream.of(new int[]{1,2,3,4,5}); //XXXStream.of 이용

        // 3. 범위
        intStream = IntStream.range(1,10); // 마지막 미포함.
        intStream = IntStream.rangeClosed(1,10);// 포함

        // 4. 디렉토리
        Path path1 = Paths.get("src"); // Path는 IO에서 알아보자.
        Stream<Path> pathStream = Files.list(path1); // Files.list()로 스트림 얻기
        pathStream.forEach(System.out::println);

        //Files.find 사용. 자세한 사용법은 Docs 참고 등 하자..
        pathStream = Files.find(path1,3, (path, basicFileAttributes) -> basicFileAttributes.isDirectory(), FileVisitOption.FOLLOW_LINKS);
        pathStream.forEach(System.out::println);

        // 5. 파일
        Path txtPath = Paths.get(StreamEx.class.getResource("stream.txt").toURI());
        Stream<String> filelines = Files.lines(txtPath);
        filelines.forEach(System.out::println);

        //Reader 사용
        File file = txtPath.toFile();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        filelines = bufferedReader.lines();
        filelines.forEach(System.out::println);

        // 6. 랜덤 수
        Random random = new Random();
        intStream =  random.ints();

        //TODO Stream 파이프라이닝
        // 중간스트림은 생성되면서 바로 처리가 되는것이 아니고, 최종처리 시작할 때 까지 보류(lazy)된다
        // 최종처리가 시작하면 비로소 요소가 하나씩 처리되며 전달된다.
        // 최종처리결과는 OptionalInt 등 Optional 객체에 담겨서, 다양한 처리를 할 수 있다.

        //TODO 중간처리
        IntStream myStream = Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9,10});
        Stream<String> strStream = Stream.of("가","나","다","라","마");

        if (false){
            //필터
            myStream.distinct(); // 중복제거 Object.equals
            myStream.filter(v -> v <= 5); //필터

            //매핑
            myStream.map(v -> v * 2); //1대1 매핑. 타입 달라질 수 있다.
            myStream.flatMap(v -> IntStream.of(v, v * 2, v * 3)); //1대N 매핑. Stream으로 만들어 리턴해야 한다.

            strStream.flatMap(str -> Arrays.stream(str.split(","))); // split faltmap 예시.

            myStream.asLongStream(); //외에도, 스트림별로 아래같은 매핑메서드들이 있다.
            myStream.boxed();

            //정렬
            myStream.sorted(); //최종처리 순서를 변경할 수 있다.

            // Comparable 구현된 객체일 시
            strStream.sorted(Comparator.naturalOrder());
            strStream.sorted(Comparator.reverseOrder()); //반대정렬
            strStream.sorted((o1, o2) -> o2.compareTo(o1)); // 안되있을 경우 직접 Comparable을 제공할 수 있다.

            //루핑 : 요소 확인 등에 사용한다.
            myStream.peek(System.out::println); // forEach의 중간버전. 최종처리전엔 실행되지 않으므로 해당코드는 실행되지 않는다.

            //TODO 최종처리

            //매칭 : allMatch, any, none

            //집계 : sum 등등..
            // OptionalXXX 클래스를 리턴 -> 값 저장하는 값기반(value-based) 클래스.
            OptionalInt optionalInt = myStream.max();
            // 최종처리된 값의 여부에 따라 다양하게 처리할 수 있다.
            optionalInt.isPresent(); // 값이 존재하는지 확인
            optionalInt.orElse(3); // 값이 없으면 해당값으로 한다.
            optionalInt.ifPresent(System.out::println); // 값이 있으면 바로 처리한다.

            optionalInt = myStream.reduce(Math::max); //커스텀 함수로 집계도 가능하다

        }
        //루핑 : forEach

        //수집
        //collect(Supplier, XXXConsumer1, BiConsumer)
        //Supplier : 요소들을 담을 컨테이너 생성. 병렬처리에서는 여러번, 순차처리에서는 한번만 실행된다.
        //XXXConsumer : 컨테이너에 요소를 집어넣는 메소드. 아래에선 ObjInt형태로, List에 int를 집어넣었다.
        //BiConsumer : 컨테이너끼리 결합시키는 메서드. 순차처리에서는 호출되지 않는다.
        Vector<Integer> collection = myStream.collect(Vector<Integer>::new, List<Integer>::add, List<Integer>::addAll);

        //Collector<T,A,R> 타입으로 세가지를 묶어서 한번에 줄 수도 있다. (기본 Stream 클래스만 가능. IntStream은 안됨)
        //T-요소, A-Accumulator, R-저장될 컬렉션
        //Collector는 직접 생성하기보다 Collectors를 이용한다.
        Collector collector = Collectors.toList(); // 원래 제네릭인데 코드상 그냥 썼다...
        collector = Collectors.toSet();
        collector = Collectors.toCollection(Vector<Integer>::new); //커스텀 컬렉션
        collector = Collectors.toMap(t -> t.toString(), t -> t.hashCode()); // 요소 T를 key, value로 변환
        collector = Collectors.toConcurrentMap(t -> t.toString(), t -> t.hashCode());
        strStream.collect(Collectors.toList()); //그래서 이렇게 모을수도 있다. 위에건 IntStream이라서 안되었다.

        //그룹핑하여 수집 (Map 형태로 리턴. 범주가 key, 요소컬렉션이 value 형태이다.)
        if (false) {
            strStream.collect(Collectors.groupingBy(v -> v.compareTo("다") >= 0));
            strStream.collect(Collectors.groupingByConcurrent(v -> v.compareTo("다") >= 0)); //병렬처리

            //그룹핑 후 그룹별로 바로 매핑하거나 집계 (그룹별로 평균을 구해서 Map에 담는다던가..)
            strStream.collect(Collectors.groupingBy(
                    v -> v.compareTo("다") >= 0,
                    Collectors.averagingDouble(str->str.length()) //groupingBy의 두번째 인자로 downStream제공.
            ));
            //String은 delimiter로 연결하는 joining
            //숫자 세는 counting
            //합계 계산하는 summingInt 등의 메서드들이 Collectors에서 제공한다!!
            // 뭣하면 걍 매개변수보고 하나하나 만들던가...
        }

        //TODO 병렬처리
        // Concurrent(동시성) vs Parallelism(병렬성) : 동시성은 번갈아가며 하는것, 병렬성은 진짜 멀티코어에서 동시작업
        // 데이터 병렬성 : 한 작업을 코어수만큼 나눠 분리된 스레드에서 처리. 병렬스트림이 해당된다.
        // 작업 병렬성 : 서로 다른작업 수행 (웹 서버)
        // 작업관리자에서 CPU 코어별 성능이 잘 뽑아지고 있는지 확인할 수 있다!!!!

        //병렬스트림 : Fork-Join 프레임워크 사용. (ForkJoinPool 스레드풀 제공함.
        // Fork 단계 : 서브데이터 분리, 처리 (차례대로 나누는게 아닌, 분리알고리즘이 존재함.)
        // Join 단계 : 결과 결합 ( 서브데이터가 4개면 3번 발생. 4->2->1 과정에서 결합은 총 3번 발생하니까..)
        if (false){
            myStream.parallel(); //기존 스트림에서 변환하여 얻기
            new Vector<Integer>().parallelStream(); //스트림얻을떄 바로 얻기
        }
        //TODO 병렬처리 성능 : 항상 좋은것은 아니고, 상황따라 선택해야 한다!!
        //요소 개수 많고, 요소당 처리시간이 길면 좋음. (순차에 비해 오버헤드가 존재하므로)
        //스트림소스가 ArrayList, 배열일 경우 Fork가 쉽기 때문에 좋음
        //코어수가 많을수록 좋음.


    }
}
