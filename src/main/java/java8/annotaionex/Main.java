package java8.annotaionex;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) {
		//TODO ������̼��� ����
		//Class�� ����� ���� java.lang.Class�̿��ϸ� ������, �ʵ� �޼��� � ����� ���� java.lang.reflect�� ��õ�
		//Field, Constructor, Method ���� ���� �Ѵ�. �� ��, ���� �޼��带 ����Ѵ�.
		Method[] declaredMethods = Service.class.getDeclaredMethods(); // Ŭ������ ����� �޼ҵ� ���
		//Declared�� ���̴�, ��ӹ��� �� ���� �ش� �׸� ���� ����Ǿ����� ���θ� Ȯ���ϴ� ���̴�.
		for (Method method : declaredMethods) {
			if (method.isAnnotationPresent(PrintAnnotation.class)) { // ������̼� Ŭ������ ����Ǿ�����?
				PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
				
				System.out.println("[" + method.getName() + "]");
				
				for (int i = 0; i < printAnnotation.number(); i++) {
					System.out.print(printAnnotation.value());
				}
				System.out.println();
			}
			try {
				method.invoke(new Service());
			} catch (Exception e) {
				System.out.println();
			}
		}
		
	}
}

//������ ������̼�
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface PrintAnnotation{
	String value() default "-"; // ���м��� ����� ����
	int number() default 15; // �ݺ����Ƚ��
}

//������̼��� ����� Ŭ����
class Service{
	@PrintAnnotation
	public void method1() {
		System.out.println("����1");
	}
	
	@PrintAnnotation("*")
	public void method2() {
		System.out.println("����2");
	}
	
	@PrintAnnotation(value = "#", number = 20)
	public void method3() {
		System.out.println("����3");
	}
}