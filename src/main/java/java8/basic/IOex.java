package java8.basic;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.WatchEvent.*;
import java.util.*;
import java.util.concurrent.Executors;

public class IOex {
    public static void main(String[] args) throws Exception{
        //TODO io는 Stream을 사용하여 입출력한다.
        //io 라이브러리
        //FILE : 파일정보
        //Console : 콘솔문자 입출력
        //byte 단위 스트림 : InputStream, FileInputStream, DataInputStream, ObjectInputStream,
        //BufferedInputStream, PrintStream 등등..
        //char 단위 문자특화 스트림 : Reader/Writer, FileReader, InputStreamReader, PrintWriter, BufferdReader 등등

        //TODO File I/O Stream
        InputStream fis = new FileInputStream(new File(IOex.class.getResource("test.txt").getPath()));
        //getResource로 알아낸 경로는 .class 파일이 있는 폴더에 생성된다.

        int readByte = 0;
        while ((readByte = fis.read()) != -1){ // 1바이트를 읽어 int 맨 마지막 바이트에만 담아 리턴한다. EOF시 -1
            System.out.print((char)readByte); // 읽은 바이트를 출력
        }

        byte[] byteBuffer = new byte[20]; //버퍼를 설정해서 읽는 경우. 속도가 훨씬 빠르다.
        while((readByte = fis.read(byteBuffer)) != -1){ // 읽은 개수를 리턴. 없으면 -1
            // 한글 등 1byte가 넘는 문자들은 단체로 읽어서 인코딩을 줘야한다.
            System.out.print(new String(byteBuffer,0,readByte, "ASCII"));
        }

        fis.close(); // 항상 리소스를 사용한 후 닫아주도록 하자.

        OutputStream fos = new FileOutputStream(new File(IOex.class.getResource("test.txt").getPath()));
        fos.write("!".getBytes("ASCII"));
        fos.flush(); //출력스트림은 내부에 버퍼가 있다. 더이상 보낼 내용이 없으면 항상 호출해주자!!
        fos.close();

        //TODO FILE
        // 파일 정보얻기, 생성, 삭제
        // 디렉터리 정보얻기, 생성, 삭제, 내용보기 등
        // 파일내용 I/O는 미지원한다. FileStream 사용하라!
        System.out.println("현재 환경의 구분자 : " + File.separator); // os의 구분자 확인. 이 값은 상수인데,
        // 런타임에서는 다양할 수 있으므로 System클래스에서 얻도록 하자!!

        //URI로 파일 위치를 제공할 수도 있다. URI의 형식을 참고하자!!
        File file = new File(new URI("file:///C:/Workspace/Java/Study/src/basic/test.txt"));
        System.out.println("파일 존재하는지? : " + file.exists()); // File 변수를 생성한다고 실제로 생성되는 건 아니다.
        // 이 위치에 파일이 없어도 오류는 생기지 않는다.

        if (file.exists()){ // 파일 존재하는 경우
            file.canExecute(); //실행파일인지?
            file.canRead();
            file.canWrite();
            file.getName();
            System.out.println(file.getParent()); //부모 폴더의 경로 반환
            File parentDirectory =  file.getParentFile(); //파일로 반환
            System.out.println(file.getPath()); //파일의 전체경로
            for (String fileName : file.getParentFile().getParentFile().list()) { // 이름만 반환하는 list().
                System.out.println(fileName); // 하위 디렉토리까지 계속 들어가지는 않는 것을 볼 수 있다.
            }
        }else{ // 파일 존재하지 않는 경우
            file.createNewFile();
            file.mkdir();
            file.mkdirs(); // 경로상 없는 폴더 모두 생성
            file.delete(); // 파일/디렉토리 삭제
        }

        //TODO Console
        InputStream cis = System.in; //System.in은 InputStream이다.
        // read 호출시 ASCII로 받는다. 유니코드 받을시 byte[]에 받아 String 으로 인코딩한다.

        PrintStream cos = System.out; // System.out은 PrintStream이다.

        Console console = System.console(); // Console은 Console 입출력에 특화된 클래스이다.
        //System.console() 은 Eclipse 에서 실행시 null 반환하니, 무조건 cmd에서 실행해주어야 한다. intelliJ도네.
        if (Objects.nonNull(console)) {
            System.out.print("readLine : ");
            console.readLine();
            System.out.print("readPassword : ");
            console.readPassword(); // 차이점은 터미널에서 echo가 발생하지 않는다는 것이다.
        }

        //Scanner : 다양한 소스에서 문자를 읽고 싶을 때 사용한다!
        Scanner scanner = new Scanner(System.in); // 입력소스는 System.in외에도, File, InputStream, Path등 다양하다!!
        scanner.close();

        //TODO 보조스트림 = 필터스트림(일부가 FilterInput/OutputStream의 하위클래스이기 때문)
        // 기능 : 문자변환(I/OStreamReader), 성능향상(Buffered), 원시타입 입출력, 객체 입출력 등등...

        //스트림 체이닝
        InputStream isSource = System.in;
        BufferedInputStream bis = new BufferedInputStream(isSource); // 이렇게 계속 체이닝 가능하다.

        //Bufferd : 프로그램 성능은 입출력이 가장 느린 장치를 따라가는데, 이걸 메모리 Buffering으로 어느정도 해결가능하다.
        //BufferdInputStream : 내부에 8912 byte 버퍼 보유 (Reader는 8192 char. 즉 2배)
        //BufferdReader는 readLine() 메서드를 추가로 가진다. 한글읽기가 가능하다!!
        //BufferdOuputStream : 버퍼 차기전엔 출력하지 않으므로 flush() 꼭 호출해주자!!

        //DataStream : 원시타입 입출력이 가능해진다. readUTF()는 UTF-8 인코딩으로 읽는 것.

        //PrintStream/Writer : printf 가진다.
        /* printf 형식문자
        * tF : 2010-01-06
        * tY : 4자리 ty : 2자리
        * tm td : 2자리 월, 일
        * tH : 2자리 시
        * tl : 0~12 시
        * tM tS : 분 초
        * %1$, %2$ : 매개값 순번 의미.
        * -, 0 : 아무것도 안하면 왼쪽정렬, - 는 오른쪽 정렬, 0은 왼쪽정렬하고 0으로 채움
        * */
        System.out.printf("%d %d %1$d", 5,6); // 이와 같이, %index$type 형식으로 매개변수를 사용가능하다.

        //TODO 직렬화
        fos = new FileOutputStream(new File(IOex.class.getResource("object.dat").getPath()));
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        SerializingChildClass obj = new SerializingChildClass();
        obj.childField1 = 999;
        SerializingChildClass.childField2 = 2;
        obj.childField3 = 3;
        obj.setParentField(999999);

        oos.writeObject(obj);
        oos.flush(); oos.close(); fos.close();



        fis = new FileInputStream(new File(IOex.class.getResource("object.dat").getPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);

        SerializingChildClass childClass = (SerializingChildClass) ois.readObject();
        System.out.println();
        System.out.println(childClass.childField1);
        System.out.println(childClass.childField3); // transient 라 직렬화 제외되어 0 출력하는 걸 알 수 있다.
        System.out.println(childClass.getParentField());

        ois.close(); fis.close();

        //TODO 네트워크
        // port 구분 : 1 ~ 1023 전용포트
        // 1024 ~ 49151 회사에서 등록하여 사용
        // 49152 ~ 65535 개인목적 / OS 의 자동할당

        //TODO InetAddress
        InetAddress inetAddress = InetAddress.getByName("www.naver.com"); //DNS 검색도 제공한다!
        System.out.println("getByName : " + inetAddress);
        //연결이 많은 큰 회사들은 한 도메인에 여러 IP 등록하여 사용하기도 한다. 이때 getAllByName 사용한다.
        InetAddress[] inetAddresses = InetAddress.getAllByName("www.naver.com"); //2개 사용한다.
        for (InetAddress addr : inetAddresses) {
            System.out.println("getAllByName : " + addr);
        }
        System.out.println("getLocalHost : " + InetAddress.getLocalHost()); // 현재 컴퓨터의 주소
        System.out.println("getHostAddress : " + inetAddress.getHostAddress()); // ip주소만 반환

        ServerSocket serverSocket = new ServerSocket(5001);
        // serverSocket.bind(new InetSocketAddress("localhost",5001)); 생성자에서 주지 않고, 후에 이렇게 바인딩 해도 됨
        // 서버 소켓은 포트 지정해놓고 다른 컴퓨터에서 접속할 구멍을 만들어 둔다는 의미
        // 현재 PC에서 멀티IP 사용중인 경우 localhost 대신 ip주소를 명시해주면 된다.
        serverSocket.close();


        Socket socket = new Socket();
        //socket.getInputStream().read(); 이런식으로 사용한다.
        // read() : serverSocket 측에서 close() 시 -1 반환. 비정상종료시 예외발생 -> 예외처리 필요!
        //(InetSocketAddress)socket.getRemoteSocketAddress(); RemoteSocket은 Inet이므로 형변환가능하다!!
        socket.close();

        //TODO UDP
        // new DatagramSocket(5002).send(new DatagramPacket()); 그냥 보내면 된다.
        // 수신은 socket으로 한다.

        //TODO NIO
        // 채널기반 -> input output 동시에 하나의 채널에서 처리가능
        // 버퍼 -> I/O는 읽은데이터 즉시 처리해야함 : 대신 NIO는 버퍼할당 오버헤드가 있고, 더 복잡하다
        // -> NIO는 OS 의 버퍼 (direct buffer) 사용하여 속도가 더 빠르고, 버퍼에서 이동하면서 필요부분만 읽고 쓸 수 있다.
        // 블로킹 -> NIO의 블로킹모드는 IO와 다르게 interrupt가 가능하다!
        // -> NIO는 작업스레드가 1개이고, 준비된 채널만 선택해서 처리하기 때문이다. (Node.js같네)
        // IO를 써야 할 떄 : 대용량이고, 순차처리가 필요할 때
        // NIO를 써야할 때 : 연결이 많고, 하나의 입출력이 짧을 때 (작업 스레드가 하나이니까.. Node.js랑 똑같네)

        //TODO 경로정의 (Path)
        // IO의 File에 대응되는 NIO인터페이스이다.
        
        //path 생성의 다양한 방법
        Path path = Paths.get("C:/Workspace/Java/Study/src/basic/test.txt");
        path = Paths.get("C:/Workspace/Java/Study/src/basic","test.txt");
        path = Paths.get("C:","Workspace","Java","Study","src", "java/basic","test.txt");
        //path = Paths.get(new URI());

        //상대경로 사용
        path = Paths.get("test.txt");
        path = Paths.get("./test.txt");
        path = Paths.get("../basic/test.txt");

        System.out.println(path.getFileName()); // 부모 제외, 자신의 이름만 가진 Path
        System.out.println(path.getName(0)); // C:/Workspace(0)/Java(1)/Study(2).... 이런 식의 index
        System.out.println(path.getNameCount()); // 중첩경로 수 리턴. 위 주석처럼 루트 제외하고 리턴
        System.out.println(path.compareTo(path)); // 상위경로 = 음수, 하위경로 = 양수. 차이나는 문자열 수 리턴
        System.out.println(path.normalize()); // 상대경로면 필요없는 부분 없애줌. basic/../classex -> classex
        //System.out.println(path.register()); watch 서비스 등록.. 뒤에서 설명
        System.out.println(path.getFileSystem()); //파일시스템 리턴.. ????

        //FileSystem 정보
        //OS의 파일시스템에 접근한다! Path는 "경로"를 의미하는 것이고, 실제 조작은 파일시스템 접근이겠지?
        FileSystem fileSystem = FileSystems.getDefault(); //Path를 주면서 얻을수도 있따!
        System.out.println(fileSystem.getSeparator()); // 구분자 리턴 -> 이걸로 써도 되겠네..
        //FileStore = 드라이버(디스크)를 표현한 객체이다.
        Iterable<FileStore> fileStoreIterable = fileSystem.getFileStores();
        fileStoreIterable.forEach(fs->{
            try {
                System.out.println("--------------------------------");
                System.out.println("driver name : " + fs.name());
                System.out.println("driver Total Space(GB) : " + fs.getTotalSpace()/1024.0/1024/1024);
                System.out.println("driver Usable Space(GB) : " + fs.getUsableSpace()/1024.0/1024/1024);
                System.out.println("driver Unallocated Space(GB) : " + fs.getUnallocatedSpace()/1024.0/1024/1024);
                System.out.println("driver isReadOnly : " + fs.isReadOnly());
                System.out.println("driver fileSystem type : " + fs.type());
                System.out.println("--------------------------------");
            } catch (IOException e) {e.printStackTrace(); }
        });

        //Files 클래스 : 파일, 디렉토리 생성/삭제/속성읽기
        //getInputStream 같은 메서드로 실제 스트림을 생성하여 내용을 볼 수도 있다!!!
        //probeContentType : file의 MIME 타입 리턴
        // 세부 내용은 docs 참고...

        //WatchService : 디렉토리 내부 내용변화 감시
        WatchService watchService = FileSystems.getDefault().newWatchService(); //생성
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, //어떤 동작을 감시할 것인지??
                                    StandardWatchEventKinds.ENTRY_CREATE,
                                    StandardWatchEventKinds.ENTRY_DELETE);

        if(false){
            while(true){
                // 이벤트가 발생하면 해당 정보를 가진 watchkey를 Queue에 넣는다.
                // 프로그램은 무한루프 돌면서 감시한다.
                WatchKey watchKey = watchService.take(); //block 된다.

                List<WatchEvent<?>> list = watchKey.pollEvents(); // 리스트인 이유는, 여러 파일이 동시 조작 가능하기 떄문이다.
                //WatchEvent는 파일당 하나씩만 발생한다. 그래서 리스트에 담는 것

                for (WatchEvent watchEvent : list) {
                    Kind kind = watchEvent.kind(); //이벤트 종류
                    Path path1 = (Path)watchEvent.context(); //감지된 Path
                    if (StandardWatchEventKinds.ENTRY_CREATE.equals(kind)) {
                    } else if (StandardWatchEventKinds.OVERFLOW.equals(kind)) {
                        //OVERFLOW는 OS에서 이벤트가 소실되거나 버려진 겨우 발생한다.
                        // 따라서 별도 처리코드가 필요없다.

                    }
                }

                //한번 사용된 watchKey는 reset()으로 초기화해서, 다시 이벤트가 발생하면 큐에 들어간다
                boolean valid = watchKey.reset();
                // 검사디렉토리가 삭제되었거나, 키가 더이상 유효하지 않을 경우 false 리턴
                if (!valid) break;
            }
        }
        watchService.close(); // 유효하지 않다면 무한루프 빠져나와 와치서비스를 닫으면 된다.


        //TODO 버퍼
        // 저장되는 데이터타입, 다이렉트 넌다이렉트로 나뉜다
        // Buffer (최상위 추상클래스)
        //  - Byte,Char,Short,Int,Long,Float,Double Buffer
        //  - MappedByteBuffer : BtyteBuffer의 하위클래스. 파일의 내용에 랜덤 접근 위해 메모리와 맵핑시킨 버퍼 ??
        // non-direct Buffer
        //  - JVM의 Heap 사용
        //  - 버퍼 생성 빠름
        //  - 버퍼 크기 작음 -> JVM의 한정된 힙이기 떄문
        //  - 입출력 성능 낮음 -> 입출력 위해 임시 다이렉트버퍼 생성, 넌다이렉트버퍼의 내용을 복사, native IO수행하기 때문
        // direct Buffer
        //  - OS의 메모리 사용 -> OS의 native C코드를 호출해야하고, 여러가지 잡다한 처리가 필요해서, 한번 만들고 재사용하는게 바람직하다.
        //  - 버퍼 생성 느림
        //  - 버퍼 크기 큼 -> OS가 직접 할당하기 때문
        //  - 입출력 성능 높음 (입출력 빈번시 유리)
        //  - Channel을 통해서 조작할 경우에만 native I/O사용. 그러지 않고 직접 get(), put() 사용할 시
        //  - 내부적으로 JNI 호출하여 native I/O 수행하므로 JNI 오버헤더가 추가된다. -> 오히려 넌다이렉트 get() put()이
        //  - 성능이 더 좋게 나올 수도 있다.
        //  - JNI(Java Native Interface) : Java에서 C 함수 호출할 수 있도록 해주는 API


        // direct vs non-direct
        try {
            ByteBuffer directBuffer = ByteBuffer.allocateDirect(200*1024*1024); //  200MB 생성
            ByteBuffer nonDirectBuffer = ByteBuffer.allocate(200*1024*1024); // non-direct는 크기를 넘어서 오류가 생길 수 있다.
        }catch(OutOfMemoryError e){e.printStackTrace();}

        // non-direct Buffer
        ByteBuffer nonDirectBuffer = ByteBuffer.allocate(100); // byte가 아니라 개수다. int면 int 100개 의미
        nonDirectBuffer = ByteBuffer.wrap(new byte[100]); //wrap으로 byte[]을 감싸 생성할 수도 있다.

        //direct Buffer
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(100);
        //allocateDirect 함수는 ByteBuffer에만 있다. 따라서 다른 타입이 사용하고 싶으면 변환해주어야 한다.
        CharBuffer charBuffer = directBuffer.asCharBuffer(); // 크기는 100byte였기에, char은 50개 저장할 수 있다.

        // byte 해석순서
        // big-endian : 앞쪽 바이트부터 처리
        // little-endian : 뒤쪽 바이트부터 처리
        // 이식되는 곳이 다른 endian이라면 ByteOrder 클래스로 데이터순서를 맞춰줘야 한다.
        System.out.println(ByteOrder.nativeOrder()); // 현재 OS의 엔디언을 알려줌
        // JVM은 독립된 운영체제이기 때문에, OS 상관없이 기본적으로 Big endian으로 동작하도록 되어있다.
        // JVM과 OS가 다르면 데이터 교환시 자동으로 처리해줘서 문제는 없다.
        // 하지만 direct 버퍼일 경우 OS의 native I/O를 사용하므로, OS의 기본해석순서로 JVM의 해석순서를 맞추는것이
        // 성능에 도움이 된다.
        directBuffer.order(ByteOrder.nativeOrder()); // 이와 같이 allocateDirect 에 바로 붙여 세팅해주면 된다.



        //Buffer 위치속성
        // 0 <= mark <= position <= limit <= capacity
        // mark : reset()시 복귀위치. mark()로 지정. 반드시 position 이하의 값으로 지정해야 함. (그렇지 않으면 자동제거)
        // position : 현재 쓰는 위치. limit과 같아지면 더이상 쓸 수 없다는 뜻. 데이터가 들어갈 빈 위치를 가리킴
        // limit : 읽거나 쓸 수 있는 한계위치. 처음 생성시 capacity와 같은 값 가짐
        // capacity : byte가 아닌 수량을 의미. 맨끝의 EDF위치(배열 없는곳)을 가리키고 있다.

        //flip() : 현재 position을 limit으로 설정하고 position을 0으로 이동시킴 -> 데이터를 다 썼으니, 읽기 위해
        // 처음으로 돌아가되, limit까지만 데이터니까 limit까지만 읽으라는 뜻
        // rewind() : 한번 더 읽고싶다! -> position만 0으로 돌림
        // mark() : reset() 호출 시 돌아갈 위치 지정. position이 mark보다 적어지면 자동 삭제
        // clear() : 초기화. limit = capacity, position = 0, mark 삭제.. 하지만 데이터는 삭제되지 않는다.
        // compact() : position ~ limit 사이의 데이터가 0번 인덱스로 이동. limit은 capacity로 이동 ex)abcde -> decde
        //  -> 호출하는 이유는, 읽지 않은 데이터 뒤에 새로운 데이터 저장하기 위함.(position은 복사된 다음 위치로 이동하거든.)
        // array() : wrap한 배열 리턴
        // hasArray() : 래핑했는지?
        // arrayOffset() : 버퍼의 첫번째 요소가 있는 내부 배열의 인덱스를 리턴 ?????
        // 읽고 쓰기 : put(), get() -> 상대적, 절대적 지정가능. 상대적일땐 position 자동증가. 절대적일땐 지정 인덱스에 저장하고 position 부동.

        // 읽고 쓰는 데이터의 변환 (byte로의 변환)
        //String
        Charset charset = Charset.defaultCharset(); //OS가 이용하는 기본 charset
        charset = Charset.forName("utf-8"); // 지정
        String data = "myData";
        ByteBuffer byteBuffer1 = charset.encode(data); //put 하는 것이 아닌, 직접 버퍼를 얻는다.

        //int[]
        int[] ints = new int[]{ 10, 20 };
        IntBuffer intBuffer = IntBuffer.wrap(ints);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(intBuffer.capacity()*Integer.BYTES);
        while(intBuffer.hasRemaining()){
            byteBuffer2.putInt(intBuffer.get()); //String과 다르게 직접 put 한다.
        }

        byteBuffer2.flip();
        byteBuffer2.asIntBuffer().get(ints); // 읽기



        //TODO FileChannel
        // 파일 읽고 쓰기 할 수 있다.
        // 동기화되어 멀티스레드에 안전하다

        //채널 생성
        FileChannel fileChannel = FileChannel.open(Paths.get("test.txt"), StandardOpenOption.WRITE,
                                                                                StandardOpenOption.APPEND);
        //Option의 종류
        //READ : 읽기용으로 연다
        //WRITE : 쓰기용으로 연다
        //CREATE : 없으면 만든다
        //CREATE_NEW : 이미 있으면 예외와 함께 실패한다.
        //APPEND : 파일 끝에 추가한다. WRITE나 CREATE와 함꼐 사용된다.
        //DELETE_ON_CLOSE : 채널 닫을때 파일 삭제한다. 임시파일 삭제시 사용.
        //TRUNCATE_EXISTING : 파일을 0바이트로 잘라낸다. WRITE 옵션과 하몎 사용한다.

        //open() 말고도, IO와 호환을 위해 fos, fis에서 getChannel() 할 수 있다.


        //쓰기
        int bytesCount = fileChannel.write(charset.encode(data)); //position ~ limit 까지 쓰여진다.

        //읽기
        bytesCount = fileChannel.read(byteBuffer2); // 한 바이트 저장시 마다 position이 1씩 증가

        //파일복사
        // 1개의 버퍼를 대상으로 2개의 채널을 열어 사용하면 된다.
        // 채널에서 읽고, 다시 채널로 쓰는 경우 direct 버퍼가 성능이 좋다.
        // 다만, 단순히 파일복사 자체가 목적이라면 Files.copy() 이용하자. (StandardCopyOption사용)


        fileChannel.close(); // 사용 안할 시 닫아줘야 한다.


        //파일 비동기채널
        //filechannel의 read와 wirte는 기본적으로 blocking으로 작동한다.
        //불특정다수파일 / 대용량 파일 입출력을 위해, 비동기파일채널 제공 (callback 방식, 내부 스레드풀 사용)
        AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(Paths.get("test.txt"),
                                                                                        StandardOpenOption.APPEND,
                                                                                        StandardOpenOption.WRITE);
        // 내부 스레드풀은 개발자가 지정할 수 없는데, 두번쨰 open()을 사용하여 스레드풀을 세부지정할 수 있다.
        EnumSet.of(StandardOpenOption.WRITE, StandardOpenOption.APPEND); // Enumset.of는 열거타입을 set로 반환한다.
        //attachment : callback 내부로 전달할 첨부객체. 결과값 외 추가적 정보 얻고 싶을 때 사용한다. 필요없으면 null 대입
        //handler : CompletionHandler<Integer, Attachment>
        // Integer는 읽은 바이트수, Attachment는 첨부객체이다. 없으면 Void 주자.
        class Attachment{
            AsynchronousFileChannel asynchronousFileChannel;
        }
        Attachment attachment = new Attachment();
        attachment.asynchronousFileChannel = asynchronousFileChannel;

        asynchronousFileChannel.read(byteBuffer2, 0, attachment, new CompletionHandler<Integer, Attachment>() {

            // 아래 callback 함수들은 내부 작업스레드에서 실행된다. 즉, 함수가 호출된 곳에서 실행되는것이 아니다.
            @Override
            public void completed(Integer result, Attachment attachment) {
                // 비동기 채널닫기 등으로 attachment를 응용할 수 있다.
                // 혹은 attachment에 저장된 channel이나 buffer로부터 데이터를 읽어 처리할 수도 있다.
                try { attachment.asynchronousFileChannel.close();} catch (IOException e) { e.printStackTrace(); }
            }

            @Override
            public void failed(Throwable exc, Attachment attachment) {
                try { attachment.asynchronousFileChannel.close();} catch (IOException e) { e.printStackTrace(); }
            }



        });

        //TODO 네트워크
        // 블로킹 / 넌블로킹 / 비동기 중 1개 골라야 한다. 이에 따라 구현이 완전히 달라진다.
        // socketChannel의 차이는, 버퍼를 사용하고, 논블로킹도 지원한다는 것이다. 또한 IO는 안되는 inturrupt를 지원한다.


        //tcp 블로킹
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(true); // blocking 방식 확정(기본임)
        serverSocketChannel.bind(new InetSocketAddress(5001));

        //serverSocketChannel.accept(); 블로킹된다.

        //SocketChannel도 동일.
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(true);
        //socketChannel.connect(new InetSocketAddress("localhost", 5001)); 연결될 때 까지 블로킹된다.
        //socketChannel.read(); blocing되는데, 이때 작업스레드에 inturrupt 하면 즉시 닫히면서 인터럽트된다. 예외처리해주자!!

        socket.close();
        serverSocketChannel.close();





        //tcp 넌블로킹
        // 핵심은 이벤트리스너인 Selector이다. 채널이 Selector에 통보하면 Selector가 해당 채널 aceept나 read 한다.
        // 채널은 자신의 작업 유형을 SelectionKey로 생성한다.
        // Selector의 interest-set (관심키셋) 에 자신의 SelectionKey를 등록한다.
        // Selector는 selected-set에 작업준비된 키를 큐잉하여 처리한다
        // 작업스레드를 하나만 사용할 필요는 없다. 적은 스레드로 많은 양의 작업 고속처리 가능해, 블로킹보다 서버성능 향상될 수 있다.

        // accept = 실패시 즉시 null 리턴
        // read() = 즉시 0 리턴
        
        Selector selector = Selector.open(); // IOException 발생가능
        //등록채널은 SelectableChannel의 하위채널만 가능하다. -> SocketChannel, DatagramChannel, Server 모두 가능하다
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        //등록
        //SelectionKey는, 작업유형변경, 첨부객체저장, 채널등록취소 등을 할 때 사용된다.
        //등록했다면 Channel의 keyFor로 얻을 수 있기 때문에 관리할 필요는 없다.
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //작업 유형 변경
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup(); // 키를 변경했기 떄문에 selector에 알려주어야 한다. select()의 블로킹을 해제한다.
        // select()는 블로킹된 상태로, 이전의 작업유형 통보만 기다리고 있기 때문에, 다시 select() 시켜 변경 감지시켜주는 것이다.

        // socket의 경우, connect, read, write 하는데, 동일채널로는 하나의 작업만 등록가능하다
        // 다른 작업을 하려면 SelectionKey를 수정해주어야 한다.

        int selectionkeyCount = selector.select(100); //작업처리 준비됬다는 통보 올 때까지 블로킹된다.
        //통보받은 키의 수를 리턴한다.
        selector.selectNow(); // 블로킹되지 않고 즉시리턴. 준비된 키가 없으면 0을 리턴한다.
        if (selectionkeyCount > 0){
            Set<SelectionKey> selectedKeys = selector.selectedKeys(); // 준비완료키가 있으면 set으로 Selectionkey들을 얻는다.
            for (SelectionKey key : selectedKeys) {
                if (key.isAcceptable()){
                    //channel을 얻으면 형변환해주면 된다.
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                    //channel외에 다른 객체가 필요하다면 SelectionKey에 attachment를 등록하면 된다.
                    // 그니까.. 모든 객체 주고받기는 attachment로 수행하라는 말이다..
                }
                else if(key.isConnectable()){} //~~~~ 이런식으로 key 작업별로 처리한다.
                selectedKeys.remove(key); //selector 의 selected-set 내부의 key이므로 처리 완료 후 제거해주어야한다.
                //향상된 for문 보다는 iterator를 얻어 while 돌리는게 더 맞을듯하다.
            }
        }

        //select가 리턴하는 경우는 세가지이다.
        // 1. 채널이 작업준비완료통보
        // 2. Selector의 wakeup() 호출
        // 3. select()를 호출한 스레드가 inturrupt됨

        //TODO 넌블로킹은 주로 서버를 개발할 때 사용한다. 즉, Client 단에서는 블로킹으로 구현하면 된다는 말이다.

        //TODO tcp 비동기채널
        // NIO의 보석같은 클래스이다.
        // read, accept 등... 호출시 즉시 리턴. 작업스레드가 작업 후 콜백 방식으로 작동한다.

        //AsynchronousChannelGroup 비동기 채널 그룹
        // 같은 스레드풀을 공유하는 비동기채널들의 묶음이다.
        // 하나의 스레드풀 사용시 모두 같은 그룹에 속해야 한다.
        // 비동기채널 생성시, 그룹 지정하지 않으면, 기본비동기채널그룹이 생성된다. -> 쓰레드가 Integer.MAX만큼 증가하므로 직접 만드는게 일반적이다.
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
                Runtime.getRuntime().availableProcessors(),
                Executors.defaultThreadFactory()
        );


