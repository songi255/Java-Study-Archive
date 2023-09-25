package java8.basic;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CollectionsEx {
    public static void main(String[] args) throws Exception{
        //TODO 상속구조
        // - Collection - List, Set (둘은 비슷하기 떄문이다.)
        // - Map - Collection과는 다른 라이브러리이다.

        //TODO List
        //인덱스로 관리된다.
        //중복저장가능하다.

        //구현클래스
        //ArrayList
        //기본적으로 배열을 구현해 놓은 것이기 때문에, 끝에서만 삽입/삭제가 일어나거나, 인덱스 검색을 할 시 매우 좋다!
        Integer[] intArr = {1,2,3,4};
        List<Integer> list = Arrays.asList(intArr); // Arrays.asList로 일괄변환할 수 있다. 다만 자동박싱에는 한계가 있는듯.

        //LinkedList
        //여러 위치(인덱스) 에서 수정이 잦을 경우 성능이 매우 좋다.
        list = new LinkedList<>();

        //Vector
        list = new Vector<>(); //Array리스트와 내부구조가 동일하다. 유일한 차이는 스레드동기화가 되어있다.

        //TODO Set
        //인덱스로 관리하지 않는다.

        //HashSet
        Set<Integer> set = new HashSet<>(); //hashcode 비교 후 equals 하는 set이다.

        //TreeSet
        //이진트리구조로, 검색을 강화한 set이다. 원소는 comparable 인터페이스를 구현해야 한다.(미구현시 생성자에서 제공가능)
        TreeSet<Integer> treeSet = new TreeSet<>(); //전용메서드가 있으니 TreeSet으로 선언해야 한다!
        treeSet.floor(3); //floor는 검색메서드이다. 동등객체를 검색하고, 없으면 바로 위 원소를 반환한다.
        treeSet.ceiling(3); // 동등 없으면 바로 아래 원소.

        //정렬기능
        treeSet.descendingIterator(); //내림차순 정렬된 이터레이터 반환
        treeSet.descendingSet().descendingSet(); //내림차순 정렬된 NavigableSet 반환. 한번더 호출로 오름차순으로 바꾸었다.

        //범위 그룹핑도 쉬워진다.
        treeSet.headSet(3,true); //3이상의, 3포함해서, 부분집합을 반환한다. 반대는 tail
        treeSet.subSet(3,true, 10, false); // 3이상 10미만.

        //TODO Map
        //Key는 중복될 수 없다(중복시 덧써짐). Key로는 String을 많이 사용한다.

        //HashMap
        Map<String, Integer> map = new HashMap<>();

        //HashTable : HashMap과 동일. 스레드동기화 되어있다.

        //TreeMap : 검색에 특화된 맵. Key를 기준으로한 이진트리로 구성되어있다.
        // 전용 메서드가 있으니 Map이 아니라 TreeMap으로 선언해야 한다!
        //마찬가지, 원소는 Comparable 구현. 구현하지 않았다면 생성자에서 제공해줄 수도 있다!!
        TreeMap<String, Integer> treeMap = new TreeMap<>((o1, o2) -> o1.length()-o2.length());


        //TODO Properties
        //Key와 Value가 모두 String 타입인 Map.
        // 어플리케이션의 옵션, DB연결정보, 국제화(다국어)정보 저장 등에 사용한다.
        // .properties 파일에 저장하고 사용한다.
        // key=value형태의 (ISO 8859-1) 인코딩의 텍스트파일이다.(한글 등은 유니코드형태로 변환되어 저장된다. /u0064같이..)

        //읽기
        Properties properties = new Properties();
        //프로퍼티파일은 일반적으로 해당 .class파일과 함께 저장한다. 아래는 그 경로를 이용한 예시이다.
        String path = CollectionsEx.class.getResource("db.properties").getPath();
        path = URLDecoder.decode(path, "utf-8"); // 경로에 한글이 껴있을경우 복원하는 코드이다.
        properties.load(new FileReader(path)); // 다른 패키지에 있는 경우 '/'나 '.' 등 사용하면된다.
        properties.forEach((k,v)-> System.out.println(k + " : " + v));
        //기본적으로 Map이라 Map으로 사용해도 되긴 한데,get(Object반환..)대신 getProperty(key)를 일반적으로 사용한다.
        System.out.println(properties.getProperty("username"));

        //TODO Stack
        Stack<Integer> stack = new Stack<>();

        //TODO Queue
        Queue<Integer> queue = new LinkedList<>(); //대표적인 구현클래스이다.

        //TODO 스레드동기화 래핑
        //스레드 동기화 되지 않은 컬렉션들에 래핑을 해서 반환하는 방법이다.
        List<Integer> syncronizedList = Collections.synchronizedList(new ArrayList<>()); //컬렉션에 동기화래핑
        //동기화는 기본적으로 block이 걸리므로 성능이 좋지 못하다. 항상 이 점을 감안하자!

        //TODO 병렬처리
        //ConcurrentHashMap
        //부분(segment)잠금을 사용한다. (처리요소가 포함된 부분만 잠그는 기술이다.) ????? 검색 필요!
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        //부분잠금 : 피터슨알고리즘 참고. https://ko.wikipedia.org/wiki/%ED%94%BC%ED%84%B0%EC%8A%A8%EC%9D%98_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
        //결국 변수로 임계구역 직접 만드는 느낌.


        //ConcurrentLinkedQueue
        //(lock-free)알고리즘을 구현하였다. (여러 스레드가 접근시, lock 사용하지 않고도 최소한 하나의 스레드가 안전하게
        // 요소를 저장하거나 얻게 해준다.)
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        //lock-free : lock을 걸지 않는다는 것 뿐이지, 무한루프 등의 방법으로 계속적으로 시도한다.
        //ex) stack의 push메서드는 do 에서 삽입을 시도하고, while에서 oldhead의 값이 내가 알던 값이 맞는지 체크한다.
        // 같다면 다른스레드가 간섭한 것이 아니므로 성공이고.. 뭐 이런느낌. 적어도 한 스레드는 성공한다.





    }
}
