package com.guo.ssm.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl  extends UnicastRemoteObject implements IService{

	 protected ServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}



	/** 
     */  
    private static final long serialVersionUID = 682805210518738166L;  
  
  
  
    /* (non-Javadoc) 
     * 
     */  
    @Override  
    public String queryName(String no) throws RemoteException {  
        // 方法的具体实现  
        System.out.print("hello" + no);  
        return String.valueOf(System.currentTimeMillis());  
    }  
}
