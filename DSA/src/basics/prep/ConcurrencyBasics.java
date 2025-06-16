package basics.prep;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyBasics {
	
	private static Runnable getRunnable() {
		Runnable runnable = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+"--->"+ i);
			}
		};
		return runnable;
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		
		
		try {
			executorService.submit(getRunnable()).get();
			executorService.submit(getRunnable()).get();
			// get waits for sequential finishing of each operation
			// and can be called on a future object to store the result 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		executorService.shutdown();
//		Thread thread = new Thread(ConcurrencyBasics.getRunnable());
//		Thread thread1= new Thread(ConcurrencyBasics.getRunnable());
//		try {
//			thread.start();
//			thread.join();
//			thread1.start();
//			thread1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		System.out.println(thread.getName());
//		System.out.println(thread1.getName());
		System.out.println(Thread.currentThread().getName());
	}
	
}
