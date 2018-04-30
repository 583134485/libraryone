package com.guo.ssm.test;

public class volatiletest {
	
	//demo volatile不具备原子性操作 显示一个比 1000*10小的 数字
    public volatile int inc = 0;
    
    public void increase() {
        inc++;
    }
 
    public static void main(String[] args) {
        final volatiletest test = new volatiletest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
 
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
        
    }

}
