package java8.enumex;

public class Main {
	public static void main(String[] args) {
		// heap�� ������ Week.FRIDAY ��ü�� ����Ų��.
		Week today = Week.FRIDAY;
		
		//java.lang.Enum Ŭ������ �ڵ�����ϹǷ� ���� �޼������ �� �� �ִ�!
		System.out.println(today.ordinal()); // 0���� ����
	}
}
