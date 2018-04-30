package com.guo.ssm.test;

//多线程 的 demo 测试  学习
// 
public class threaddemo extends Thread{  
	 private String name; 
	private int a=10;
	public threaddemo(String name) {  
	super();  
	this.name = name;  
	}  
	
	
	public  void run(){  
	for(int i=0;i<20;i++){ 
        if (a>0) {  
            try {  
                Thread.sleep(100);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            System.out.println(Thread.currentThread().getName()+"卖票 :ticket="+a--);  
    }  
	  
	}  
	}
	
	}  
