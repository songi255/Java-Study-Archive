package java8.generic;

/*TODO Generic
* 제네릭은 컴파일시 체크하며, casting을 제거하여 성능을 높인다.
* class 혹은 interface 에 제네릭을 사용할 수 있다.
* */
public class Generic<T extends Number, U>{ // 제한된 타입파라미터. extends 를 의미한다.

   public static void main(String[] args) {
      class A<T,U>{ //멀티타입 파라미터
         T[] arr = (T[]) new Object[3]; // 제네릭타입 배열을 선언하려면 Object타입으로 선언한 후 형변환해야 한다.

         public <X extends Number, Y extends Number> int genericMethod(X x, Y y){ // 제네릭 메소드
            return x.intValue() + y.intValue();
         }
      };
      class B<T,U,V> extends A{}; //멀티타입파라미터의 상속은 타입파라미터 수를 확장할 수 있다.

      A<Integer, Integer> a = new A<>(); // 제네릭의 인스턴스화. 반복되는 타입지정은 <>로 생략할 수 있다.


      System.out.println(a.genericMethod(3,5)); // 제네릭 메소드의 묵시적 호출
      System.out.println(a.<Integer, Integer>genericMethod(3,5)); // 제네릭 메소드 명시적 호출

   }

   //TODO 와일드카드
   //제네릭타입을 매개값/리턴타입으로 사용시 구체적 타입 대신 사용가능.
   public Generic<?,?> method1(Generic<? super Integer,? extends Number> generic){
      //무슨말인지 알겠지? 제네릭을 사용해서 정의할 떄, 해당 타입이 아무거나 써도되면 ? 이고, super등으로 제한시킬 수 있다.
      return generic;
   }
}
