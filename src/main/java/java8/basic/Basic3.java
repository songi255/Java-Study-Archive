package java8.basic;

import java.nio.channels.CompletionHandler;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.naming.spi.DirStateFactory.Result;

public class Basic3 {
	public static void main(String[] args) {
		//TODO Thread
		// ��Ƽ������ : �� �������� ������ ��� �����忡 ������ �ش�. ����ó���� ������ ���ؾ� �Ѵ�!
		Thread myThread = new Thread();
		
		//TODO ������⺻��
		System.out.println("������ �⺻�� : " + myThread.getName()); //Thread-n �����̴�. �뵵���� �� ����������.
		
		//TODO ���ü� vs ���ļ�
		// ���ü� : �����ư��� ó���Ͽ� ���ÿ��ϴ°�ó�� ���̴� ��.
		// ���ļ� : ��Ƽ�ھ�� ������ ���ÿ� ����ϴ� ��
		//���ļ������� �����尣 �켱����
		myThread.setPriority(Thread.NORM_PRIORITY); // �⺻ priority�� 5�̴�. 1~10 ������.
		
		//TODO ���������
		/* NEW - �����Ǿ� start()���� ���� ����
		 * RUNNABLE - �������� ������·� �� �� �ִ� ����
		 * WAITING - ����(wait())
		 * TIMED_WAITING - �ð����
		 * BLOCKED - sync �� ���
		 * TERMINATED - ����
		 * RUNNING - ����
		 * 
		 * ����������� ����� �ſ� �����ؾ� �Ѵ�.
		 * interrupt, wait, notify, yield, join, sleep ���� �ִ�.
		 * 
		 * */
		
		
		
		class A {
			//TODO synchronized �Ӱ迵�� : �޼ҵ念������ ����� �� �ִ�.
			//sycn�� ���� �޼ҵ��, ����ȭ���̴�, ���� �� �������� ����Ѵ�. ��, �ϳ��� ��ü �ȿ��� �ϳ��� �����常 sync �������డ���ϴ�.
			int counter = 0;
			Thread lastAccessedThread = null;
			
			public synchronized void syncmethod1() { //static�� �����ѵ� ���� main�Լ� ���̶� �ȵȴ�.
				while (true) {
					try {
						notify(); // ����� �������� �ʾ�����, ����� �� ����ȭ������ ���� lock�� �ɷ����� �������̴�.
						if (Thread.currentThread().isInterrupted()) { //���ͷ�Ʈ Ȯ�� �� ���Ḧ �����ϰ� �ִ�.
							break;
							//Interrupt �ܿ�, flag�� �̿��� ����� �ִ�. �ٽ��� �Ѵ� while���ѷ��� ������ �����忡 ���� ����̶�� ���̴�.
						}
						this.counter++;
						this.method1();
						if (counter >= 10) {
							Thread.currentThread().interrupt(); // interrupt�� ������ ���Ḧ �����ϰ� �ִ�.
						}
						wait();
					} catch (InterruptedException e) {
						break; // ���ͷ��� ������ �� ���ѷ����� �������´�!!
					} 
				}
			}
			
			public void method1() {
				synchronized (this) { // ����ȭ��. lock�� �ɰ���� ��ü�� �����ش�.}
					System.out.println(Thread.currentThread().getName() + " => counter : " + this.counter);
				}
			}
		}
		
		//TODO ����ȭ������ wait, notify ���� : wait�� notify�� "������ü"�� �ٽ��̴�!!
		A a = new A(); // �����۵��Ѵٸ� �� �����尡 ������ ������ �Ѵ�.
		Thread thread1 = new Thread(()->a.syncmethod1());
		Thread thread2 = new Thread(()->a.syncmethod1());
		thread1.start();
		thread2.start();
		
		
		//TODO yield : while ���ѷ��� ������ �����忡�� ��� �бⰡ false�� ���� ���� ��� CPU�纸. ���� ����
		
		//TODO join ����
		Thread thread3 = new Thread(()->{
			System.out.println("thread1 ����, 2�� �� ����!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {e.printStackTrace();}
			System.out.println("thread1 ����!");
		});
		Thread thread4 = new Thread(()->{
			System.out.println("thread2 ����, thread1 ����� ����!");
			try {
				thread1.join();
			} catch (InterruptedException e) {e.printStackTrace();}
			System.out.println("thread2 ����!");
		});
		thread3.start();
		thread4.start();
		
		//TODO Daemon������ : ��������(�ڵ�����, gc, ������.������� ��). �θ� ������ ��������ȴ�.
		// setDaemon()���� start �� ȣ���Ѵ�.
		
		//TODO ������׷�
		// ���� �����带 ��� ����. �ϰ� ���ͷ�Ʈ�� �����ϴ�.
		// ��� ������� �ϳ��� �׷쿡 �ݵ�� �ҼӵǾ��ִ�. �������� �ʾҴٸ� �ڽ��� ������ ������׷쿡 �Ҽӵȴ�.
		// ���� ó�� JVM�� ���� JVM���� System�׷��� �����ǰ�, �� �����׷����� main�׷��� �����ȴ�.
		ThreadGroup threadGroup1 = Thread.currentThread().getThreadGroup(); // ���� ������׷� �ޱ�
		ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "myThreadGroup2"); // ��������
		threadGroup1.checkAccess(); // ���� �����尡 ������׷� ��������� �ִ���?
		threadGroup2.interrupt(); // �ϰ� ���ͷ�Ʈ
		
		Thread.getAllStackTraces(); // ���μ��� �� ��� �������� ����
		for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
			System.out.println(entry); // Thread�� ����� [�������, �켱����, �Ҽӱ׷�] �̴�.
			for (StackTraceElement stack : entry.getValue()) {
				System.out.println(" - " + stack);
			}
		}
		
