package java8.annotaionex;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*TODO ������̼�
 * �뵵
 *  - �����Ϸ����� ��������(�ڵ幮��üũ�ϵ���) -> @Override
 *  - �ڵ� �ڵ����� ��������(����, ��ġ) -> ??
 *  - ����(��Ÿ��)�� Ư����� �����ϰ� �������� -> JUnit??
 *  - ����� �ڵ� XML���� / JAR ���� ��� ��� -> ??
 *  - ����� Ŭ������ ���� ���ǿ��� ��� -> ??
 * 
 * 
 * */

//TODO @interface�� �ۼ��Ѵ�.
//TODO @Target���� �������� �����Ѵ�.
// Target���� ������̼��̴�. �Ʒ�ó�� �������� �迭�� �����ϸ�, Target�� value�� ����ȴ�.(java.lang.annotation.ElementType Enum�̴�.

//TODO @Retention���� ������å�� �����Ѵ�. ���뵵�� ����, ����������� ������ ������ �����Ѵ�.
// java.lang.annotation.RetentionPolixcy�� Enum�̴�.
// SOURCE �ҽ��󿡼��� ��������. ��, �ҽ��ڵ� �м����� �ǹ̰� �ְ�, ����Ʈ�ڵ忡�� ���� �ʴ´�.
// CLASS ����Ʈ�ڵ���� ��������������, ���÷����� �Ұ����ϴ� -> ?? �׷� �־�
// RUNTIME ����Ʈ�ڵ� + ���÷������� ��Ÿ�ӿ� (Ŭ������ �����)������̼����� ���� �� �ִ�. �ڵ������������� �ƴ� �̻�, ��κ� �� �뵵�� ����Ѵ�.

@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnotation {
	// �Ʒ��� ���� default���� ������, �ǻ�뿡�� ���� �����ص� �ȴ�.
	int data() default 5; // ������̼��� ����ν�, ������Ʈ�� ���� �� �ִ�. (�޼ҵ�ó�� ()�� ������Ʈ�� �ڿ� �ٿ��� �Ѵ�.)
	String value(); // �⺻ ������Ʈ�� value�̴�. ������̼ǿ� ������Ʈ ���� ������� ������ �⺻������ value�� ���ȴ�. 
	
}

 class Example{
	 @MyAnotation(value = "����", data = 3) // ������̼��� ����. 
	 int myField;
	 @MyAnotation("����") // value ������Ʈ�� �ڵ�������.
	 int myField2;
	 
 }