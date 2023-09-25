package java8.classex;

public class Singleton {
	//TODO 1. �ڱ� �ڽ��� private static ������ �����Ѵ�.
	private static Singleton singleton = new Singleton();
	
	//TODO 2. �����ڶ��� private�� ���� ��ȣ�Ѵ�.
	private Singleton() {}
	
	//TODO 3. public static getInstance�޼ҵ�� �ܺο� �����Ѵ�.
	public static Singleton getInstance() {
		return singleton;
	}
}
