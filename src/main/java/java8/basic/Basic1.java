package java8.basic;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class Basic1 {
	public static void main(String[] args) {
		
		//TODO ������ -> $, _�� ���۰���. Ư�� �Ұ�. ��ұ���
		
		String declare; // �̰��� "����"
		//System.out.println(declare); �ʱ�ȭ ���� �ʰ� ������ �����Ͽ��� �߻�!
		declare = "�ʱ�ȭ"; // ó�� ���� �����ϴ� ���� "�ʱ�ȭ"
		
		//TODO ����Ÿ��
		byte byteNum; // ��������, ����������
		char charNum; // unsinged. 2����Ʈ
		short shortNum; // C�� ȣȯ�� ���ؼ���. �� ������� ����
		//intũ��� ���� 4����Ʈ�� �ƴ�, �ü���� ���� �����Ϸ��� �����Ѵ�. ��������!
		int intNum = Integer.MAX_VALUE; // ��� ����Ŭ������ �شܰ� ���� (�� ��ȯ�� �ݵ�� �˻�����!)
		long longNum; // ���ͷ��� l, L �ٿ��� ���. l�� �򰥷��� L ���� ���
		float floatNum; // ���ͷ��� f �� F �ٿ��� ���.
		double doubleNum;
		boolean boolNum;
		
		//TODO ������ ������ �����Ѵ�.
		byteNum = 10;
		for (int i = 0; i < 255; i++) {
			//byteNum = byteNum + 1; ������ ���� �߻�. int�� �ڵ���ȯ�Ǵϱ�..
			System.out.println(byteNum++); // ++�� �����Ͽ��� �߻����� �ʴ´�. �ٸ� ����Ʈ�ڵ�� ����
		}
		
		//TODO �⺻ �����
		//��Ʈ�� �̿�
		//intNum = System.in.read(); �Է¹��� Ű�ڵ带 10, 13���Ͽ� ĳ��������, �����ǵ带 ������ �����Ѵ�.
		/*����
	  		- BackSpace = 8
			- Tab = 9
			- CR = 13, LF = 10
			- Shift = 16
			- Ctrl = 17
			- Alt = 18
			- ESC = 27
			- Space = 32
			- PAGEUP = 33
			- PAGEDN = 34
		 */
		
		//Scanner �̿�
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�� �Է� : ");
		System.out.println("�Է� �� : " + scanner.nextLine());
		
		scanner.close();
		
		
		//TODO ����
		System.out.println("2���� : " + 0b10);
		System.out.println("8���� : " + 010);
		System.out.println("10���� : " + 10);
		System.out.println("16���� : " + 0x10);
		System.out.println("�����ڵ� : " + "\u0041"); // B�� ��µǰ�, editor������ B���ڷ� �νĵȴ�.
		
		System.out.println("2������� : " + Integer.toBinaryString(10));
		//���� ��� 0�� ���õȴ�. ���̷��� for������ؼ� ����!
		
		//TODO �ε��Ҽ���
		doubleNum = 5E7; // 5.0 * 10^7
		floatNum = (float) 0.12E-5; // E������ double�̴�. 0.12 * 10^-5
		
		//TODO Ÿ��ĳ����
		// charNum = byteNum; ������ ĳ������ ������ �����ε�, char�� unsigned�̱� ����.
		charNum = 'A' + 1; // �̰� �Ǵµ�, ���ͷ����� �����̶� �׷���.
		// byteNum = +byteNum; +�� ���׿����ڷ� ��밡���ѵ�, �ڵ����� int�� ��ȯ�ȴ�!
		intNum = shortNum = byteNum = 5; // b - s - i ������ �и��Ǿ� �����.
		
		//TODO navigator�� .class ������ ����� ��ȯ�� ����Ʈ�ڵ带 Ȯ���� �� �ִ�.
		// String + ������ �ڵ����� StringBuilder�� ����ǳ�.. JUnit���ε� Ȯ���غ���!
		
		//TODO ��Ʈ����
		// ��� ��Ʈ������ int �� ����ȯ��
		intNum = ~intNum + 1; //2�� ����
		intNum = intNum ^ intNum | intNum & intNum; // XOR, OR, AND
		intNum = intNum << 3; // <<<�� ����.
		intNum = intNum >>> 3; // ������ 0�� ä��ٴ°� MSB�� ä��� >>�� �ٸ���.
		
		//TODO �ε��Ҽ��� ���е�
		intNum = 1;
		floatNum = 0.1F;
		doubleNum = intNum - floatNum * 7;
		System.out.println("doubleNum�� �� : " + doubleNum); // 3�� �ƴ� 2.999�̴�.
		System.out.println("0.1 == 0.1F : ?" + (0.1 == 0.1F)); //false�̴�. 
		//������ ���̷��� int������� ���������� �ٲ㼭 ����ؾ� ��.
		
		//TODO double�� ArithmeticException
		// intNum = 5 / 0; //�������� �ƴ� ��Ÿ�� ������ �߻�
		doubleNum = 5.0 / 0;
		System.out.println("doubleNum�� �� : " + doubleNum); // Infinity �̴�.
		doubleNum = 5.0 % 0;
		System.out.println("doubleNum�� �� : " + doubleNum); // NaN �̴�.
		System.out.println(doubleNum == Double.NaN); // NaN�� ���� �� ����!!!
		System.out.println(Double.isNaN(doubleNum)); // ����Ŭ���� �޼���� Ȯ�ΰ���!
		
		//TODO ������
		// &&�� & �� ���� : &&�� �����򰡸� ������ &�� ���� �ʴ´�. ���ɸ鿡�� &&�� ����.
		// boolean Ÿ���� &�ε� �������� �� �ִ�.
		
		//TODO �迭
		int[] intArr = new int[5];	// ���� �ָ鼭 �ʱ�ȭ
		intArr = new int[] {1,2,3,4,5}; // ������� �ʱ�ȭ
		
		//�迭 ����
		System.arraycopy(intArr, 3, intArr, 0, 2);
		for (int i : intArr) {	// �⼧�� for��
			System.out.println(i + ", ");
		}
		
		
		//TODO ���ǹݺ���
		//���� ;�� ���̴� ���� do while �ۿ� ����. ������ switch for while if ��� �Ⱥ���
		
		Outter : for (int i = 0, j = 10; i * j > 0; i++, j--) { // �� �Ŀ��� �������� �� �� �ִ�!!
			System.out.println("for���� ���� ���� : " + (i * j));
			//break Outter;	 Lable Ż�Ⱑ��
		}
		
		switch ("�ȳ�") { // �˻繮���� ����, ���ڿ��� �� �� �ִ�.
		case "�ȳ�":
			// ~~
			break;
		default:
			break;
		}
		
		
		//TODO JVM �޸𸮱��� -> �̰��� �ڹٴ� 140��
		/* 
		 * Stack����
		 *  - thread���� �ϳ��� ����
		 *  - �޼ҵ� ȣ�⸶�� thread Stack ���ο� ���������� �߰�
		 *  - ������ > ������ > ���ú������� �����̳�ũ������� stack �����
		 *  - ������ �ƴ�, �ʱ�ȭ�ÿ� push��
		 *  - printStackTrace()�� �ϳ��� ������(�޼ҵ����)�� ǥ����.
		 *  
		 * Heap����
		 *  - ��ü�� ��������� ����
		 *  - new�����ڴ� Heap�� ���� �� ���ϰ�ü ���� �ÿ��� ���λ���.
		 *  - String�� ���, ���ͷ��� ���� ������ ���� ��ü�̳�, new�� ������ ����� ���� �ٸ� ��ü�� �ȴ�.
		 * 
		 * Method ����
		 * 	- JVM ���۽� ����
		 *  - ��� �����尡 ����
		 *  - Ŭ�����δ��� .class �ε� �� �� ����
		 *  - Class �ε�
		 *    - ��Ÿ�� ���ǥ
		 *    - �ʵ�/�޼ҵ� data
		 *    - �޼ҵ� �ڵ�
		 *    - ������ �ڵ�
		 * 
		*/
		System.out.println("new�� ������ String ������? : " + (new String("�ƾ�") == new String("�ƾ�")));
		System.out.println("���ϰ� ���ͷ� String ������? : " + ("�ƾ�"=="�ƾ�"));
		

		//TODO ����ó��
		
		// error : HW���� ������ JVM�� ��������� ���� ��. �����ڷν�� ��ó�� �Ұ����ϴ�.
		// Exception : �߸��� �ڵ����� ���� ����. �����Ϸ��� üũ�Ѵ�.
		// RuntimeException : ����ð��� �߻��ϴ� ����. �����Ϸ��� üũ���� �ʴ´�. Exception�� ��ӹ޾Ҵ�.
		// RuntimeException�� ����� ��������� ���ܴ� �����Ϸ��� üũ���� �ʴ´�.
		
		
		try(FileInputStream fis = new FileInputStream("file1.txt");
			FileOutputStream fos = new FileOutputStream("file2.txt");) { 
			// TODO try-with-resource�� ������ �����̴�. ������� ������ ()�� �����Ѵ�. ���ҽ��� �ڵ� close()���ش�.  
			// ���ܹ߻����ο� ������� ������ ���ҽ��� close()���ش�. (���ҽ� : ����, IO��Ʈ��, ä�� ���..)
			// ���ܹ߻��� close() �� catch �����Ѵ�.
			// ��� Ŭ������ java.lang.AutoCloseable �����ؾ� �Ѵ�.
			
		} catch (IOException | ClassCastException e) { // TODO ��Ƽĳġ
			// �� ���ܸ� ��� �ѹ��� e�� �޴´�.
		} catch (Exception e) { // TODO ����ĳġ
			// ���� ���ܰ� �߻����� ������ �Ʒ����� ĳġ�Ѵ�.
			// �翬�� �Ʒ��� ������ ������ Ŀ�����Ѵ�.
		} finally {
			//��������
		}
		
		//TODO ��������� Exception
		class MyException extends RuntimeException{
			//��κ� �����ڼ��� �����Ѵ�.
			//�Ʒ�ó�� �ΰ������� �Ϲ����̴�.
			public MyException() {
				super();
			}

			public MyException(String message) {
				super(message);
			}
		}
		
		//TODO throw new Exception(); : main�Լ��� throws�� JVM�� �ܼ�������� �ذ��Ѵ�. �ſ� ������ ����̴�. 
		
		
		
	}
}