        // 서버채널 생성
        AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);
        asynchronousServerSocketChannel.bind(new InetSocketAddress("localhost", 5001));

        asynchronousServerSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            // 비동기와 비슷하다. attach 객체 붙여주고, callback을 처리하는것.
            @Override
            public void completed(AsynchronousSocketChannel result, Void attachment) {
                asynchronousServerSocketChannel.accept(null, this); // accept 재호출
                // 이 재귀호출때문에 무한루프없이도 가능하다. stack overflow는 발생하지 않는데, 작업 큐잉 후 즉시리턴하기 때문이다.
            }

            @Override
            public void failed(Throwable exc, Void attachment) {}
        });

        // 그 외 나머지 코드는 다 같다. 생략.

        //채널 닫기
        asynchronousServerSocketChannel.close();

        channelGroup.shutdown(); // 사용하지 않을 경우 group을 종료한다. 의사만 전달한다.
        //channelGroup.shutdownNow(); 강제 종료하고 싶다면 Now 사용하자. 다만 completed 실행중인 스레드는 종료되지 않는다.

        //TODO udp 채널
        DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET); //IPv6 사용과 구분한다.

    }
}

//Serializable의 구현은 private 포함 모든 필드를 변환해도 좋다는 표시이다.
// 생성자, 메소드는 변환하지 않는다.
// static, transient 붙은 필드도 제외된다.
class SerializingParentClass{ //Serializable 하지 않은 부모클래스이다.
    int parentField1;
    //부모 필드까지 자동 직렬화 되지는 않는다. 방법은 크게 2가지
    //1. 부모 클래스도 Serializable 하게 한다
    //2. 자식이 Write, read 오버라이딩 하는 것. (부모클래스 직접 수정할 수 없을 때 사용)
}

