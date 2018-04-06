package com.guo.ssm.test;

//总结：无论是runable和thread 的区别 
// 实现 实际中的  数据 共享 应该   加锁
//synchronized
public class maintest {

	public static void main(String[] args) {
		threaddemo mt1 = new threaddemo("线程a");
		threaddemo mt2 = new threaddemo("线程b");
		// run和start的区别
		// mt1.run();
		// mt2.run();

		// 同一个thread 放在 两个 thread线程中
//		new Thread(mt1, "tt2").start();
//	
//		new Thread(mt1, "tt1").start();
		


		// mt1.start();
		// mt2.start();
		// 实现runable接口
//		 runablethreaddemo mt3 = new runablethreaddemo("线程c");
//		 runablethreaddemo mt4 = new runablethreaddemo("线程d");
//		 new Thread(mt3).start();
//		 new Thread(mt4).start();

		// 同一个runable 放在 三个线程中  用sychronized修饰 等一个线程全部执行晚才下一个
		runablethreaddemo mt5 = new runablethreaddemo("线程e");
		new Thread(mt5,"one").start(); // 同一个mt，但是在Thread中就不可以，如果用同一
		new Thread(mt5,"two").start(); // 个实例化对象mt，就会出现异常
		new Thread(mt5,"three").start();

		// 以上例子 不能 体现 共享 用用一个对象当然共享 数据
		// 实际使用 需 要 加 线程锁
//		 System.out.println("Main方法的优先级为:"+Thread.currentThread().getPriority());//主方法的优先级为NORM_PRIORITY
//		 MyRunnable r = new MyRunnable();
//		 Thread t1 = new Thread(r);
//		 Thread t2 = new Thread(r);
//		 Thread t3 = new Thread(r);
//		 t1.start();
//		 t2.start();
//		 t3.start();

	}

}
