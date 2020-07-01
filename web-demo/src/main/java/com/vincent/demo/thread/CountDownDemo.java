package com.vincent.demo.thread;

import java.awt.Checkbox;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownDemo implements Runnable{
	static final CountDownLatch end = new CountDownLatch(10);
	static final CountDownDemo demo = new CountDownDemo();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(new Random().nextInt(10) * 1000);
			System.out.println("check complete");
			end.countDown();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		for(int i=0; i<10; i++) {
			exec.submit(demo);
		}
		end.await();
		System.out.println("fire");
		exec.shutdown();
	}
}