		//TODO ������Ǯ
		//Executor�� ������Ǯ�� �ǹ��ϴ� ��.
		//Service�� �߻����� ������Ǯ�� ���񽺸� �ǹ���.
		//ExecutorService�� ������, completionService�� �Ϸ��뺸�� �������� ����..
		
		ExecutorService executorService1 = Executors.newCachedThreadPool(); //ĳ��. �Ⱦ��� �����带 �����Ѵ�. �⺻ 60��.
		// fixed. �ִ뽺���尳�� ������ �� �ְ�, �Ƚᵵ �����尡 �����ȴ�. 
		// ���밡���� �ִ��ھ ����ϴ� �ڵ�. �����۾��� �ִ��ھ����ŭ�� �����ϴ�.
		ExecutorService executorService2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		//���� ������ �����ϴ�.
		//ExecutorService executorService3 = new ThreadPoolExecutor(�ʱ⽺�����, �ִ뽺�����, �����ð�, TimeUnit.SECONDS, �۾�ť);
		
		//������ �ƴϹǷ� ���� �������־�� �Ѵ�.
		executorService1.shutdown(); // ����. �۾��� �������� �� ���� ��ٸ���.
		executorService1.shutdownNow(); //�����������. interrupt�Ѵ�. �̿Ϸ� �۾���� ��ȯ.
		//executorService1.awaitTermination(60, TimeUnit.SECONDS); // ��ٷ��� ��, ���ͷ�Ʈ�Ѵ�. �̿Ϸ�� false��ȯ
		
		//�۾���û
		//execute. ���ϰ� ���� runnable�� ������. ���ܹ߻��� ������Ǯ�� ������� ���� �� "���ŵȴ�".
		executorService2.execute(new Runnable() { @Override public void run() {} });
		
		//submit. runnable�̳� callable �� �� �����ϴ�. Future ��ü�� ������� ��� �����Ѵ�.
		// Future��ü�� get���� ���� ��µ�, get�ϴ� ���� ���ŷ�Ǿ� �۾��Ϸ������ ���� �� �ִ�.
		// runnable�� �ϷῩ�θ� �����Ѵ�. ��������� null ��ȯ
		// ���ܰ� �߻��ص� ������Ǯ�� ������� ���ŵ��� �ʰ� ����ȴ�. -> ��������� ������带 ���̱� ���ؼ��� ������ submit�� �������!!!!
		Future<Integer> future = executorService2.submit(new Callable<Integer>() {
			@Override public Integer call() throws Exception { return 3;}});
		