class SerializingChildClass extends SerializingParentClass implements Serializable{
    //TODO UID 필드
    // Serializable 구현 시 추가되는 정적필드
    // 컴파일할 때마다 달라지기때문에, 명시적 선언으로 오류를 방지할 수 있음
    // 클래스마다 달라야 하기 때문에, JAVA_HOME/bin/serialver.exe 제공한다.
    // 사용법은 클래스의 .java경로에서 serialver (java파일명) 하여 구할 수 있다.
    static final long serialVersionUID = 7329476805787172844L; // IntelliJ에선 = 까지만 치고
    // Alt Enter 하면 자동으로 생성해주네. serialver는 왜인지 작동하지 않네...

    int childField1;
    static int childField2;
    transient int childField3;

    // 부모 클래스가 not Serializable일때 부모필드도 직렬화하기 위해 오버라이딩
    // 무조건 접근제한자가 private여야 한다. 그렇지 않으면 호출되지 않음
    // 오버라이딩이지만.. 이건 직렬화할때 동적으로 생성되는건가 봄... 어노테이션도 안붙고..
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.writeInt(super.parentField1);
        out.defaultWriteObject(); //자식 나머지 모든 필드
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        parentField1 = in.readInt();
        in.defaultReadObject();
    }

    public int getParentField(){
        return super.parentField1;
    }

    public void setParentField(int parentField){
        super.parentField1 = parentField;
    }

}