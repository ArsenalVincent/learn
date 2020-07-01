package com.vincent.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 互斥锁，排他锁
 * @author vincent
 *
 */
public class SemaphoreDemo implements Runnable {
	final Semaphore semp = new Semaphore(5);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			semp.acquire();
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getId() + "done!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			semp.release(2);
		}
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(20);
		final SemaphoreDemo demo = new SemaphoreDemo();
		for(int i=0; i<20;i++) {
			exec.submit(demo);
		}
	}
}
