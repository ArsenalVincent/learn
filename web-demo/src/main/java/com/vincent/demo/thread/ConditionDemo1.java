package com.vincent.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo1 implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();

	public void run() {
		try {
			lock.lock();
			condition.await();
			System.out.println("Thread is going on");
		} catch (InterruptedException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		ConditionDemo1 demo1 = new ConditionDemo1();
		Thread t1 = new Thread(demo1);
		t1.start();
		Thread.sleep(2000);
		lock.lock();
		condition.signal();
		lock.unlock();
	}

}
