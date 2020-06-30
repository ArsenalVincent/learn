package com.vincent.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

public class Reenterlock2 implements Runnable {
	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	int lock;

	/* 控制枷锁顺序，构造死锁 */
	public Reenterlock2(int lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			if (lock == 1) {
				lock1.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
					
				}
				lock2.lockInterruptibly();
			}else {
				lock2.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				lock1.lockInterruptibly();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(lock1.isHeldByCurrentThread()) {
				lock1.unlock();
			}
			if(lock2.isHeldByCurrentThread()) {
				lock2.unlock();
			}
			System.out.println(Thread.currentThread().getId() + ": 线程退出");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Reenterlock2 r1 = new Reenterlock2(1);
		Reenterlock2 r2 = new Reenterlock2(2);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start(); t2.start();
		Thread.sleep(1000);
	}
}
