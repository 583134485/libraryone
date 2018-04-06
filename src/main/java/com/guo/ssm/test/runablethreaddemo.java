package com.guo.ssm.test;

public class runablethreaddemo  implements Runnable{  
	private String name; 
	private int ticket=10;
	public runablethreaddemo(String name) {  
	this.name = name;  
	}

//	public void run(){  
//	for(int i=0;i<100;i++){  
//	System.out.println("线程开始："+this.name+",i="+i);  
//	}  
//	}  
	
	public   void run(){  
		for(int i=0;i<10;i++){  
            if (ticket>0) {
            	System.out.println(Thread.currentThread().getName()+"卖票 :ticket="+ticket--);
                try {  
                    
                    Thread.sleep(100);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
  
        }  
		}  
		}  
	}; 