		//TODO task : Runnable(���ϰ� ����) vs Callable(�۾�ó�� �� ���� ����)
		//future.get(); //����� �����´�. �۾��� ������ �ʾҴٸ� ���ŷ�ȴ�.
		future.cancel(true); // ���� �Ϸ���� �ʾҴٸ� �۾��� ���(����)�Ѵ�. false�� �� �׳� ��ٸ���. �������̸� ����
		
		//TODO ������ ������ ����� �ܺΰ�ü�� ���� 
		// ������ü Result�� ���� ��, ���� �����忡�� �� ��ü�� ����� �����Ͽ� �����Ѵ�.
		class Result{
			int sum;
			synchronized void addSum(int addValue) {this.sum += addValue;}
		}
		Result result = new Result();
		Future<Result> finalResult1 =  executorService2.submit(()->result.addSum(3), result); //result�� Future�� ���׸��� �ȴ�.
		Future<Result> finalResult2 =  executorService2.submit(()->{
			try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
			result.addSum(3);
		}, result);
		
		try {
			finalResult1.get();
			finalResult2.get(); //����� ���������� get���ŷ�� �̿��Ͽ� ��ٸ��� ���̴�.
			System.out.println(result.sum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		//TODO ����� �񵿱�ó�� (���� ó���� ���� polling)
		//���� ������Ǯ�� �̿��Ѵ�. ���� service��ü�� executor���� completion���� �ٲ� ��.
		CompletionService<Result> completionService = new ExecutorCompletionService<>(executorService2);
		completionService.submit(()->result.addSum(2),result); // executoró�� submit���� ť���Ѵ�.
		
		try { completionService.take(); // �Ϸ�� �۾��� Future ����. ������ ���ŷ 
		} catch (InterruptedException e) {e.printStackTrace();}
		completionService.poll(); // �Ϸ�� �۾��� Future ����. ������ null. Ÿ�Ӿƿ��� �� ���� �ִ�.
		
		//TODO Callback ��� ó�� : �۾��Ϸ�� ������ �޼��带 �־��ִ� ��.
		//ExecutorService�� �ݹ��� ���� ������ ����� �������� ����.
		//Runnable �ۼ� �� �ݹ��� ���������ϴ�.(�ݹ�޼��带 ���� Ŭ������ �����Ͽ� ��� -> CompletionHandler�̿��ϸ� ����)
		CompletionHandler<Result, Void> callback = new CompletionHandler<Result,Void>() {
			//<V,A>�� V�� ������� ���� ��ü(callable�̴�), A�� �߰��� �������� �Ű����̴�. ���ٸ� Void�� ������ �ȴ�. 
			@Override
			public void failed(Throwable exc, Void attachment) { //�۾� ó������ ���ܹ߻� �� ȣ��Ǵ� �ݹ�޼���
				
			}
			@Override
			public void completed(Result result, Void attachment) { // �۾� ����Ϸ�� ȣ��Ǵ� �ݹ�޼���
				
			}
		};
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					// TODO: handle exception
					callback.completed(result, null);
				} catch (Exception e) {
					callback.failed(e, null);
				}
			}
		};
		// �ᱹ task�� �����ϴ� ������Ǯ�� �����尡 �����ϴ°��̴�. ���ŷ�� Future�� ó���ϴ� �ٸ������尡, �ݹ��� �ش� task��
		// ó���� �����尡 ���� �����Ѵٴ°� �ٸ����ε� �ϴ�.
		
		executorService2.shutdown();
	}
}

//TODO �������� ����
// 1. ���ٽ����� �ٷ� ���´�. run���� �������̵��Ѵ�.
// 2. �������� �͸� �ڽİ�ü ����. run �ܿ� �޼��带 �߰��� �� ������, ThreadŸ���̱� ������ ���ο����� ����� �� �ִ�.
// 3. �������� Ȯ�� ����. ����ȭ�۾��̳�, Ŀ���� �޼��带 �߰� �� �� �ִٴ� ���� �����̴�.
class MyThread extends Thread{
	
}





