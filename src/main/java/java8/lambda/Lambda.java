package java8.lambda;

import java.util.Comparator;
import java.util.function.*;

public class Lambda {
    public static void main(String[] args) {
        // TODO 람다식
        Consumer<Integer> intConsumer = (x)->{System.out.println(x);}; // 기본형태. 대입되는 인터페이스를 타겟타입이라고 한다.
        intConsumer = x -> {System.out.println(x);}; // 매개변수 한개면 () 생각가능
        intConsumer = x -> System.out.println(); // 실행블록 한줄이면 {} 생략가능
        intConsumer = System.out::print; // 단순히 전달만 한다면 호출까지 생략가능.
        //Funct<Integer, Integer> biConsumer = (x,y) -> x+y; // 한줄 리턴이면 return 생략가능

        //TODO 메소드참조
        ToIntBiFunction<Integer, Integer> myFunction =  (x,y) -> Math.max(x,y); //다음과 같이 단순히 값 전달만 할 경우.
        myFunction = Math::max; // 다음과 같이 축약할 수 있다.

        //정적 메서드 - 메서드참조
        myFunction = Math::max; // 클래스::메소드명

        //인스턴스 메서드 - 메서드참조
        class MyClass{
            public MyClass() {}

            public int myMethod(int x, int y){return x+y;}
        }
        MyClass myClass = new MyClass();
        myFunction = myClass::myMethod; // 참조변수::메소드명

        //생성자 - 메서드참조
        //단순히 객체를 생성해서 리턴하는 경우 사용한다.
        Supplier<MyClass> myClassSupplier = MyClass::new; // 클래스명::new

        //매개변수의 메서드호출
        String aa = new String("하하");
        String bb = new String("히히");
        aa.compareTo(bb); //이런식으로 인스턴스 a의 메서드 호출의 매개변수로 단순 전달하는 경우
        ToIntBiFunction<String, String> compare = String::compareTo; // 위 코드와 같다. a클래스명::메소드명
        // 정적클래스와 작성방법 동일!! 하지만 호출결과는 전혀 달라진다!



        //TODO 함수적 인터페이스 : 추상메서드가 하나밖에 없는 인터페이스. 디폴트나 정적메서드는 상관없다. Java8부터 적용
        // @FunctionalInterface 어노테이션을 붙이면 체크를 해준다. 필수는 아니다.
        /*Consumer 매개 -> void
        * Supplier void -> 리턴
        * Function 매개 -> 리턴 (매핑)
        * Operator 매개 -> 리턴(동일타입) (연산)
        * Predicate 매개 -> T/F (판단, 분류)
        *
        * 종류는 자동완성으로 확인하자.
        * */

        //TODO Consumer
        //디폴트메서드
        // andThen, compose : 컨슈머는 return 값이 없으므로 호출 순서만 정하는 의미가 있다. compose는 가능한 타입만.
        Consumer<Integer> consumer1 = System.out::println;
        Consumer<Integer> consumer2 = System.out::println;
        Consumer<Integer> consumerCombined1 = consumer1.andThen(consumer2); // 두 consumer를 합치고 있다.
        consumerCombined1.accept(3); // Consumer 인터페이스의 추상메서드는 accept이다.

        //TODO Supplier

        //TODO Function
        //디폴트메서드 andThen, compose
        Function<String, Integer> function1 = Integer::parseInt;
        Function<Integer, String> function2 = Integer::toBinaryString;
        Function<Integer, Integer> functionCombined1 = function1.compose(function2); //func2 호출 후 func1에 대입
        functionCombined1.apply(3); //Function 인터페이스의 추상메서드는 apply다

        //TODO Operator
        //디폴트메서드 andThen, compose

        //정적메서드 : BinaryOperator에만..
        Comparator<Integer> comparator = (x,y)->x-y; //비교자
        BinaryOperator.minBy(comparator); //제공한 비교자로 비교하여 min을 반환하는 Operator를 반환한다.
        BinaryOperator.maxBy(Integer::compare); //int, int의 비교는 Integer.compare 을 사용할 수 있다.

        //TODO Predicate
        //Predicate는 T/F로 값이 도출되는데, 취합하여 reduce하는데 사용한다.

        //디폴트메서드 and, or, negate
        Predicate<Integer> predicate1 = X -> X>0;
        Predicate<Integer> predicate2 = X -> X<0;
        predicate1.and(predicate2); // And 한다.
        predicate1.or(predicate2); // OR 한다
        predicate1.negate(); // Not 한다.
        predicate1.test(3); // Predicate 인터페이스의 추상메서드는 test다.

        //정적 메소드
        Predicate.isEqual(null); // Objects.equals 적용한 predictor 를 반환한다.

        //TODO 람다 this 확인
        Lambda lambda = new Lambda();
        A a = lambda.new A();
        System.out.println(a.getClassName.get());
    }

    class A{
        //TODO 람다의 this. 람다는 익명구현객체이지만 this는 람다의 호출클래스를 가리킨다. 외부클래스를 가리키고 싶다면
        //Outer.this 를 사용한다.
        Supplier<String> getClassName = () -> Lambda.this.getClass().getName() + ", " + this.getClass().getName();
        //마찬가지로, 로컬클래스가 되는 것이므로, TODO 외부 변수의 사용시 final의 특성을 가져야 한다!!!
    }
}