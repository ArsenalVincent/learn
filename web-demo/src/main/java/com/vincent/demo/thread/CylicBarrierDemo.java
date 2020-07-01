package com.vincent.demo.thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CylicBarrierDemo {
	public static class Soldier implements Runnable {
		private String soldier;

		private CyclicBarrier cyclic;

		public Soldier(CyclicBarrier cyclic, String name) {
			this.cyclic = cyclic;
			this.soldier = name;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				cyclic.await();
				doWork();
				cyclic.await(); 
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		void doWork() {
			try {
				Thread.sleep(Math.abs(new Random().nextInt() % 10000));
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println( soldier + ":任务完成");
		}

	}
	
	public static class BarrierRun implements Runnable{
		boolean flag;
		int N;
		public BarrierRun(boolean flag, int N) {
			// TODO Auto-generated constructor stub
			this.flag = flag;
			this.N = N;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(flag) {
				System.out.println("司令:[士兵" + N + "个，任务完成!");
			}else {
				System.out.println("司令:[士兵" + N + "个，集合完毕!");
			}
		}
		
	}
	
	public static void main(String[] args) { 
		final int N = 10;
	}

}
