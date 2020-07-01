package com.vincent.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock  implements Runnable{
	
	public static ReentrantLock lock = new ReentrantLock();
	public static int i=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int j=0; j< 10000000; j++) {
			lock.lock();
			lock.lock();
			try {
				i++;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				lock.unlock();
				lock.unlock(); // 可重入锁，每加一次锁 就需要单独再解一次锁
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReenterLock tl = new ReenterLock();
		Thread t1 = new Thread(tl);
		Thread t2 = new Thread(tl);
		t1.start();t2.start();
		t1.join(); t2.join();
		System.out.println(i);
	}
}
