package java8.basic;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class Basic2 {
	public static void main(String[] args) {
		//TODO �⺻ API��
		//JAVA_HOME\jre\lib\rt.jar�� ����Ǿ� ����.
		
		/*TODO Objects
		 * ���
		 *  - null���� �Ǵ�
		 *  - hash ����
		 *  - �� �� 
		 * */
		//��
		Objects.equals(new Object(), new Object()); // Object�� equals���� ���̴�, null���� �񱳰� T��� ���̴�.
		Objects.deepEquals(new int[10], new int[10]); // �ٸ� �迭�̶� ���� ������ T�̴�.
		Objects.compare(new Object(), new Object(), (o1, o2) -> Integer.compare(o1.hashCode(), o2.hashCode()));
		
		//hash��
		Objects.hash(new Object(), new Object(), new Object()); //-> �Ű������� �迭 ����� Arrays.hashCode�� �����Ѵ�.
		// Object�� hash���� ���̴�, null�ϋ� 0�� �����Ѵٴ� ���̴�. �ᱹ ���� nulló���� ����
		
		
		
		//TODO Object		
		//Clone : �ŷ����� �ʴ� �������� ��ü�� �ѱ�� ��� Ŭ�δ� �Ͽ� �Ѱܼ� ��ȣ�Ѵ�.
		class Clone implements Cloneable{ // Cloneable�� �����ؾ� clone �޼��带 ����� �� �ִ�. 
			int comparingField;
			
			// Cloneable�� �����ؾ� �ϴ� �޼ҵ�� ����. ���� ����� �ǹ��̴�.
			@Override
			protected Object clone() throws CloneNotSupportedException {
				return super.clone(); // �ٸ�, ���⼭ protected�� �������̵����� ������ Object�� ��Ű���� �޶� ������ �ʴ´�.
			}
			
			// �Ҹ���
			@Override
			protected void finalize() throws Throwable {
				super.finalize(); //Object�� finalize�� �⺻���೻���� �ƹ��͵� ����.
				//���ҽ�����, �߿��� ������ �����ϰ� ���� �� ����Ѵ�. ����׿� ���� ����� ��
			}
			
			@Override
			public boolean equals(Object obj) {
				// equals�������̵��� �� �ÿ���, obj�� �����Ƿ� �� ����ȯ �� �ʵ带 �����־�� �Ѵ�.
				if (obj instanceof Clone) {
					Clone cmp = (Clone)obj;
					if (cmp.comparingField == this.comparingField) {
						return true;
					}
				}
				return false;
			}
		}

		//clone
		Clone clone = new Clone();
		try {
			clone.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		
		
		//TODO System
		// ��� �ʵ�/�޼ҵ尡 static�̴�.
		
		//�޸𸮰� ������ ȯ���� �ƴ϶�� ����� ���� ����. ( ���������� ȭ����ȯ ��..) 
		System.gc(); //�޸𸮺��� / CPU�Ѱ��� �� ����
		
		//���� �ð� ��� -> �ڵ��� �ҿ�ð� ������ �� ���� ����Ѵ�.
		System.currentTimeMillis();
		System.nanoTime();
		
		//�ý��� ������Ƽ : JVM ���۽� �ڵ������Ǵ� �ý��ۼӼ���.
		System.getProperties().forEach((k, v) -> System.out.printf("%-30s : %-30s\n", k, v));
		//fileSeparator, os, java.version, user.home�� ������ �������� ����!
		
		//ȯ�溯�� �б� : ��κ��� OS�� ���α׷��� ������ ������ �����ϱ� ���� ȯ�溯���� �����Ѵ�.
		System.out.println("-----------------------------------------------");
		System.getenv().forEach((k, v) -> System.out.printf("%-30s : %-30s\n", k, v));
		
				
//		System.setSecurityManager(new SecurityManager() {
//			@Override
//			public void checkExit(int status) {
//				super.checkExit(status);
//				if (status != 5) {
//					throw new SecurityException();
//				}
//			}
//			//�� �ܿ��� ���� check�޼��尡 �ִ�. exit�� ����Ѵٸ� ��������!!
//		});
		//System.exit(0); //JVM ��������. checkExit()�� �ڵ�ȣ���ϹǷ� �����ڵ���� �б��ų �� �ִ�.
		
		
		System.out.println("-----------------------------------------------");
		
		//TODO Class : Ŭ������ �޸𸮿� �ε� �� ���
		//Class��� : new�� ���� �� ����!
		Object obj1 = new Object();
		Class clazz1 = obj1.getClass(); // 1. getClass�� ���
		Class clazz2 = null;
		try {
			 clazz2 = Class.forName("java.lang.Object"); // 2. forName���� ���. fullName�� �����־�� �Ѵ�.
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace(); // ClassLoader ���� ��Ī & �߰��ϱ�
		}
		
		Method[] methods = clazz1.getMethods(); // public����� ��ȯ�Ѵ�.
		Method[] declaredMethods = clazz1.getDeclaredMethods(); // �������� �ش�Ŭ������ ���� ����Ǿ��� �����̴�.
		
		//Ŭ������ ���� ���� : �������̽��� �̿��ϸ� ���ϴ�.
		class A implements Usable{public void use() {System.out.println("A use!");}}
		class B implements Usable{public void use() {System.out.println("B use!");}
								  public B(Integer i) {System.out.println(i + " : B Constructed!");}}
		
		try {
			Usable usable;
			usable = (Usable) Class.forName("basic.Basic2$1A").newInstance(); // ��¥ �۸��Ģ �״�γ�...
			usable.use();
			//�ٵ� �⺻ ������ �� �־���Ѵ�. �Ű����� �ְ�ʹٸ� Constructor �� invoke�ؾ� ��.
			usable = (Usable) Class.forName("basic.Basic2$1B").getConstructor(Integer.class).newInstance(3);
			usable.use();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
			//InstantiationException = �߻�Ŭ����, �������̽� 
			//IllegalArgumentException = ����������
			// ���....
			e1.printStackTrace();
		}
		
		//TODO String
		//�����ڰ� �������ε�, byte[]�����ڴ� ����, Network�κ��� �޴� ��찡 ����.
		//��) Systen.in.read() : Enter�Է±��� ���۷� ���� �� byte[]�� ������
		String str = "�׽�Ʈ�Դϴ�.";
		try {
			str.getBytes("UTF-8"); // byte[]���� ��ȯ. ���ڵ����� �����ϴ�. 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//intern
		str.intern(); //-> String ���ͷ��� ���� String pool������ ����ǰ�, new�� ������ �׳� ���� �����ȴ�.
		//intern�� �ش� str�� ���� ���� String pool�� ���ͷ��� ��ȯ�Ѵ�. �޸𸮺����ϰų� ==�������� �ӵ� ���� ����Ѵ�.
		
		//split
		String[] tokenedStr1 = str.split(".|/|,"); //ù���� ����̴�. ����ǥ���� ����Ѵ�.
		StringTokenizer stringTokenizer = new StringTokenizer(str, " ,."); //�ι��� ���. ������ ����
		
		//TODO StringBuffer(��Ƽ������ ����ȭ���� (������ȯ�濡���� ����)) vs StringBuilder
		
		//TODO Pattern -> ����ǥ����. doc���� regexã�� ��������.
		
		//TODO Arrays
		Arrays.fill(new int[10], 50); // ���� ������ ä��� �ż���
		// �� �ܿ��� ����, Ž��, ��, ���� �� �����ϴ�. �迭���� �޼���� �׻� Arrays���� ã�ƺ���!
		
		//TODO Format : ���ڿ��� ������ �����ؼ� ��ȯ�Ѵ�. java.text
		//����
		DecimalFormat df = new DecimalFormat("#,##0;-#,##0");
		System.out.println(df.format(-12345));
		
		//��¥
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� M�� d��");
		System.out.println(sdf.format(new Date(1998, 3, 6)));

		//���ڿ� ���� : sql, ��Ʈ��ũ����, �������� � ����Ѵ�.
		System.out.println(MessageFormat.format("select {0} from {1} where {2}", 3, "table2", "a>4"));
		

		
		
		//TODO ��¥, �ð�
		Date date = new Date();
		
		// ����. ���������� ȣȯ�� ���� ���. �޷��� �ǹ��Ѵ�.
		Calendar calendar = Calendar.getInstance(); // getInstance�� �߻�Ŭ������ ������ ����Ʈ��ü�� ��ȯ�ϴ°��̴�. �̱��ϴ����� �ƴ�.	
		//Timezone �ݿ��ؼ� ������ �����ϴ�.
		for (String timezone : TimeZone.getAvailableIDs()) {
			System.out.println(timezone); //�ȳ�����..
		}
		int year = calendar.get(Calendar.YEAR);
		// Ư���� ������ �ʿ��ϴٸ� Ȯ���ؼ� ����ؾ��Ѵ�.
		
		//TODO java8���� �߰��� �ð����� API. �̰� ������ ����
		LocalDate localDate = LocalDate.now(); // ��¥
		LocalTime localTime = LocalTime.now(); // �ð�
		LocalDateTime localDateTime = LocalDateTime.now();	//��¥ + �ð�
		ZonedDateTime dateTime = ZonedDateTime.now(); //Ÿ���� �ݿ�
		Instant instant = Instant.now(); // Ÿ�ӽ������� (Date�� ���� ���)
		
		//�ð��� ���� ��Ÿ���� Ŭ������. D-day�� ���� �� ���
		Period period = Period.ofDays(3); //�� ����
		Duration duration = Duration.ofHours(3); //�ð�����
		
		
	}
}

interface Usable{
	public default void use() {};
}