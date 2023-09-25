package java8.javafx;

import javafx.application.Application;
import javafx.stage.Stage;

/*TODO 개요
* JavaFX : Rich Client Application 개발용 그래픽&미디어 패키지
* Java7부터 JDK 에 포함 -> 별도 SDK 설치 없이 사용가능. (상위버전은 다시 빠져서 별도설치필요)
* 임베디드장비 UI 개발에도 사용가능
*
* AWT : OS제공 native UI 컴포넌트 사용 -> 모양도 다르고 종류도 제한적
* Swing : OS사용 안했더니, OS 가 진화하면서 오히려 native UI를 선호하게 됨. -> 해결하다보니 메모리사용, 속도 때문에 사장됨
* JavaFX 1.0 : flash, silverlight 대항마로 만들어짐. but 새 언어를 다시 익히기 실어해서 안씀
* JavaFX 2.0 : java만 사용가능하게 함.
* */

//TODO 메인클래스
// Application 상속받아, 메인윈도우 생성하고, launch 한다.
public class AppMain extends Application {
    //TODO 라이프사이클
    // 1. Application.launch()
    // 2. 기본 생성자
    // 3. init() - Launcher 스레드가 실행하므로 UI변경코드 사용불가.
    // 4. start()
    // 5. .....
    // 6. stop() - Platform.exit() or 마지막 Stage 닫히면 실행됨
    // 7. 종료
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        primaryStage.show(); //화면 띄우기
        //stage 는 window 이다.
    }

    public static void main(String[] args) {
        launch(args); // 여기에서 stage만들고 등등.. 해서 start() 를 호출한다.
        //TODO launch가 만드는 스레드
        // 1. JavaFX-Launcher - init()실행
        // 2. JavaFX Application Thread - 기본생성자, start(), stop() 실행
        // 모든 UI 작업은 application Thread가 하는데, 그 이유는 JavaFX는 스레드에 안전하지 않기 때문이다.

    }


    @Override
    public void init() throws Exception {
        super.init();
    }
}
